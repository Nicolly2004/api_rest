package com.nicollyreis.apirest.repositories;

import com.nicollyreis.apirest.dtos.AuthDTO;
import com.nicollyreis.apirest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth getUsuarioByEmail(String email);

}
