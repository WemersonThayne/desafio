package br.com.desafio.endpoint;


import javax.validation.constraints.NotNull;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.desafio.dto.CnesDTO;
import br.com.desafio.dto.PaginacaoDTO;
import br.com.desafio.persistence.model.Cnes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/cnes")
@Tag(name = "Cnes", description = "Cadastro Nacional de Estabelecimentos de Saúde (CNES) no Brasil")
public interface CnesEndPoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Recurso para listar todos Cnes", summary = "Todos os Estabelecimentos.", responses = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = Cnes.class)))),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	PaginacaoDTO<CnesDTO> listar(@NotNull @BeanParam PaginacaoDTO<CnesDTO> paginacaoDTO);
}
