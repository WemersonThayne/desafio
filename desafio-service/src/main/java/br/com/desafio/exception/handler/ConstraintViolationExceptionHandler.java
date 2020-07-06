package br.com.desafio.exception.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Handler para padronização nas exceções de Beans Validations
 *
 * @author wemerson.vitalporto
 *
 */
@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException constraintViolationException) {

		List<String> mensagens = new ArrayList<>();

		Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();

		constraintViolations.stream()
				.map(constraintViolation -> mensagens.add(constraintViolation.getMessage()))
				.collect(Collectors.toList());

		return Response.status(Status.BAD_REQUEST).entity(mensagens).type(MediaType.APPLICATION_JSON).build();

	}

}
