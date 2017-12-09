package br.edu.fatecsjc.aloprefeitura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecsjc.aloprefeitura.models.Reputacao;
import br.edu.fatecsjc.aloprefeitura.models.Usuario;

public interface ReputacaoRepository extends JpaRepository<Reputacao, Long>{
	public List<Reputacao> findByUsuario(Usuario usuario);
}
