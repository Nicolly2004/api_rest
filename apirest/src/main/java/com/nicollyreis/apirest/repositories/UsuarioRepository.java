package com.nicollyreis.apirest.repositories;

import com.nicollyreis.apirest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Usuario getUsuarioByEmail(String email);

}
