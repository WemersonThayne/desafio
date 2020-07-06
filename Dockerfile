#set latest jboss/base-jdk:11 image as the base
FROM adoptopenjdk/openjdk12:latest

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 17.0.1.Final
ENV WILDFLY_SHA1 2d4778b14fda6257458a26943ea82988e3ae6a66
ENV JBOSS_HOME /opt/jboss/wildfly
ENV HOME /root
RUN useradd -ms /bin/bash jboss


# Set the Datasource env variable
ARG DB_CONNECTION_URL_ARG
ARG DB_USER_ARG
ARG DB_PASSWORD_ARG

ENV DB_CONNECTION_URL=$DB_CONNECTION_URL_ARG
ENV DB_USER=$DB_USER_ARG
ENV DB_PASSWORD=$DB_PASSWORD_ARG

USER root
RUN mkdir /opt/jboss
# ADD wildfly-17.0.1.Final.tar.gz /root
RUN ls $HOME
# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz \
    && chown -R jboss:0 ${JBOSS_HOME} \
    && chmod -R g+rw ${JBOSS_HOME}


# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true


# Change default locale to pt_BR
ENV LANG='pt_BR.UTF-8' LANGUAGE='pt_BR:pt' LC_ALL='pt_BR.UTF-8'


RUN apt-get update \
    && apt-get install -y --no-install-recommends curl ca-certificates locales \
    && echo "pt_BR.UTF-8 UTF-8" >> /etc/locale.gen \
    && locale-gen pt_BR.UTF-8 \
    && rm -rf /var/lib/apt/lists/*


# Install fonts
RUN apt-get update \
     && apt-get install --assume-yes apt-utils \
     && apt-get install --assume-yes software-properties-common \
     && apt-get install --assume-yes dbus \
     && apt-get install --assume-yes glib-networking \
     && apt-get install --assume-yes libnih-dbus-dev \
     && apt-get install --assume-yes dconf-cli \
     && apt-get install --assume-yes fontconfig


USER jboss
ADD com.tar.gz ${JBOSS_HOME}/modules
COPY standalone.xml ${JBOSS_HOME}/standalone/configuration
COPY desafio-ear/target/desafio.ear /opt/jboss/wildfly/standalone/deployments/


# Expose the ports we're interested in
EXPOSE 8080


# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

