import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alisson
 */
public class TiposController {
    public void createTipo(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar um novo tipo de artigo: ");
        System.out.print("TipoID: ");
        int tipoid = input.nextInt();
        System.out.print("Nome: ");
        String nome = input.nextLine();

        TiposBean tb = new TiposBean(tipoid, nome);
        TiposModel.create(tb, con);
        System.out.println("Tipo criado com sucesso!");
    }

    void listarTipos(Connection con) throws SQLException {
        HashSet all = TiposModel.listAll(con);
        Iterator<TiposBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
