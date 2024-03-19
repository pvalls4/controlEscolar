package model.persist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrera;

public class CarreraDao {

    private final DbConnect dbConnect;

    public CarreraDao(){
        dbConnect = new DbConnect();
        //DbConnect.loadDriver();
    }

    private Carrera fromResultSet(ResultSet rs) throws SQLException {
        Carrera carrera;
        //Leemos los atributos de carrera
        int idCarrera = rs.getInt("id");
        String nombreCarrera = rs.getString("nombre");
        //Instanciamos un nuevo objeto Carrera con los datos obtenidos
        carrera = new Carrera(idCarrera, nombreCarrera);
        return carrera;
    }

    public List<Carrera> listarCarreras() {
        List<Carrera> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM carreras;";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Carrera carrera = fromResultSet(rs);
                    //Comprovamos que la carrera sea válida
                    if (carrera != null) {
                        result.add(carrera);
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }

    public Carrera buscarCarrera(Carrera carrera) {
        Carrera result = null;
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM carreras WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, carrera.getId());
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

    public int agregarCarrera(Carrera carrera) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "INSERT INTO carreras VALUES (null, ?);";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, carrera.getNombre());
                result = st.executeUpdate();
            }

        } catch (SQLException ex) {
            result = 0;
            System.out.println(ex);
        }
        return result;
    }

    public int modificarCarrera(Carrera oldCarrera, Carrera updatedCarrera) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "UPDATE carreras SET nombre = ? WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, updatedCarrera.getNombre());
                st.setInt(2, oldCarrera.getId());
                result = st.executeUpdate();
            }
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }

    public int eliminarCarrera(Carrera carrera) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "DELETE FROM carreras WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, carrera.getId());
                result = st.executeUpdate();
            }
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }
    
    
}
