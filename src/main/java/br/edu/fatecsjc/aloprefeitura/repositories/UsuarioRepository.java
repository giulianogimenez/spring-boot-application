package br.edu.fatecsjc.aloprefeitura.repositories;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecsjc.aloprefeitura.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findById(Long id);
	
	List<Usuario> findAll();
	
	@Null
	public Usuario findByNome(String nome);
}
