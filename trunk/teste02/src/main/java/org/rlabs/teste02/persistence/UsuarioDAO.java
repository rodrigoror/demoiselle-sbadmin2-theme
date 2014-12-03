/*package org.rlabs.teste02.persistence;


import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.sp.sjc.fadenp2.domain.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	*//** 
	 * Buscar um usuario atraves dos parametros informados (SOMENTE ATIVOS)
	 * @param login
	 * @param senha
	 * @return Objeto Usuario
	 *//*
	public Usuario getByLogin(String login, String senha){
		
		String qr = "SELECT u "
				+ "FROM Usuario u "
				+ "WHERE u.usua_login = :pLogin "
				+ "AND u.usua_senha = :pSenha "
				+ "AND u.usua_ativo = :pAtivo";
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = em.createQuery(qr)
				.setParameter("pLogin", login.toLowerCase())
				.setParameter("pSenha", senha)
				.setParameter("pAtivo", true)
				.getResultList();
		
		if (!usuarios.isEmpty()) {
			return usuarios.get(0);
		} else {
			return null;
		}
	}
	

	*//** 
	 * Buscar um usuario atraves dos parametros informados (SOMENTE ATIVOS)
	 * @param login
	 * @param senha
	 * @return Objeto Usuario
	 *//*
	@SuppressWarnings("unchecked")
	public Usuario getByLogin(String login, boolean somenteAtivos){
		
		String qr = "SELECT u FROM Usuario u WHERE u.usua_login = :pLogin";
		
		List<Usuario> usuarios;
		
		if (somenteAtivos) {
			qr += " AND u.usua_ativo = :pAtivo";
			
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
	
	
	*//** 
	 * Buscar uma lista de usuarios Ativos
	 * @param pAtivo
	 * @return List<Usuario>
	 *//*
	public List<Usuario> getAtivos(){
		
		String qr = "SELECT u FROM Usuario u WHERE u.usua_ativo = :pAtivo";
		
		@SuppressWarnings("unchecked")
		 List<Usuario> usuarios = em.createQuery(qr)
				.setParameter("pAtivo", true)
				.getResultList();
		
		return usuarios;
	}
	

	public List<Usuario> getByPerfil(Long idPerfil){
		
		String qr = "SELECT u FROM Usuario u WHERE u.usua_perfil.perf_id = :pIdPerfil";
		
		@SuppressWarnings("unchecked")
		 List<Usuario> usuarios = em.createQuery(qr)
				.setParameter("pIdPerfil", idPerfil)
				.getResultList();
		
		return usuarios;
	}
	

	public List<Usuario> getByPerfil(String codigoPerfil){
		
		String qr = "SELECT u "
				+ "FROM Usuario u "
				+ "WHERE u.usua_perfil.perf_codigo = :pcodigoPerfil "
				+ "AND u.usua_ativo = :pAtivo "
				+ "ORDER BY u.usua_nome ASC";
		
		@SuppressWarnings("unchecked")
		 List<Usuario> usuarios = em.createQuery(qr)
				.setParameter("pcodigoPerfil", codigoPerfil)
				.setParameter("pAtivo", true)				
				.getResultList();
		
		return usuarios;
	}
	
	
	*//**
	 * Retorna uma lista dos GERENTES e SUPERVISORES ativos
	 * @return
	 *//*
	public List<Usuario> getGerentesESupervisores(){
		
		String qr = "SELECT u FROM Usuario u " + 
				"WHERE ((u.usua_perfil.perf_codigo = :pCodigoGerente) " + 
				"OR (u.usua_perfil.perf_codigo = :pCodigoSupervisor)) " + 
				"AND u.usua_ativo = :pAtivo " + 
				"ORDER BY u.usua_nome ASC";
		
		@SuppressWarnings("unchecked")
		 List<Usuario> usuarios = em.createQuery(qr)
				.setParameter("pCodigoGerente", "GERENTE")
				.setParameter("pCodigoSupervisor", "SUPERVISOR")
				.setParameter("pAtivo", true)
				.getResultList();
		
		return usuarios;
		
	}
	
	
	*//** 
	 * Buscar uma lista de usuarios exceto aqueles com perfil Administrador
	 * @param pAtivo
	 * @param pPerfilCodigo
	 * @return List<Usuario>
	 *//*
	public List<Usuario> findExceptAdm(){
		
		String qr = "SELECT u FROM Usuario u WHERE u.usua_perfil.perf_codigo <> :pPerfilCodigo";
		
		@SuppressWarnings("unchecked")
		 List<Usuario> usuarios = em.createQuery(qr)
				.setParameter("pPerfilCodigo", "ADMINISTRADOR")
				.getResultList();
		
		return usuarios;
	}
	
}
*/