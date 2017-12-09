package br.edu.fatecsjc.aloprefeitura.audit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import br.edu.fatecsjc.aloprefeitura.audit.listeners.RevisionEntityListener;
import lombok.Data;

@Entity
@Table(catalog="aloprefeitura_aud", name="REVINFO")
@org.hibernate.envers.RevisionEntity(RevisionEntityListener.class)
@Data
public class RevisionEntity {
	@Id
	@Column(name="REV")
    @GeneratedValue
    @RevisionNumber
    private int id;

    @RevisionTimestamp
    @Column(name="REVTSTMP")
    private long timestamp;

    @Column(name="USERNAME")
    private String userName;
}
