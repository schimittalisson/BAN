import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author alisson
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 0:
                        break;
                    case 1:
                        new ArtigosController().createArtigo(con);
                        break;
                    case 2:
                        new TiposController().createTipo(con);
                        break;
                    case 3:
                        new ArtigosController().listArtigos(con);
                        break;
                    case 4:
                        new TiposController().listarTipos(con);
                        break;
                    case 5:
                        new ArtigosController().listarArtigosTipos(con);
                        break;
                    case 6:
                        System.out.println("Digite o TipoID que deseja buscar artigos relacionados: ");
                        Scanner input = new Scanner(System.in);
                        new ArtigosController().listarArtigosTipoFornecido(con, input.nextInt());
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida: ");
                        break;
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<6);
        con.close();
    }

    private static int menu() {
        System.out.println("|*******************************************************************|");
        System.out.println("|                           MENU DE OPÇÕES                          |");
        System.out.println("|*******************************************************************|");
        System.out.println("Informe o número da opção que deseja executar: ");
        System.out.println("1 - Inserir um novo artigo;");
        System.out.println("2 - Inserir um novo tipo de artigo;");
        System.out.println("3 - Exibir todos os artigos;");
        System.out.println("4 - Exibir todos os tipos de artigos;");
        System.out.println("5 - Exibir todos os artigos e seus respectivos tipos;");
        System.out.println("6 - Exibir todos os artigos com um tipoID fornecido;");
        System.out.println("Digite 0  para sair.");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
