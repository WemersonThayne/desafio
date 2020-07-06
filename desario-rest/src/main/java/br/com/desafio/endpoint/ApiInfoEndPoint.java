package br.com.desafio.endpoint;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/info")
@Tag(name = "Versão da API ", description = "Retorna a versão da API")
public interface ApiInfoEndPoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getInfo();
}
