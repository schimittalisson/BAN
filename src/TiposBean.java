/**
 *
 * @author alisson
 */
public class TiposBean {
    private int tipoid;
    private String nome;

    public TiposBean(int tipoid, String nome) {
        this.tipoid = tipoid;
        this.nome = nome;
    }

    public int getTipoid() {
        return tipoid;
    }

    public void setTipoid(int tipoid) {
        this.tipoid = tipoid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return "TipoID: " +tipoid+ " Nome: " +nome;
    }
}
