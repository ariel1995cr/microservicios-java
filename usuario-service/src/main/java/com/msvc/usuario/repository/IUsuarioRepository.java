package com.msvc.usuario.repository;

import com.msvc.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {
}
