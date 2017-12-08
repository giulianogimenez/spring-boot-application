package br.edu.fatecsjc.aloprefeitura.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.fatecsjc.aloprefeitura.models.Usuario;

public class MyUserPrincipal implements UserDetails {
	
	private Usuario usuario;
	
	public MyUserPrincipal(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return usuario.getAtivo();
	}

	@Override
	public boolean isAccountNonLocked() {
		return usuario.getAtivo();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return usuario.getAtivo();
	}

	@Override
	public boolean isEnabled() {
		return usuario.getAtivo();
	}
}