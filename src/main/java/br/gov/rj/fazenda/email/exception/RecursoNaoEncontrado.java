package br.gov.rj.fazenda.email.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecursoNaoEncontrado extends Exception {

	private static final long serialVersionUID = 1L;

}