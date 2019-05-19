package br.pucminas.aulapratica.jee.trabalho_jee.exception;

public class CnpjJaExistenteException extends RuntimeException {

	private static final long serialVersionUID = -1816600114543260835L;

	public CnpjJaExistenteException() {
		super("CNPJ ja cadastrado");
	}
}
