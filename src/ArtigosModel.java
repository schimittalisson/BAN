
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alisson
 */
public class ArtigosModel {
    public static void create(ArtigosBean a, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO artigos (artigoid, titulo, tipoid, edicaoid) VALUES (?,?,?,?)");
        st.setInt(1, a.getArtigoid());
        st.setString(2, a.getTitulo());
        st.setInt(3, a.getTipoid());
        st.setInt(4, a.getEdicaoid());
        st.execute();
        st.close();
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT artigoid, titulo, tipoid, edicaoid FROM artigos";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            list.add(new ArtigosBean(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4)));
        }
        return list;
    }

    static HashSet listAllWithTipos(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT artigoid, titulo, artigos.tipoid, edicaoid, nome FROM artigos NATURAL JOIN tipos";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            ArtigosBean a = new ArtigosBean(result.getInt(1), result.getString(2), result.getInt(3),
                    result.getInt(4));
            TiposBean tb = new TiposBean(result.getInt(3), result.getString(5));
            a.setTipos(tb);
            list.add(a);
        }
        return list;
    }

    static HashSet listAllWithDefinedTipo(Connection con, int tipoidFornecido) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT artigoid, titulo, artigos.tipoid, edicaoid FROM artigos WHERE artigos.tipoid = ANY ("
                + "SELECT " + tipoidFornecido + "FROM tipos)";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            list.add(new ArtigosBean(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4)));
        }
        return list;
    }
}
