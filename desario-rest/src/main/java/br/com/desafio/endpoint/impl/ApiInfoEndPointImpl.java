package br.com.desafio.endpoint.impl;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.desafio.dto.ApiInfoDTO;
import br.com.desafio.endpoint.ApiInfoEndPoint;

public class ApiInfoEndPointImpl implements ApiInfoEndPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiInfoEndPointImpl.class);

    private static final String BUNDLE_NAME = "api_info";
    private static final String BUNDLE_PROPERTY_PROJETO = "PROJETO";
    private static final String BUNDLE_PROPERTY_VERSAO = "VERSAO";
    private static final String MSG_ERRO = "Não foi possível obter os detalhes técnicos da API";
    private static final String ERRO_OBETER_KEY = "Não foi possível obter a propriedade(key)";
    private static final String ERRO_INESPERADO_SISTEMA = "Erro ao obter informações técnicas da API";

    @Override
    public Response getInfo() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
            return Response.ok().entity(new ApiInfoDTO(bundle.getString(BUNDLE_PROPERTY_PROJETO),
                    bundle.getString(BUNDLE_PROPERTY_VERSAO))).build();
        } catch (MissingResourceException e) {
            LOGGER.info(ERRO_OBETER_KEY, e);
            return Response.ok(ERRO_OBETER_KEY).build();
        } catch (Exception e) {
            LOGGER.info(ERRO_INESPERADO_SISTEMA, e);
            return Response.ok(MSG_ERRO).build();

        }
    }
}
