package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.*;

/**
 *
 * @author Mati
 */
public class View {

    private Scanner sc;

    public View() {
        sc = new Scanner(System.in);
    }

    public int showMenu() {
        int result = -1;
        System.out.println("============== APP CONTROL UNIVERSITARIO ==============");
        System.out.println("    0. Salir");
        System.out.println("    1. Gestionar Carreras");
        System.out.println("    2. Gestionar Alumnos");
        System.out.println("    3. Matricular Alumnos en Carreras");
        System.out.println("    4. Gestionar Catedráticos");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            result = showMenu();
        }
        return result;
    }

    public int showMenuCarreras() {
        int result = -1;
        System.out.println("============== GESTIÓN DE CARRERAS ==============");
        System.out.println("    0. Atrás");
        System.out.println("    1. Listar todas las Carreras");
        System.out.println("    2. Buscar una Carrera existente");
        System.out.println("    3. Modificar una Carrera");
        System.out.println("    4. Añadir una Carrera");
        System.out.println("    5. Eliminar una Carrera");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            result = showMenuCarreras();
        }
        return result;
    }

    public int showMenuAlumnos() {
        int result = -1;
        System.out.println("============== GESTIÓN DE ALUMNOS ==============");
        System.out.println("    0. Atrás");
        System.out.println("    1. Listar todos los Alumnos");
        System.out.println("    2. Buscar un Alumno existente");
        System.out.println("    3. Modificar un Alumno");
        System.out.println("    4. Añadir un Alumno");
        System.out.println("    5. Eliminar un Alumno");
        System.out.println("    6. Lista Alumnos de una Carrera");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            result = showMenu();
        }
        return result;
    }
    
    public int showMenuCatedraticos() {
        int result = -1;
        System.out.println("============== GESTIÓN DE CATEDRÁTICOS ==============");
        System.out.println("    0. Atrás");
        System.out.println("    1. Listar todos los Catedráticos");
        System.out.println("    2. Buscar un Catedrático existente");
        System.out.println("    3. Modificar un Catedrático");
        System.out.println("    4. Añadir un Catedrático");
        System.out.println("    5. Eliminar un Catedrático");
        System.out.println("Introduce una opción: ");
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            result = showMenuCatedraticos();
        }
        return result;
    }
    public String inputString(String message) {
        System.out.print(message);
        return sc.next();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public <T> void displayList(List<T> data) {
        if (data != null) {
            data.forEach(System.out::println);
            System.out.format("%d elements displayed\n", data.size());
        }
    }

    public void cerrarScanner() {
        sc.close();
    }

    public int inputId(String message) {
        int result = 0;
        System.out.print(message);
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            displayMessage("Introduce un valor válido de ID!");
            result = inputId(message);
        }
        return result;
    }

    public Carrera inputCarrera() {
        System.out.print("Nombre carrera: ");
        String nombre = sc.nextLine();
        return new Carrera(0, nombre);
    }
    
    public Alumno inputAlumno() {
        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido del alumno: ");
        String apellido = sc.nextLine();
        System.out.print("Correo del alumno: ");
        String email = sc.nextLine();
        //System.out.print("Carrera que cursa el alumno: "); ToDo: Introducir el nombre de la carrera, no el ID.
        int idCarrera = inputId("ID de la carrera que cursa el alumno: ");
        return new Alumno(0, nombre, apellido, email, idCarrera);
    }
    
    public Catedratico inputCatedratico() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre catedratico: ");
        String nombre = sc.nextLine();
        return new Catedratico(0, nombre);
    }

    public void close() {
        cerrarScanner();
        System.exit(0);
    }
}
