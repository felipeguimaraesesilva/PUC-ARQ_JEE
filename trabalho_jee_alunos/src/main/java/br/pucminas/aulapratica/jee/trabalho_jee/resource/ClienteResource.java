package br.pucminas.aulapratica.jee.trabalho_jee.resource;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ClienteResource {

	private Long id;

	@NotNull
	@Size(min = 15, max = 300)
	private String nome;

	@NotNull
	@Size(max = 11, min = 11, message = "CPF deve possuir 11 caracteres")
	private String cpf;

	private Date dataNascimento;

	private String email;
}
