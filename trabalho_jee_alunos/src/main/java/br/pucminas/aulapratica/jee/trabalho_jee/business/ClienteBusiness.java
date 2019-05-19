package br.pucminas.aulapratica.jee.trabalho_jee.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;
import br.pucminas.aulapratica.jee.trabalho_jee.exception.CpfJaExistenteException;
import br.pucminas.aulapratica.jee.trabalho_jee.repository.ClienteRepository;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;

@Stateless
public class ClienteBusiness {

	@Inject
	private ClienteRepository repository;

	public void salvarCliente(ClienteResource clienteResource) {
		checkDuplicatedCpf(clienteResource.getCpf());
		repository.salvar(toEntity(clienteResource));
	}

	private void checkDuplicatedCpf(String cpf) {
		if (repository.checkCpfExists(cpf) >= 1) {
			throw new CpfJaExistenteException();
		}
	}

	public List<ClienteResource> getAllClientes() {
		return toResource(repository.getAllClientes());
	}

	private ClienteEntity toEntity(ClienteResource cr) {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setCpf(cr.getCpf());
		cliente.setDataNascimento(cr.getDataNascimento());
		cliente.setEmail(cr.getEmail());
		cliente.setNome(cr.getNome());

		return cliente;
	}

	private List<ClienteResource> toResource(List<ClienteEntity> allClientes) {
		List<ClienteResource> result = new ArrayList<>();

		allClientes.stream().forEach(clienteEntity -> {
			ClienteResource c = new ClienteResource();
			c.setId(clienteEntity.getId());
			c.setNome(clienteEntity.getNome());
			c.setCpf(clienteEntity.getCpf());
			c.setEmail(clienteEntity.getEmail());
			c.setDataNascimento(clienteEntity.getDataNascimento());

			result.add(c);
		});

		return result;
	}

}
