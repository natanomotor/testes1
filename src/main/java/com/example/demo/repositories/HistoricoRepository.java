package com.example.demo.repositories;

import com.example.demo.beans.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico,String> {
}
