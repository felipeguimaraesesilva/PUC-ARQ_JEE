package br.pucminas.aulapratica.jee.trabalho_jee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.pucminas.aulapratica.jee.trabalho_jee.business.FornecedorBusiness;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.FornecedorResource;
import lombok.Data;

@Data
@Model
public class FornecedorBean {

	@EJB
	private FornecedorBusiness fornecedorBusiness;

	private FornecedorResource fornecedor = new FornecedorResource();
	private List<FornecedorResource> fornecedores = new ArrayList<>();

	public FornecedorBean() {
	}

	public void salvarFornecedor() {
		try {
			fornecedorBusiness.salvarFornecedor(fornecedor);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor inserido com sucesso", "");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	public String redirecionarParaListagem() {
		getAllFornecedores();
		return "fornecedorListagem.jsf";
	}

	public String redirecionarParaCadastro() {
		return "fornecedorCadastro.jsf";
	}

	public void getAllFornecedores() {
		fornecedores = fornecedorBusiness.getAllFornecedores();
	}

}
