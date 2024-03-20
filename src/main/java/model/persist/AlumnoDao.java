/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import model.Carrera;

public class AlumnoDao {

    private final DbConnect dbConnect;

    public AlumnoDao() {
        dbConnect = new DbConnect();
    }

    private Alumno fromResultSet(ResultSet rs) throws SQLException {
        Alumno alumno;
        //Leemos los atributos de Alumnos
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String email = rs.getString("email");
        int idCarrera = rs.getInt("idCarreras");
        //Instanciamos un nuevo objeto Alumno con los datos obtenidos
        alumno = new Alumno(id, nombre, apellido, email, idCarrera);
        return alumno;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM alumnos;";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Alumno alumno = fromResultSet(rs);
                    //Comprobamos que el alumno sea válido
                    if (alumno != null) {
                        result.add(alumno);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
            result = null;
        }
        return result;
    }

    public Alumno buscarAlumno(int idAlumno) {
        Alumno result = null;
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM alumnos WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, idAlumno);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    result = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }

    public int agregarAlumno(Alumno alumno) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "INSERT INTO alumnos VALUES (null, ?, ?, ?, ?);";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, alumno.getNombre());
                st.setString(2, alumno.getApellido());
                st.setString(3, alumno.getEmail());
                int idCarrera = alumno.getIdCarrera();
                if (idCarrera == 0) {
                    st.setNull(4, java.sql.Types.INTEGER);
                } else {
                    st.setInt(4, alumno.getIdCarrera());
                }
                result = st.executeUpdate();
            }

        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }

    public int modificarAlumno(Alumno oldAlumno, Alumno updatedAlumno) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "UPDATE alumnos SET nombre = ?, apellido = ?, email = ?, idCarrera = ? WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, updatedAlumno.getNombre());
                st.setString(2, updatedAlumno.getApellido());
                st.setString(3, updatedAlumno.getEmail());
                st.setInt(4, updatedAlumno.getIdCarrera());
                st.setInt(5, oldAlumno.getId());
                result = st.executeUpdate();
            }
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }

    public int eliminarAlumno(Alumno alumno) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "DELETE FROM alumnos WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, alumno.getId());
                result = st.executeUpdate();
            }
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }

    public List<Alumno> listarAlumnosDeCarrera(int idCarrera) {
        List<Alumno> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM alumnos WHERE idCarrera = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, idCarrera);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Alumno alumno = fromResultSet(rs);
                    //Comprobamos que el alumno sea válido
                    if (alumno != null) {
                        result.add(alumno);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            result = null;
        }
        return result;
    }

    public int matricularAlumno(Alumno alumno, Carrera carrera) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            String query = "UPDATE alumnos SET idCarrera = ? WHERE id = ?;";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, carrera.getId());
            st.setInt(2, alumno.getId());
            result = st.executeUpdate();
        } catch (SQLException ex) {
            result = 0;
            //Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
