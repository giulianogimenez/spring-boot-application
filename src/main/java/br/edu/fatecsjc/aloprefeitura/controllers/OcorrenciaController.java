package br.edu.fatecsjc.aloprefeitura.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecsjc.aloprefeitura.models.Ocorrencia;
import br.edu.fatecsjc.aloprefeitura.models.StatusOcorrencia;
import br.edu.fatecsjc.aloprefeitura.models.Usuario;
import br.edu.fatecsjc.aloprefeitura.repositories.OcorrenciaRepository;
import br.edu.fatecsjc.aloprefeitura.repositories.UsuarioRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@CrossOrigin
	@ApiOperation(value = "Salva uma ocorrencia", response = Ocorrencia.class)
	@RequestMapping(value="/inserir", method=RequestMethod.POST)
	public ResponseEntity<Ocorrencia> inserir(@RequestBody Ocorrencia ocorrencia) {
		ocorrencia.setDataHora(Calendar.getInstance());
		ocorrencia.setUsuario(getCurrentUser());
		ocorrencia.setProtocolo(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
		return ResponseEntity.ok(ocorrenciaRepository.saveAndFlush(ocorrencia));
	}
	
	@CrossOrigin
	@ApiOperation(value = "Retorna todas ocorrencias", response = Ocorrencia.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso em retornar a lista!"),
			@ApiResponse(code = 401, message = "Voce nao tem autorizacao!"),
			@ApiResponse(code = 404, message = "Nenhuma ocorrencia achada!")
	})
	@RequestMapping("/all")
	public ResponseEntity<List<Ocorrencia>> allOcorrencias(Usuario usuario){
		List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
		if (ocorrencias.isEmpty()){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Ocorrencia>>(ocorrencias, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Retorna as ocorrencias de acordo com o status", response = Ocorrencia.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso em retornar a lista!"),
			@ApiResponse(code = 401, message = "Voce nao tem autorizacao!"),
			@ApiResponse(code = 404, message = "Nenhuma ocorrencia achada!")
	})
	@RequestMapping(value = "/show/{status}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Ocorrencia>> allOcorrenciasByStatus(@PathVariable StatusOcorrencia status){
		return new ResponseEntity<Iterable<Ocorrencia>>(ocorrenciaRepository.findByStatusOcorrencia(status), HttpStatus.OK);

	}
	
	@CrossOrigin
	@ApiOperation(value = "Retorna as ocorrencias de acordo com o usuario", response = Ocorrencia.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso em retornar a lista!"),
			@ApiResponse(code = 401, message = "Voce nao tem autorizacao!"),
			@ApiResponse(code = 404, message = "Nenhuma ocorrencia achada!")
	})
	@RequestMapping(value = "/show/{usuario}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Ocorrencia>> allOcorrenciasByUsuario(@PathVariable Usuario usuario){
		return new ResponseEntity<Iterable<Ocorrencia>>(ocorrenciaRepository.findByUsuario(usuario), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Retorna as ocorrencias de acordo com o usuario e o status", response = Ocorrencia.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso em retornar a lista!"),
			@ApiResponse(code = 401, message = "Voce nao tem autorizacao!"),
			@ApiResponse(code = 404, message = "Nenhuma ocorrencia achada!")
	})
	@RequestMapping(value = "/show/{usuario, status}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Ocorrencia>> allOcorrenciasByUsuarioAndStatus(@PathVariable Usuario usuario, @PathVariable StatusOcorrencia status){
		return new ResponseEntity<Iterable<Ocorrencia>>(ocorrenciaRepository.findByUsuarioAndStatusOcorrencia(usuario, status),
				HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Atualiza um ocorrencia")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity updateOcorrencia(@RequestBody Ocorrencia ocorrencia){
		Ocorrencia updateOcorrencia = ocorrenciaRepository.getOne(ocorrencia.getId());
		updateOcorrencia.setProtocolo(ocorrencia.getProtocolo());
		updateOcorrencia.setDataHora(ocorrencia.getDataHora());
		updateOcorrencia.setDescricao(ocorrencia.getDescricao());
		updateOcorrencia.setEndereco(ocorrencia.getEndereco());
		updateOcorrencia.setFeedback(ocorrencia.getFeedback());
		return new ResponseEntity("Ocorrencia atualizado com sucesso!", HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/dele/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deleta uma ocorrencia pelo id")
	public ResponseEntity deleteOcorrencia(@PathVariable Long id){
		ocorrenciaRepository.delete(id);
		return new ResponseEntity("Ocorrencia deletada com sucesso!", HttpStatus.OK);
	}
	
	public Usuario getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String nome = authentication.getName();
		return usuarioRepository.findByNome(nome);
	}
}
