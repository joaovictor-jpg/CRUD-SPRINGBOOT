package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;
import br.com.springboot.curso_jdev_treinamento.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired/*INJEÇÃO DE DEPENDENCIA*/
	private UsuarioRepository usuarioRepository;
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @GetMapping(value = "/mostranome/{name}")
    public ResponseEntity<String> greetingText(@PathVariable String name) {
    	
    	Usuario usuario = new Usuario(null, name, 21);
    	
    	Usuario save = usuarioRepository.save(usuario);
    	
        return ResponseEntity.ok().body("Curso Spring Boot API: " + save.getName() + "!");
    }
    
    @GetMapping(value = "/olamundo/{name}")
    public ResponseEntity<String> retornaOlaMund(@PathVariable String name) {
    	return ResponseEntity.ok().body("Olá mundo: " + name);
    }
    
    @GetMapping(value = "listatodos")
    @ResponseBody/* RETORNA PARA O CORPO DA RESPOSTA*/
    public ResponseEntity<List<Usuario>> listaUsuario() {
    	List<Usuario> listUsuario = usuarioRepository.findAll(); /* executa uma busca no DB */
    	return ResponseEntity.ok().body(listUsuario);/* lista em JSON */
    }
}
