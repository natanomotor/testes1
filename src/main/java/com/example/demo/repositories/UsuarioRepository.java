package com.example.demo.repositories;

import com.example.demo.beans.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {

}
