package br.edu.fatecsjc.aloprefeitura.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="OCR_OCORRENCIA")
@Audited
@AuditTable(catalog="aloprefeitura_aud", value="OCR_OCORRENCIA_AUD")
public @Data class Ocorrencia {
	@Id
	@Column(name="OCR_ID")
	@Getter @Setter
	@GeneratedValue
	private Long id;
	
	@Column(name="OCR_PROTOCOLO", nullable=false)
	@Getter @Setter
	private String protocolo;

	@Column(name="OCR_DATAHORA")
	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
	private Calendar dataHora;
	
	@Column(name="OCR_ENDERECO")
	@Getter @Setter
	private String endereco;
	
	@Column(name="OCR_DESCRICAO")
	@Getter @Setter
	@Lob
	private String descricao;
	
	@Column(name="OCR_STATUS")
	@Getter @Setter
	private StatusOcorrencia statusOcorrencia;
	
	@ManyToOne
	@JoinColumn(name="USR_ID", referencedColumnName="USR_ID")
	@Getter @Setter
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="USR_PREFEITURA_ID", referencedColumnName="USR_ID")
	@Getter @Setter
	private Usuario usuarioPrefeitura;

	@ManyToOne
	@NotNull
	@JoinColumn(name="SET_ID", referencedColumnName="SET_ID")
	@Getter @Setter
	private Setor setor;
	
	
	@Column(name="OCR_FEEDBACK")
	@Getter @Setter
	@Lob
	private String feedback;
}
