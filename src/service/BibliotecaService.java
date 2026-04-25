package service;

import exception.*;
import java.util.*;
import model.*;

public class BibliotecaService {

    private ArrayList<Libro> libros = new ArrayList<>();
    private HashMap<String, Estudiante> estudiantes = new HashMap<>();
    private HashSet<Prestamo> prestamos = new HashSet<>();

    public void agregarLibro(Libro l) {
        libros.add(l);
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.put(e.getLegajo(), e);
    }

    public void prestarLibro(String isbn, String legajo) throws Exception {

        Estudiante est = estudiantes.get(legajo);
        if (est == null) {
            throw new EstudianteNoEncontradoException("No existe el estudiante");
        }

        int contador = 0;
        for (Prestamo p : prestamos) {
            if (p.getEstudiante().getLegajo().equals(legajo)) {
                contador++;
            }
        }

        if (contador >= 3) {
            throw new LimitePrestamosExcedidoException("Ya tiene 3 libros");
        }

        Libro libro = null;
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                libro = l;
            }
        }

        if (libro == null || !libro.isDisponible()) {
            throw new LibroNoDisponibleException("Libro no disponible");
        }

        libro.setDisponible(false);
        prestamos.add(new Prestamo(libro, est));
    }

    public void listarPrestamos(String legajo) {
        for (Prestamo p : prestamos) {
            if (p.getEstudiante().getLegajo().equals(legajo)) {
                System.out.println(p);
            }
        }
    }

    public double calcularMulta(int dias, double valor) {
        if (dias <= 0) return 0;
        if (dias > 30) dias = 30;

        return valor * 0.01 + calcularMulta(dias - 1, valor);
    }
}