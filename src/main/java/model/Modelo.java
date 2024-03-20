package model;

import java.util.List;
import model.persist.AlumnoDao;
import model.persist.CarreraDao;
import model.persist.CatedraticoDao;

/**
 *
 * @author Mati
 */
public class Modelo {

    private final CarreraDao carreraDao;
    private final AlumnoDao alumnoDao;
    private final CatedraticoDao catedraticoDao;

    public Modelo() {
        carreraDao = new CarreraDao();
        alumnoDao = new AlumnoDao();
        catedraticoDao = new CatedraticoDao();
    }

    public List<Carrera> listarCarreras() {
        return carreraDao.listarCarreras();
    }
    
    public Carrera buscarCarrera(Carrera carrera){
        return carreraDao.buscarCarrera(carrera);
    }
    
    public int modificarCarrera(int idOld, Carrera updatedCarrera){
        return carreraDao.modificarCarrera(idOld, updatedCarrera);
    }
    
    public int agregarCarrera(Carrera carrera){
        return carreraDao.agregarCarrera(carrera);
    }
    
    public int eliminarCarrera(Carrera carrera){
        return carreraDao.eliminarCarrera(carrera);
    }
    
    public List<Alumno> listarAlumnos() {
        return alumnoDao.listarAlumnos();
    }
    
    public Alumno buscarAlumno(int idAlumno){
        return alumnoDao.buscarAlumno(idAlumno);
    }
    
    
    public int modificarAlumno(Alumno oldAlumno, Alumno updatedAlumno){
        return alumnoDao.modificarAlumno(oldAlumno, updatedAlumno);
    }
    
    public int agregarAlumno(Alumno alumno){
        return alumnoDao.agregarAlumno(alumno);
    }
    
    public int eliminarAlumno(Alumno alumno){
        return alumnoDao.eliminarAlumno(alumno);
    }
    
    public List<Alumno> listarAlumnosDeCarrera(int idCarrera){
        return alumnoDao.listarAlumnosDeCarrera(idCarrera);
    }

    public int matricularAlumno(Alumno alumno, Carrera carrera) {
        return alumnoDao.matricularAlumno(alumno, carrera);
    }
    
    public List<Catedratico> listarCatedraticos() {
        return catedraticoDao.listarCatedraticos();
    }
    
    public Catedratico buscarCatedratico(int idCatedratico){
        return catedraticoDao.buscarCatedratico(idCatedratico);
    }
    
    public int modificarCatedratico(Catedratico oldCatedratico, Catedratico updatedCatedratico){
        return catedraticoDao.modificarCatedratico(oldCatedratico, updatedCatedratico);
    }
    
    public int agregarCatedratico(Catedratico catedratico){
        return catedraticoDao.agregarCatedratico(catedratico);
    }
    
    public int eliminarCatedratico(Catedratico catedratico){
        return catedraticoDao.eliminarCatedratico(catedratico);
    }
}
