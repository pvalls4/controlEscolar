package controller;

import java.util.List;
import model.*;
import view.View;

/**
 *
 * @author Mati
 */
public class Controlador {

    private Modelo modelo;
    private View view;

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
        this.view = new View();
    }

    public void start() {
        int opcion = -1;
        do {
            opcion = view.showMenu();
            procesarMenu(opcion);
        } while (opcion != 0);

    }

    public void procesarMenu(int opcion) {
        switch (opcion) {
            case 0://Salir
                exitApplication();
                break;
            case 1://Gestionar carreras
                int opcionCarrera = -1;
                do {
                    opcionCarrera = view.showMenuCarreras();
                    gestionarCarreras(opcionCarrera);
                } while (opcionCarrera != 0);
                break;
            case 2://Gestionar Alumnos
                int opcionAlumno = -1;
                do {
                    opcionAlumno = view.showMenuAlumnos();
                    gestionarAlumnos(opcionAlumno);
                } while (opcionAlumno != 0);
                break;
            case 3: //Matricular alumnos
                matricularAlumno();
                break;
            case 4://Gestionar Catedr�tico
                int opcionCatedratico = -1;
                do {
                    opcionCatedratico = view.showMenuCatedraticos();
                    gestionarCatedraticos(opcionCatedratico);
                } while (opcionCatedratico!= 0);
            default:
                view.displayMessage("Introduce una opci�n v�lida!");
        }
    }

    private void gestionarCarreras(int opcion) {
        switch (opcion) {
            case 0://Volver atr�s al men� general
                break;
            case 1://Listar todas las carreras
                listarCarreras();
                break;
            case 2://Buscar carrera existente
                buscarCarrera();
                break;
            case 3://Modificar una carrera
                modificarCarrera();
                break;
            case 4://A�adir una carrera
                agregarCarrera();
                break;
            case 5://Eliminar una carrera
                eliminarCarrera();
                break;
            default:
                view.displayMessage("Introduce una opci�n v�lida!");
        }
    }

    private void gestionarAlumnos(int opcion) {
        switch (opcion) {
            case 0://Volver atr�s al men� general
                break;
            case 1://Listar todos lo alumnos
                listarAlumnos();
                break;
            case 2://Buscar un alumno existente
                buscarAlumno();
                break;
            case 3://Modificar un alumno
                modificarAlumno();
                break;
            case 4://A�adir un alumno
                agregarAlumno();
                break;
            case 5://Eliminar un alumno
                eliminarAlumno();
                break;
            case 6://Lista los alumnos de una carrera seleccionada
                listarAlumnosDeCarrera();
                break;
            default:
                view.displayMessage("Introduce una opci�n v�lida!");
        }
    }
    
    private void gestionarCatedraticos(int opcion) {
        switch (opcion) {
            case 0://Volver atr�s al men� general
                break;
            case 1://Listar todod los catedratico
                listarCatedraticos();
                break;
            case 2://Buscar catedratico existente
                buscarCatedratico();
                break;
            case 3://Modificar un catedratico
                modificarCatedratico();
                break;
            case 4://A�adir un catedratico
                agregarCatedratico();
                break;
            case 5://Eliminar un catedratico
                eliminarCatedratico();
                break;
            default:
                view.displayMessage("Introduce una opci�n v�lida!");
        }
    }

    private void listarCarreras() {
        List<Carrera> result = modelo.listarCarreras();
        if (result != null) {
            view.displayList(result);
        }
    }

    private void buscarCarrera() {
        //Pedimos por teclado el id de la carrera
        int idCarrera = view.inputId("Introduce el ID de la Carrera a buscar: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        if (carrera != null) {
            view.displayMessage(carrera.toString());
        } else {
            view.displayMessage("No se ha encontrado ninguna carrera con ese ID!");
        }
    }

    private void modificarCarrera() {
        int result = 0;
        //Pedimos el id de la carrera a modificar
        int idCarrera = view.inputId("Introduce el ID de la Carrera a modificar: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        if (carrera != null) {
            //Si existe, pedimos los datos de la nueva carrera
            view.displayMessage("Modificando carrera...");
            Carrera updatedCarrera = view.inputCarrera();
            if (updatedCarrera != null) {
                result = modelo.modificarCarrera(carrera.getId(), updatedCarrera);
                if (result > 0) {
                    view.displayMessage("Carrera modificada con �xito!");
                } else {
                    view.displayMessage("Carrera no modificada!");
                }
            } else {
                view.displayMessage("Nuevos datos de carrera no v�lidos!");
            }
        } else {
            view.displayMessage("No se ha encontrado ninguna carrera con ese ID!");
        }
    }

    private void agregarCarrera() {
        int result = 0;
        //Pedimos los datos de la nueva carrera
        Carrera carrera = view.inputCarrera();
        if (carrera != null) {
            result = modelo.agregarCarrera(carrera);
            if (result > 0) {
                view.displayMessage("Carrera agregada con �xito!");
            } else {
                view.displayMessage("No se pudo agregar la carrera!");
            }
        } else {
            view.displayMessage("Datos de Carrera no v�lidos!");
        }
    }

    private void eliminarCarrera() {
        int result = 0;
        //Pedimos el id de la carrera a borrar
        int idCarrera = view.inputId("Introduce el ID de la carrera a borrar: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        //Comprobmos que la carrera exista
        if (carrera != null) {
            result = modelo.eliminarCarrera(carrera);
            if (result > 0) {
                view.displayMessage("Carrera eliminada con �xito!");
            } else {
                view.displayMessage("No se pudo eliminar la carrera!");
            }
        } else {
            view.displayMessage("No se ha encontrado ninguna carrera con ese ID!");
        }
    }

    private void listarAlumnos() {
        List<Alumno> result = modelo.listarAlumnos();
        if (result != null) {
            view.displayList(result);
        }
    }

    private void buscarAlumno() {
        //Pedimos por teclado el id del alumno
        int idAlumno = view.inputId("Introduce el ID del Alumno a buscar: ");
        Alumno alumno = modelo.buscarAlumno(idAlumno);
        if (alumno != null) {
            view.displayMessage(alumno.toString());
        } else {
            view.displayMessage("No se ha encontrado ning�n alumno con ese ID!");
        }
    }

    private void modificarAlumno() {
        int result = 0;
        //Pedimos el id del alumno a modificar
        int idAlumno = view.inputId("Introduce el ID del Alumno a modificar: ");
        Alumno alumno = modelo.buscarAlumno(idAlumno);
        if (alumno != null) {
            //Si existe, pedimos los datos de la nueva carrera
            view.displayMessage("Modificando alumno...");
            Alumno updatedAlumno = view.inputAlumno();
            if (updatedAlumno != null) {
                result = modelo.modificarAlumno(alumno, updatedAlumno);
                if (result > 0) {
                    view.displayMessage("Alumno modificado con �xito!");
                } else {
                    view.displayMessage("Alumno no modificado!");
                }
            } else {
                view.displayMessage("Nuevos datos del alumno no v�lidos!");
            }
        } else {
            view.displayMessage("No se ha encontrado ning�n alumno con ese ID!");
        }
    }

    private void agregarAlumno() {
        int result = 0;
        //Pedimos los datos de la nueva carrera
        Alumno alumno = view.inputAlumno();
        if (alumno != null) {
            result = modelo.agregarAlumno(alumno);
            if (result > 0) {
                view.displayMessage("Alumno agregado con �xito!");
            } else {
                view.displayMessage("No se pudo agregar el alumno!");
            }
        } else {
            view.displayMessage("Datos del Alumno no v�lidos!");
        }
    }

    private void eliminarAlumno() {
        int result = 0;
        //Pedimos el id de la carrera a borrar
        int idAlumno = view.inputId("Introduce el ID del alumno a borrar: ");
        Alumno alumno = modelo.buscarAlumno(idAlumno);
        //Comprovamos que la carrera exista
        if (alumno != null) {
            result = modelo.eliminarAlumno(alumno);
            if (result > 0) {
                view.displayMessage("Alumno " + alumno.getNombre() + " " + alumno.getApellido() + " eliminado con �xito!");
            } else {
                view.displayMessage("No se pudo eliminar el alumno!");
            }
        } else {
            view.displayMessage("No se ha encontrado ning�n alumno con ese ID!");
        }
    }

    private void listarAlumnosDeCarrera() {
        //Pedimos el id de la carrera a borrar
        int idCarrera = view.inputId("Introduce el ID de la carrera de la que quieres saber los alumnos matriculados: ");
        Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
        //Comprobamos que la carrera exista
        if (carrera != null) {
            List<Alumno> result = modelo.listarAlumnosDeCarrera(idCarrera);
            if (result != null) {
                view.displayList(result);
            }
        }
    }

    private void matricularAlumno() {
        //Pedimos el id del alumno a matricular
        int idAlumno = view.inputId("Introduce el ID del Alumno a matricular: ");
        //Comprovamos que el alumno exista y que el ID sea null(0)
        Alumno alumno = modelo.buscarAlumno(idAlumno);
        //Comprovamos que se devuelva algo
        if (alumno != null) {
            //Si el alumno no est� matriculado en una carrera
            if (alumno.getIdCarrera() == 0) {
                //Pedimos el ID de la carrera a la que lo queremos matricular
                int idCarrera = view.inputId("Introduce el ID de la carrera al que lo quieres matricular: ");
                Carrera carrera = modelo.buscarCarrera(new Carrera(idCarrera));
                if (carrera != null) {
                    int result = modelo.matricularAlumno(alumno, carrera);
                    if (result > 0) {
                        view.displayMessage("Alumno matriculado exitosamente!");
                    } else {
                        view.displayMessage("Alumno NO matriculado");
                    }
                } else {
                    view.displayMessage("No se encontr� ninguna carrera con ese ID!");
                }
            } else {
                view.displayMessage("El alumno ya est� matriculado en una carrera!");
            }
        } else {
            view.displayMessage("No se encontr� ning�n alumno con ese ID");
        }
    }
    
    private void listarCatedraticos() {
        List<Catedratico> result = modelo.listarCatedraticos();
        if (result != null) {
            view.displayList(result);
        }
    }   
    
    private void buscarCatedratico() {
        //Pedimos por teclado el id del alumno
        int idCatedratico = view.inputId("Introduce el ID del Catedr�tico a buscar: ");
        Catedratico catedratico = modelo.buscarCatedratico(idCatedratico);
        if (catedratico != null) {
            view.displayMessage(catedratico.toString());
        } else {
            view.displayMessage("No se ha encontrado ning�n Catedr�tico con ese ID!");
        }
    }

    private void modificarCatedratico() {
        int result = 0;
        //Pedimos el id del alumno a modificar
        int idCatedratico = view.inputId("Introduce el ID del Catedr�tico a modificar: ");
        Catedratico catedratico = modelo.buscarCatedratico(idCatedratico);
        if (catedratico != null) {
            //Si existe, pedimos los datos de la nueva carrera
            view.displayMessage("Modificando catedr�tico...");
            Catedratico updatedCatedratico = view.inputCatedratico();
            if (updatedCatedratico != null) {
                result = modelo.modificarCatedratico(catedratico, updatedCatedratico);
                if (result > 0) {
                    view.displayMessage("Catedr�tico modificado con �xito!");
                } else {
                    view.displayMessage("Catedr�tico no modificado!");
                }
            } else {
                view.displayMessage("Nuevos datos del catedr�tico no v�lidos!");
            }
        } else {
            view.displayMessage("No se ha encontrado ning�n catedr�tico con ese ID!");
        }
    }

    private void agregarCatedratico() {
        int result = 0;
        //Pedimos los datos del nuevo catedratico
        Catedratico catedratico = view.inputCatedratico();
        if (catedratico != null) {
            result = modelo.agregarCatedratico(catedratico);
            if (result > 0) {
                view.displayMessage("Catedr�tico agregado con �xito!");
            } else {
                view.displayMessage("No se pudo agregar el catedr�tico!");
            }
        } else {
            view.displayMessage("Datos del Catedr�tico no v�lidos!");
        }
    }

    private void eliminarCatedratico() {
        int result = 0;
        //Pedimos el id de la carrera a borrar
        int idCatedratico = view.inputId("Introduce el ID del catedr�tico a borrar: ");
        Catedratico catedratico = modelo.buscarCatedratico(idCatedratico);
        //Comprovamos que la carrera exista
        if (catedratico != null) {
            result = modelo.eliminarCatedratico(catedratico);
            if (result > 0) {
                view.displayMessage("Catedratico " + catedratico.getNombre() + " eliminado con �xito!");
            } else {
                view.displayMessage("No se pudo eliminar el catedr�tico!");
            }
        } else {
            view.displayMessage("No se ha encontrado ning�n catedr�tico con ese ID!");
        }
    }
    
    public void exitApplication() {
        String answer = view.inputString("Sure to exit? ");
        if (answer.equalsIgnoreCase("yes")) {
            //System.exit(0);
            view.close();
        }   
    } 
}
