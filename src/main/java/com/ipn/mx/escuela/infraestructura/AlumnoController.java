package com.ipn.mx.escuela.infraestructura;

import com.ipn.mx.escuela.dominio.entidades.Alumno;
import com.ipn.mx.escuela.servicio.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
  @Autowired
  private AlumnoService service;

  @GetMapping("/alumno")
  @ResponseStatus(HttpStatus.OK)
  public List<Alumno> findAll() {
    return service.findAll();
  }


  @GetMapping("/alumno/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Alumno findById(@PathVariable Long id) {
    return service.findById(id);
  }


  @PostMapping("/alumno")
  @ResponseStatus(HttpStatus.CREATED)
  public Alumno save(@RequestBody Alumno alumno) {
    return service.save(alumno);
  }

  @PutMapping("/alumno/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Alumno update(@RequestBody Alumno alumno,
                       @PathVariable Long id) {
    Alumno a=service.findById(id);
    a.setNombreAlumno(alumno.getNombreAlumno());
    a.setPaternoAlumno(alumno.getPaternoAlumno());
    a.setMaternoAlumno(alumno.getMaternoAlumno());
    a.setCorreoAlumno(alumno.getCorreoAlumno());
    return service.save(a);
  }

  @DeleteMapping("/alumno/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

}










