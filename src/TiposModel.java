import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alisson
 */
public class TiposModel {
    static void create(TiposBean tb, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO tipos (tipoid, nome) VALUES (?,?)");
        st.setInt(1, tb.getTipoid());
        st.setString(2, tb.getNome());
        st.execute();
        st.close();
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT tipoid, nome FROM tipos";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            list.add(new TiposBean(result.getInt(1), result.getString(2)));
        }
        return list;
    }

}
