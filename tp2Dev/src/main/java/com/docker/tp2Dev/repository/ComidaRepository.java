package com.docker.tp2Dev.repository;

import com.docker.tp2Dev.model.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
}