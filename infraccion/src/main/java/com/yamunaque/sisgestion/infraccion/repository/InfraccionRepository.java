package com.yamunaque.sisgestion.infraccion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yamunaque.sisgestion.infraccion.entity.Infraccion;

@Repository
public interface InfraccionRepository extends JpaRepository<Infraccion, Integer> {
	public Infraccion findByNombre(String nombre);
}
