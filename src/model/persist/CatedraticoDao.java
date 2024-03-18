package model.persist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Catedratico;

public class CatedraticoDao {
    private final DbConnect dbConnect;
    
    public CatedraticoDao(){
        dbConnect = new DbConnect();
    }
    
    private Catedratico fromResultSet(ResultSet rs) throws SQLException{
        Catedratico catedratico;
        //Leemos los atributos de Catedratico
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        //Instanciamos un nuevo objeto Alumno con los datos obtenidos
        catedratico = new Catedratico(id, nombre);
        return catedratico;
    }
    
    public List<Catedratico> listarCatedraticos(){
        List<Catedratico> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM catedraticos;";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Catedratico catedratico = fromResultSet(rs);
                    //Comprobamos que el catedratico sea válido
                    if (catedratico != null) {
                        result.add(catedratico);
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }
    
    public Catedratico buscarCatedratico(int idCatedratico) {
        Catedratico result = null;
        try (Connection conn = dbConnect.getConnection()) {
            //Si la conexión es exitosa
            if (conn != null) {
                String query = "SELECT * FROM catedraticos WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, idCatedratico);
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
    
    public int agregarCatedratico(Catedratico catedratico) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "INSERT INTO catedraticos VALUES (null, ?);";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, catedratico.getNombre());
                result = st.executeUpdate();
            }

        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }
    
    public int modificarCatedratico(Catedratico oldCatedratico, Catedratico updatedCatedratico) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "UPDATE catedraticos SET nombre = ? WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, updatedCatedratico.getNombre());
                st.setInt(2, oldCatedratico.getId());
                result = st.executeUpdate();
            }
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }
    
    public int eliminarCatedratico(Catedratico catedratico) {
        int result = 0;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                String query = "DELETE FROM catedraticos WHERE id = ?;";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, catedratico.getId());
                result = st.executeUpdate();
            }
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }
}
