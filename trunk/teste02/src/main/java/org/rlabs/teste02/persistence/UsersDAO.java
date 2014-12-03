package org.rlabs.teste02.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.rlabs.teste02.domain.Users;

@PersistenceController
public class UsersDAO extends JPACrud<Users, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	/** 
	 * Buscar um usuario atraves dos parametros informados (SOMENTE ATIVOS)
	 * @param login
	 * @param senha
	 * @return Objeto Usuario
	 */
	@SuppressWarnings("unchecked")
	public Users getByLogin(String login, Boolean somenteAtivos) {
String qr = "SELECT u FROM Users u WHERE u.user_login = :pLogin";
		
		List<Users> usuarios;
		
		if (somenteAtivos) {
			qr += " AND u.user_ativo = :pAtivo";
			
			usuarios = em.createQuery(qr)
					.setParameter("pLogin", login.toLowerCase())
					.setParameter("pAtivo", true)
					.getResultList();
		} else {
			usuarios = em.createQuery(qr)
					.setParameter("pLogin", login.toLowerCase())
					.getResultList();
		}
		
		if (!usuarios.isEmpty()) {
			return usuarios.get(0);
		} else {
			return null;
		}
		
	}

	/** 
	 * Buscar uma lista de usuarios Ativos
	 * @param pAtivo
	 * @return List<Users>
	 */
	public List<Users> getAtivos() {
		String qr = "SELECT u FROM Users u WHERE u.user_ativo = :pAtivo";
		
		@SuppressWarnings("unchecked")
		 List<Users> usuarios = em.createQuery(qr)
				.setParameter("pAtivo", true)
				.getResultList();
		
		return usuarios;
	}

	public Users getByLogin(String login, String md5) {
		String qr = "SELECT u "
				+ "FROM Users u "
				+ "WHERE u.user_login = :pLogin "
				+ "AND u.user_senha = :pSenha "
				+ "AND u.user_ativo = :pAtivo"
				+ "AND u.user_excluido = :pExcluido";
		
		@SuppressWarnings("unchecked")
		List<Users> usuarios = em.createQuery(qr)
				.setParameter("pLogin", login.toLowerCase())
				.setParameter("pSenha", md5)
				.setParameter("pAtivo", true)
				.setParameter("pExcluido", false)
				.getResultList();
		
		if (!usuarios.isEmpty()) {
			return usuarios.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Retorna uma lista de usuários pertencentes ao codigo indicado
	 */
	public List<Users> getByPerfil(String codigoPerfil) {
		String qr = "SELECT u "
				+ "FROM Users u "
				+ "WHERE u.user_perfil.perf_codigo = :pcodigoPerfil "
				+ "AND u.user_ativo = :pAtivo "
				+ "ORDER BY u.user_nome ASC";
		
		@SuppressWarnings("unchecked")
		 List<Users> usuarios = em.createQuery(qr)
				.setParameter("pcodigoPerfil", codigoPerfil)
				.setParameter("pAtivo", true)				
				.getResultList();
		
		return usuarios;
	}


	
	/** 
	 * Buscar uma lista de usuarios exceto aqueles com perfil Administrador
	 * @param pAtivo
	 * @param pPerfilCodigo
	 * @return List<Usuario>
	 */
	public List<Users> findExceptAdm(){
		
		String qr = "SELECT u "
				+ "FROM Users u "
				+ "WHERE u.user_perfil.perf_codigo <> :pPerfilCodigo";
		
		@SuppressWarnings("unchecked")
		 List<Users> usuarios = em.createQuery(qr)
				.setParameter("pPerfilCodigo", "ADMINISTRADOR")
				.getResultList();
		
		return usuarios;
	}

}
