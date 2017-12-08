package br.edu.fatecsjc.aloprefeitura.models;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name="USR_USUARIO")
@Data
@Audited
public class Usuario implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="USR_ID")
	private Long id;
	
	@NotNull(message="Nome de usuário necessária")
	@Column(name="USR_NOME")
	private String nome;

	@NotNull(message="Nome real necessário")
	@Column(name="USR_NOME_REAL")
	private String nomeReal;


	@NotNull(message="Senha não pode ser em branco")
	@Column(name="USR_SENHA")
	private String senha;

	@NotNull(message="É administrador ou não?")
	@Column(name="USR_ADMIN")
	private Boolean admin;

	@Column(name="USR_ATIVO")
	private Boolean ativo;

	@ManyToOne
    @JoinColumn(name = "PSS_ID", referencedColumnName = "PSS_ID", nullable=true)
	@Getter
	private Pessoa pessoa;
	
	public void setSenha(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(senha.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			this.senha = sb.toString();
		} 
		catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}