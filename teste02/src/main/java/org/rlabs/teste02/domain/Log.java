package org.rlabs.teste02.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;

/*import br.gov.sp.sjc.fadenp2.util.AcaoEnum;
import br.gov.sp.sjc.fadenp2.util.EntidadeEnum;*/

/**
 * Classe responsavel por registrar todos os Logs dos Usuarios
 * @see
 * @author  rodrigo.ramos
 */
@Entity
@Table(name="LOG"/*, schema="FADENP"*/)
//@SequenceGenerator(name="sq_log", sequenceName="FADENP.SQ_LOG")
public class Log implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="log_id"
	 */
	@Id
	//@GeneratedValue(generator="sq_log")
	@Column (name="log_id")
	private Long log_id;

	/**
	 * @uml.property  name="log_acao"
	 * @uml.associationEnd  
	 */
	@Column (name="log_acao", nullable=false, columnDefinition="varchar2(50)") //,CONSTRAINT cons_log_acao CHECK (log_acao IN ('CADASTRADO', 'DELETADO', 'ALTERADO','PESQUISADO')),")
	@Enumerated (EnumType.STRING)
	private AcaoEnum log_acao;

	/**
	 * @uml.property  name="log_entidade"
	 * @uml.associationEnd  
	 */
	@Column (name="log_entidade", nullable=false, columnDefinition = "varchar2(50)") //,CONSTRAINT cons_log_entidade CHECK (log_entidade IN ('SISTEMA', 'ERRO', 'USUARIO', 'PERFIL')),")
	@Enumerated (EnumType.STRING)
	private EntidadeEnum log_entidade;
	
	/**
	 * @uml.property  name="log_data"
	 */
	@Column (name="log_data", nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date log_data;
	
	/**
	 * @uml.property  name="log_usuario"
	 */
	@Column(name="log_usuario", length=50)
	private String log_usuario;

	/**
	 * @uml.property  name="log_dados"
	 */
	@Column(name="log_dados", length=4000)
	private String log_dados;


	public Log() {
		super();
	}


	public Log(AcaoEnum log_acao, EntidadeEnum log_entidade, Date log_data,
			String log_usuario, String log_dados) {
		super();
		this.log_acao = log_acao;
		this.log_entidade = log_entidade;
		this.log_data = log_data;
		this.log_usuario = log_usuario;
		this.log_dados = log_dados;
	}

	
	/**
	 * Retorna o valor Long da variavel log_id
	 * @return
	 * @uml.property = "log_id"
	 */
	public Long getLog_id() {
		return log_id;
	}

	
	/**
	 * Insere o valor Long na Variavel log_id
	 * @param log_id
	 * @uml.property = "log_id"
	 */
	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}

	
	/**
	 * Retorna o Valor AcaoEnum da variavel log_acao
	 * @return
	 * @uml.property = "log_acao"
	 */
	public AcaoEnum getLog_acao() {
		return log_acao;
	}
	
	
	/**
	 * Insere o Valor AcaoEnum na variavel log_acao
	 * @param log_acao
	 * @uml.property = "log_acao"
	 */
	public void setLog_acao(AcaoEnum log_acao) {
		this.log_acao = log_acao;
	}

	
	/**
	 * Retorna o Valor EntidadeEnum da variavel log_entidade
	 * @return
	 * @uml.property = "log_entidade"
	 */
	public EntidadeEnum getLog_entidade() {
		return log_entidade;
	}
	

	/**
	 * Insere o Valor EntidadeEnum na variavel log_entidade
	 * @param log_entidade
	 * @uml.property = "log_entidade"
	 */
	public void setLog_entidade(EntidadeEnum log_entidade) {
		this.log_entidade = log_entidade;
	}
	

	/**
	 * Retorna o Valor Date da variavel log_data
	 * @return
	 * @uml.property = "log_data"
	 */
	public Date getLog_data() {
		return log_data;
	}
	

	/**
	 * Insere o Valor Date na variavel log_data
	 * @param log_data
	 * @uml.property = "log_data"
	 */
	public void setLog_data(Date log_data) {
		this.log_data = log_data;
	}
	

	/**
	 * Retorna o Valor String na variavel log_usuario
	 * @return
	 *  @uml.property = "log_usuario"
	 */
	public String getLog_usuario() {
		return log_usuario;
	}
	
	
	/** Insere o Valor String na variavel log_usuario
	 * 
	 * @param log_usuario
	 * @uml.property = "log_usuario"
	 */
	public void setLog_usuario(String log_usuario) {
		this.log_usuario = log_usuario;
	}


	/**
	 * Retorna o Valor String da variavel log_dados
	 * @return
	 * @uml.property = "log_dados"
	 */
	public String getLog_dados() {
		return log_dados;
	}
	

	/**
	 * Insere o Valor String na variavel log_dados
	 * @param log_dados
	 *  @uml.property = "log_dados"
	 */
	public void setLog_dados(String log_dados) {
		this.log_dados = log_dados;
	}
	
	
}
