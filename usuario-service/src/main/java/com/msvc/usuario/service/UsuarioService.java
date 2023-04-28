package com.msvc.usuario.service;

import com.msvc.usuario.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);

    List<Usuario> getAll();

    Usuario getUsuario(String usuarioId);
}
