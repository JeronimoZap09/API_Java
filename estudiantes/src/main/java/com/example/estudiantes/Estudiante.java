package com.example.estudiantes;

public class Estudiante {
    private Long id;
    private String nombre;
    private String programa;

    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}