package br.edu.fatecsjc.aloprefeitura.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Audited
@AuditTable(catalog="aloprefeitura_aud", value="SET_SETOR_AUD")
@Table(name="SET_SETOR")
public @Data class Setor {
	@Id
	@Column(name="SET_ID")
	@GeneratedValue
	@Getter @Setter
	private Long id;
	
	@Column(name="SET_NOME")
	@Getter @Setter
	private String nome;
}
