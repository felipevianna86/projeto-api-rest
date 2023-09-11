package com.example.projetoapirest.controller;

import com.example.projetoapirest.model.Usuario;
import com.example.projetoapirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping
    public List<Usuario> getUsuarios(){
        return this.usuarioRepository.findAll();
    }

    @GetMapping("/{login}")
    public Usuario getOne(@PathVariable("login") String login){
        return this.usuarioRepository.findByLogin(login);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Long id){
         this.usuarioRepository.delteById(id);
    }

    @PostMapping
    public void saveUsuario(@RequestBody Usuario usuario){
        this.usuarioRepository.save(usuario);
    }

    @PutMapping
    public void updateUsuario(@RequestBody Usuario usuario){
        this.usuarioRepository.save(usuario);
    }
}
