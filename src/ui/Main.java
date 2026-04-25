package ui;

import model.*;
import service.BibliotecaService;

public class Main {

    public static void main(String[] args) {

        System.out.println("iniciando sistema de biblioteca");

        BibliotecaService biblioteca = new BibliotecaService();

        // libros
        biblioteca.agregarLibro(new Libro("1","java","autor1",2020));
        biblioteca.agregarLibro(new Libro("2","python","autor2",2020));
        biblioteca.agregarLibro(new Libro("3","c++","autor3",2020));
        biblioteca.agregarLibro(new Libro("4","poo","autor4",2020));
        biblioteca.agregarLibro(new Libro("5","sql","autor5",2020));

        // estudiantes
        biblioteca.agregarEstudiante(new Estudiante("100","juan","sistemas","a"));
        biblioteca.agregarEstudiante(new Estudiante("101","ana","sistemas","b"));
        biblioteca.agregarEstudiante(new Estudiante("102","luis","sistemas","c"));

        // prestamos correctos
        try {
            biblioteca.prestarLibro("1","100");
            biblioteca.prestarLibro("2","100");
            biblioteca.prestarLibro("3","100");
            System.out.println("prestamos realizados correctamente");
        } catch(Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        // excepcion limite
        try {
            biblioteca.prestarLibro("4","100");
        } catch(Exception e) {
            System.out.println("error limite: " + e.getMessage());
        }

        // excepcion estudiante inexistente
        try {
            biblioteca.prestarLibro("1","999");
        } catch(Exception e) {
            System.out.println("error estudiante: " + e.getMessage());
        }

        // excepcion libro no disponible
        try {
            biblioteca.prestarLibro("1","101");
        } catch(Exception e) {
            System.out.println("error libro: " + e.getMessage());
        }

        // listar prestamos
        System.out.println("\nprestamos del estudiante 100:");
        biblioteca.listarPrestamos("100");

        // multa
        double multa = biblioteca.calcularMulta(15,1000);
        System.out.println("\nmulta por retraso de 15 dias: " + multa);
    }
}