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
public class ArtigosController {
    public void createArtigo(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados a seguir para a criar um novo Artigo: ");
        System.out.print("ArtigoID: ");
        int artigoid = input.nextInt();
        System.out.print("Título: ");
        String titulo = input.next();
        System.out.print("TipoID: ");
        int tipoid = input.nextInt();
        System.out.print("EdicaoID: ");
        int edicaoid = input.nextInt();
        ArtigosBean ab = new ArtigosBean (artigoid, titulo, tipoid, edicaoid);
        ArtigosModel.create(ab, con);
        System.out.println("Artigo criado com sucesso!");
    }

    void listArtigos(Connection con) throws SQLException {
        HashSet all = ArtigosModel.listAll(con);
        Iterator<ArtigosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void listarArtigosTipos(Connection con) throws SQLException {
        HashSet all = ArtigosModel.listAllWithTipos(con);
        Iterator<ArtigosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void listarArtigosTipoFornecido(Connection con, int tipoidFornecido) throws  SQLException {
        HashSet all = ArtigosModel.listAllWithDefinedTipo(con, tipoidFornecido);
        Iterator<ArtigosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
