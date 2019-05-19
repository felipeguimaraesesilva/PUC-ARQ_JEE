package br.pucminas.aulapratica.jee.trabalho_jee.resource;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FornecedorResource {

	private Long id;

	@NotNull
	private String razaoSocial;

	@NotNull
	private String cnpj;

	@NotNull
	private String inscricaoMunicipal;
	private String endereco;
	private String email;
}
