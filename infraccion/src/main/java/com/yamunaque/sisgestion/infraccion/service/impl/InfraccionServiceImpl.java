package com.yamunaque.sisgestion.infraccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yamunaque.sisgestion.infraccion.entity.Infraccion;
import com.yamunaque.sisgestion.infraccion.repository.InfraccionRepository;
import com.yamunaque.sisgestion.infraccion.service.InfraccionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfraccionServiceImpl implements InfraccionService {
	
	@Autowired
	private InfraccionRepository repository;	

	@Override
	@Transactional(readOnly = true)
	public Infraccion findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Infraccion findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional
	public Infraccion create(Infraccion obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Infraccion update(Infraccion obj) {
		try {
			Infraccion infraccionDb=findById(obj.getId());
			infraccionDb.setNombre(obj.getNombre());
			return repository.save(infraccionDb);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public int delete(int id) {
		try {
			Infraccion infraccionDb=findById(id);
			if(infraccionDb==null) {
				return 0;
			}else {
				repository.delete(infraccionDb);
				return 1;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Infraccion> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			//log.error(e.getMessage());
			throw e;
		}
	}

	
}
