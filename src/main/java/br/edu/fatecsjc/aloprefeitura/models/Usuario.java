package br.edu.fatecsjc.aloprefeitura.models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USR_USUARIO")
@Audited
@AuditTable(catalog="aloprefeitura_aud", value="USR_USUARIO_AUD")
public @Data class Usuario {
	@Id
	@Column(name="USR_ID", nullable=false)
	@GeneratedValue
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	@Column(name="USR_EMAIL", nullable=false)
	private String email;
	
	@Getter @Setter
	@Column(name="USR_NOME", nullable=false)
	private String nome;
	
	@Getter
	@Column(name="USR_PASS", nullable=false)
	private String password;

	@Column(name="USR_CPF")
	@Getter @Setter
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="SET_ID", referencedColumnName = "SET_ID")
	@Getter @Setter
	private Setor setor;
	
	@Column(name="USR_TIPO", nullable=false)
	@Getter @Setter
	private TipoUsuario tipoUsuario;
	
	public void setPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			this.password = sb.toString();
		} 
		catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}