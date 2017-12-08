package br.edu.fatecsjc.aloprefeitura.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.edu.fatecsjc.aloprefeitura.models.Usuario;
import br.edu.fatecsjc.aloprefeitura.repositories.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository usuarioRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = usuarioRepository.findByNome(username);
        if (usuario == null) {
            return null;
        }
        return new MyUserPrincipal(usuario);
    }
}