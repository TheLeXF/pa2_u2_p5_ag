package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{
	

}
