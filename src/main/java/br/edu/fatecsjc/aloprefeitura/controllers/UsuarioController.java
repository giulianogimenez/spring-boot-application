package br.edu.fatecsjc.aloprefeitura.controllers;

import java.util.Calendar;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecsjc.aloprefeitura.exceptions.ApiException;
import br.edu.fatecsjc.aloprefeitura.models.Usuario;
import br.edu.fatecsjc.aloprefeitura.repositories.UsuarioRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@CrossOrigin
	@ApiOperation(value = "Insere um usuário", response = Usuario.class)
	@RequestMapping( method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) throws ApiException {
		if(usuario.getId() == null) {
			usuario = usuarioRepository.save(usuario);
			return ResponseEntity.ok(usuario);
		} else {
			Usuario usuarioEditavel = usuarioRepository.findById(usuario.getId());
			usuarioEditavel.setAdmin(usuario.getAdmin());
			usuarioEditavel.setAtivo(usuario.getAtivo());
			usuarioEditavel.setNome(usuario.getNome());
			usuarioEditavel.setNomeReal(usuario.getNomeReal());
			usuario = usuarioRepository.save(usuarioEditavel);
			return ResponseEntity.ok(usuario);
		}
	}
	
	@CrossOrigin
	@ApiOperation(value = "Busca um usuário pelo Id.", response = Usuario.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "Sucesso em retornar a lista!"),
			@ApiResponse(code = 401, message = "Voce nao tem autorizacao!"),
			@ApiResponse(code = 404, message = "Nenhuma ocorrencia achada!")
	})
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Usuario> find(@PathVariable("id") Long id) {
		try {
			Usuario usr = usuarioRepository.findById(id);
			if(usr == null || usr.getId() == null)
				return ResponseEntity.noContent().build();
			else 
				return ResponseEntity.ok(usr);
		} catch (NoResultException e) {
			return ResponseEntity.noContent().build();
		}
	}
}
