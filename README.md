# Projeto Desafio


Projeto com os módulos(camadas) que compõem o sistema.

As instruções abaixo vão demonstrar alguns pontos importantes para o desenvolvimento do projeto.


* OpenJDK 12.0.2;
* Wildfly 17.0.1.Final
* Maven 3.x.;

```
mvn test
```


O implantável deverá ser adicionado ao servidor de aplicação Wildfly 17.0.1


Para gerenciamento das dependências e build do projeto utilizamos o Maven.

* [Maven](https://maven.apache.org/) - Gerenciador de dependências e build do projeto.


### 1.0 - Configuração docker

O projeto Perícia utiliza o docker como contexto.

### 1.1	Regras para build da imagem

    1-Executar o camando de build maven no diretório do super pom.xml
    
        mvn clean install

    2-O seguinte comando deverá ser utilizado para a criação da imagem Docker:
    
        docker build -t desafio_backend:<version> --build-arg='DB_CONNECTION_URL_ARG=jdbc:jdbc:postgresql://<db_host>:<db_port>/<db_name>' --build-arg='DB_USER_ARG=<db_username>' --build-arg='DB_PASSWORD_ARG=<db_password>' --no-cache .

Legenda:

- **DB_CONNECTION_URL_ARG**: Url de conexão com o banco de dados;
- **DB_USER_ARG**: Credencial de acesso: username; 
- **DB_PASSWORD_ARG**: Credencial de acesso: password; 


### 1.1	Regras para execução da imagem

    O seguinte comando deverá ser utilizado para a execução do container Docker:
    
        docker run -t -i -p 8080:8080 desafio_backend:<version> 

### 1.2	Executar o docker-compose do Banco de dados 

    O seguinte comando deverá ser utilizado para a execução do container Docker do banco de dados :
    
        docker-compose up -d

Legenda:

- **8080**: Porta de acesso a api rest;

