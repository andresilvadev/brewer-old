package com.algaworks.brewer.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.brewer.model.Usuario;

public class UsuariosImpl implements UsuariosQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Optional<Usuario> porEmailEAtivo(String email) {
		return manager
				.createQuery("FROM Usuario WHERE lower(email) = lower(:email) and ativo = true", Usuario.class)
				.setParameter("email", email).getResultList().stream().findFirst();
	}

	@Override
	public List<String> permissoes(Usuario usuario) {
		return manager
				.createQuery(
					"SELECT DISTINCT p.nome FROM Usuario u"
					+ " INNER JOIN u.grupos g"
					+ " INNER JOIN g.permissoes p"
					+ " WHERE u = :usuario", String.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}
	
	

}
