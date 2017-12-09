package br.edu.fatecsjc.aloprefeitura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecsjc.aloprefeitura.models.Ocorrencia;
import br.edu.fatecsjc.aloprefeitura.models.StatusOcorrencia;
import br.edu.fatecsjc.aloprefeitura.models.Usuario;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
	
	public List<Ocorrencia> findById(Long id);
	
	public List<Ocorrencia> findAll();
	
	public List<Ocorrencia> findByStatusOcorrencia(StatusOcorrencia statusOcorrencia);
	
	public List<Ocorrencia> findByUsuario(Usuario usuario);
	
	public List<Ocorrencia> findByUsuarioAndStatusOcorrencia(Usuario usuario, StatusOcorrencia statusOcorrencia);
}
