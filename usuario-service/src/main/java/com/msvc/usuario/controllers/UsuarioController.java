package com.msvc.usuario.controllers;

import com.msvc.usuario.entity.Usuario;
import com.msvc.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuarioRequest){
        Usuario usuario = usuarioService.save(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> get(@PathVariable String usuarioId){
        Usuario usuario = usuarioService.getUsuario(usuarioId);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll(@PathVariable String usuarioId){
        List<Usuario> usuarios = usuarioService.getAll();
        return ResponseEntity.ok(usuarios);
    }
}
