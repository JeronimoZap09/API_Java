package com.example.estudiantes;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final List<Estudiante> estudiantes = new ArrayList<>(List.of(
            new Estudiante(1L, "Ana Lopez", "Ingenieria"),
            new Estudiante(2L, "Carlos Perez", "Sistemas")
    ));

    // GET: consultar todos los estudiantes -> GET http://localhost:8080/estudiantes
    @GetMapping
    public List<Estudiante> listarTodos() {
        return estudiantes;
    }

    // GET por ID: consultar un estudiante especifico -> GET http://localhost:8080/estudiantes/1
    @GetMapping("/{id}")
    public Estudiante buscarPorId(@PathVariable Long id) {
        for (Estudiante est : estudiantes) {
            if (est.getId().equals(id)) {
                return est;
            }
        }
        return null;
    }

    // POST: registrar un estudiante -> POST http://localhost:8080/estudiantes
    @PostMapping
    public Estudiante registrar(@RequestBody Estudiante nuevo) {
        estudiantes.add(nuevo);
        return nuevo;
    }

    // PUT: actualizar un estudiante por ID -> PUT http://localhost:8080/estudiantes/1
    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante datosActualizados) {
        for (Estudiante est : estudiantes) {
            if (est.getId().equals(id)) {
                est.setNombre(datosActualizados.getNombre());
                est.setPrograma(datosActualizados.getPrograma());
                return est;
            }
        }
        return null;
    }

    // DELETE: eliminar un estudiante por ID -> DELETE http://localhost:8080/estudiantes/1
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = estudiantes.removeIf(est -> est.getId().equals(id));
        return eliminado ? "Estudiante eliminado" : "Estudiante no encontrado";
    }
}