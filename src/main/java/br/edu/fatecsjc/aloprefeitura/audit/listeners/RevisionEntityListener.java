package br.edu.fatecsjc.aloprefeitura.audit.listeners;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.edu.fatecsjc.aloprefeitura.audit.entities.RevisionEntity;


public class RevisionEntityListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		RevisionEntity rEntity = (RevisionEntity)revisionEntity;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		rEntity.setUserName(currentPrincipalName);
	}
}
