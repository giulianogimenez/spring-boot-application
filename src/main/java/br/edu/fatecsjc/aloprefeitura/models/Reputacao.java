package br.edu.fatecsjc.aloprefeitura.models;

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
@Table(name="REP_REPUTACAO")
@Audited
@AuditTable(catalog="aloprefeitura_aud", value="REP_REPUTACAO_AUD")
public @Data class Reputacao {
	@Id
	@Column(name="REP_ID")
	@Getter @Setter
	@GeneratedValue
	private Long id;
	
	@Column(name="REP_NOTA")
	@Getter @Setter
	private Long nota;
	
	@ManyToOne
	@JoinColumn(name="USR_ID", referencedColumnName="USR_ID")
	@Getter @Setter
	private Usuario usuario;
	
}
