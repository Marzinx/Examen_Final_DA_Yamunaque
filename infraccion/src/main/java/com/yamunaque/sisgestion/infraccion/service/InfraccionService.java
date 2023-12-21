package com.yamunaque.sisgestion.infraccion.service;

import java.util.List;

import com.yamunaque.sisgestion.infraccion.entity.Infraccion;



public interface InfraccionService {
	public List<Infraccion> findAll();
	public Infraccion findById(int id);
	public Infraccion findByNombre(String nombre);
	public Infraccion create(Infraccion obj);
	public Infraccion update(Infraccion obj);
	public int delete(int id);
}
