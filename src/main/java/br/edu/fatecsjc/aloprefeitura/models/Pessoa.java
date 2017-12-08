package br.edu.fatecsjc.aloprefeitura.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PSS_PESSOA")
@Audited
public @Data class Pessoa {
	@Id
	@GeneratedValue
	@Column(name="PSS_ID", nullable=false)
	@Getter @Setter
	private Long id;
	
	@Column(name="PSS_NOME", nullable=false)
	@Getter @Setter
	private String nome;
	
	@Column(name="PSS_DATA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	@Getter @Setter
	private Calendar dataNascimento;
	
	@Column(name="PSS_CPF")
	@Getter @Setter
	private String cpf;
	
	@Column(name="PSS_CELULAR")
	@Getter @Setter
	private String celular;
	
	@Column(name="PSS_EMAIL")
	@Getter @Setter
	private String email;
	
	@Column(name="PSS_ATIVO")
	@Getter @Setter
	private Boolean ativo;
}