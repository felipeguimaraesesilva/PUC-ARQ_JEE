package br.pucminas.aulapratica.jee.trabalho_jee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Fornecedor")
public class FornecedorEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String razaoSocial;
	private String cnpj;
	private String inscricaoMunicipal;
	private String endereco;
	private String email;
}
