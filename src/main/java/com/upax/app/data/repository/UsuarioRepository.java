package com.upax.app.data.repository;

import com.upax.app.data.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    @Query("FROM Usuario u WHERE u.usuario = (:usuario) AND u.contrasena = (:contrasena)")
    Optional<Usuario> findUserByUsserAndPassword(@Param("usuario") String usuario,
                                                @Param("contrasena") String contrasena);


}
