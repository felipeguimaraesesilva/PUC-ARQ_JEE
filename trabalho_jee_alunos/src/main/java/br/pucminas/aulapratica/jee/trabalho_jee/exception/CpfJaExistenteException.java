package br.pucminas.aulapratica.jee.trabalho_jee.exception;

public class CpfJaExistenteException extends RuntimeException {

	private static final long serialVersionUID = -1816600114543260835L;

	public CpfJaExistenteException() {
		super("CPF ja cadastrado");
	}
}
