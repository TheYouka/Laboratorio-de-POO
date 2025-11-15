package com.example.sistemaestudiantila1945;

public class Estudiante {

    // (Cambiados a los tipos correctos)
    private String nombre;
    private String carrera;
    private String matricula;
    private int semestre;
    private double promedio;

    Estudiante(String nombre, String carrera, String matricula, int semestre, double promedio) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.matricula = matricula;
        this.semestre = semestre;
        this.promedio = promedio;
    }

    // --- ¡GETTERS AÑADIDOS! ---


    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getSemestre() {
        return semestre;
    }

    public double getPromedio() {
        return promedio;
    }
}