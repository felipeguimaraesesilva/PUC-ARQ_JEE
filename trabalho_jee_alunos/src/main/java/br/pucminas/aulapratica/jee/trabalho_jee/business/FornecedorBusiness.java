package br.pucminas.aulapratica.jee.trabalho_jee.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.FornecedorEntity;
import br.pucminas.aulapratica.jee.trabalho_jee.exception.CnpjJaExistenteException;
import br.pucminas.aulapratica.jee.trabalho_jee.repository.FornecedorRepository;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.FornecedorResource;

@Stateless
public class FornecedorBusiness {

	@Inject
	private FornecedorRepository repository;

	public void salvarFornecedor(FornecedorResource fornecedorResource) {
		checkDuplicatedCnpj(fornecedorResource.getCnpj());
		repository.salvar(toEntity(fornecedorResource));
	}

	private void checkDuplicatedCnpj(String cnpj) {
		if (repository.checkCnpjExists(cnpj) >= 1) {
			throw new CnpjJaExistenteException();
		}
	}

	public List<FornecedorResource> getAllFornecedores() {
		return toResource(repository.getAllFornecedores());
	}

	private FornecedorEntity toEntity(FornecedorResource cr) {
		FornecedorEntity entity = new FornecedorEntity();
		entity.setCnpj(cr.getCnpj());
		entity.setEmail(cr.getEmail());
		entity.setEndereco(cr.getEndereco());
		entity.setInscricaoMunicipal(cr.getInscricaoMunicipal());
		entity.setRazaoSocial(cr.getRazaoSocial());
		return entity;
	}

	private List<FornecedorResource> toResource(List<FornecedorEntity> allFornecedores) {
		List<FornecedorResource> result = new ArrayList<>();

		allFornecedores.stream().forEach(entity -> {
			FornecedorResource c = new FornecedorResource();
			c.setId(entity.getId());
			c.setCnpj(entity.getCnpj());
			c.setEmail(entity.getEmail());
			c.setEndereco(entity.getEndereco());
			c.setInscricaoMunicipal(entity.getInscricaoMunicipal());
			c.setRazaoSocial(entity.getRazaoSocial());

			result.add(c);
		});

		return result;
	}

}
