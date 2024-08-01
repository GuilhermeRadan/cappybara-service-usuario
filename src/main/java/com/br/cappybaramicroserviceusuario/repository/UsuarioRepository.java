package com.br.cappybaramicroserviceusuario.repository;

import com.br.cappybaramicroserviceusuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findUsuarioByEmail(String email);
}
