package br.pucminas.aulapratica.jee.trabalho_jee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.pucminas.aulapratica.jee.trabalho_jee.business.ClienteBusiness;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;


@Model
public class ClienteBean {

	@EJB
	private ClienteBusiness clienteBusiness;
	
	private ClienteResource cliente = new ClienteResource();
	private List<ClienteResource> clientes = new ArrayList<>();
	
	public ClienteBean() {
	}

	public void salvarCliente() {
		try {
			clienteBusiness.salvarCliente(cliente);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente inserido com sucesso","");
			FacesContext.getCurrentInstance().addMessage("", message);
		}catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}
	
	public String redirecionarParaListagem() {
		getAllClientes();
		return "clienteListagem.jsf";
	}
	
	public String redirecionarParaCadastro() {
		return "clienteCadastro.jsf";
	}
	
	public void getAllClientes() {
		clientes = clienteBusiness.getAllClientes();
	}


	public ClienteResource getCliente() {
		return cliente;
	}


	public void setCliente(ClienteResource cliente) {
		this.cliente = cliente;
	}


	public List<ClienteResource> getClientes() {
		return clientes;
	}


	public void setClientes(List<ClienteResource> clientes) {
		this.clientes = clientes;
	}

}
