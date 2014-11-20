package org.rlabs.teste02.persistence;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.rlabs.teste02.domain.Users;

@PersistenceController
public class UsersDAO extends JPACrud<Users, Long> {

	private static final long serialVersionUID = 1L;

	public Users getByLogin(String login, boolean b) {
		// TODO Criar metodo que recebe login e um boolean B ??? Auto-generated method stub
		return null;
	}

	public List<Users> getAtivos() {
		// TODO gerar metodo de ativos Auto-generated method stub
		return null;
	}

	public List<Users> findExceptAdm() {
		// TODO Criar metodo para pesquisar todos exceto ADM ??? melhorar esta função Auto-generated method stub
		return null;
	}

	public Users getByLogin(String login, String md5) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> getByPerfil(String codigoPerfil) {
		// TODO Criar uma lista que retorne todos os usuários por perfil Auto-generated method stub
		return null;
	}

	public List<Users> getGerentesESupervisores() {
		// TODO Criar uma lista que retorne apenas gerentes e supervisores ???? melhorar esta função Auto-generated method stub
		return null;
	}
	

}
