package br.pucminas.aulapratica.jee.trabalho_jee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.FornecedorEntity;

public class FornecedorRepository {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public FornecedorEntity salvar(FornecedorEntity fornecedor) {
		em.persist(fornecedor);
		return fornecedor;
	}

	public List<FornecedorEntity> getAllFornecedores() {
		TypedQuery<FornecedorEntity> query = em.createQuery("SELECT c FROM FornecedorEntity c", FornecedorEntity.class);
		return query.getResultList();
	}

	public Long checkCnpjExists(String cnpj) {

		String sql = "SELECT count(1) FROM FornecedorEntity f where f.cnpj = ?";

		TypedQuery<Long> query = em.createQuery(sql, Long.class);
		query.setParameter(1, cnpj);

		return query.getSingleResult();
	}

}
