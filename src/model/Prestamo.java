package model;

import java.time.LocalDate;

public class Prestamo {

    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Estudiante estudiante) {
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = LocalDate.now();
    }

    public Libro getLibro() { return libro; }
    public Estudiante getEstudiante() { return estudiante; }

    public void devolver() {
        this.fechaDevolucion = LocalDate.now();
        libro.setDisponible(true);
    }

    public String toString() {
        return libro + " -> " + estudiante;
    }
}