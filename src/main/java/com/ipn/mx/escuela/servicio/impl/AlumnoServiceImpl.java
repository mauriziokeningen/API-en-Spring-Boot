package com.ipn.mx.escuela.servicio.impl;

import com.ipn.mx.escuela.dominio.entidades.Alumno;
import com.ipn.mx.escuela.dominio.repositorios.AlumnoRepository;
import com.ipn.mx.escuela.servicio.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
  @Autowired
  private AlumnoRepository ar;
  @Override
  @Transactional(readOnly = true)
  public List<Alumno> findAll() {
    return ar.findAll();
  }
  @Override
  @Transactional(readOnly = true)
  public Alumno findById(Long id) {
    return ar.findById(id).orElse(null);
  }
  @Override
  @Transactional
  public Alumno save(Alumno alumno) {
    return ar.save(alumno);
  }
  @Override
  @Transactional
  public void delete(Long id) {
      ar.deleteById(id);
  }
}
