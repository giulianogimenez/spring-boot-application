package br.edu.fatecsjc.aloprefeitura.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MDA_MIDIA")
@Audited
@AuditTable(catalog="aloprefeitura_aud", value="MDA_MIDIA_AUD")
public @Data class Midia {
	@Id
	@Column(name="MDA_ID")
	@Getter @Setter
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="OCR_ID", referencedColumnName="OCR_ID")
	@Getter @Setter
	private Ocorrencia ocorrencia;
	
	@Column(name="MDA_TIPO")
	@Getter @Setter
	private String tipo;
	
	
	@Column(name="MDA_BYTES")
	@Lob
	@Getter @Setter
	private byte[] arquivo;
}
