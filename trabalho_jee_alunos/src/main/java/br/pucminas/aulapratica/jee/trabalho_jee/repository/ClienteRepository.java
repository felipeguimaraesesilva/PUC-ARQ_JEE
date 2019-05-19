package br.pucminas.aulapratica.jee.trabalho_jee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;

public class ClienteRepository {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public ClienteEntity salvar(ClienteEntity cliente) {
		em.persist(cliente);
		return cliente;
	}

	public List<ClienteEntity> getAllClientes() {
		TypedQuery<ClienteEntity> query = em.createQuery("SELECT c FROM ClienteEntity c", ClienteEntity.class);
		return query.getResultList();
	}

	public Long checkCpfExists(String cpf) {

		String sql = "SELECT count(1) FROM ClienteEntity c where c.cpf = ?";

		TypedQuery<Long> query = em.createQuery(sql, Long.class);
		query.setParameter(1, cpf);

		return query.getSingleResult();
	}

}
