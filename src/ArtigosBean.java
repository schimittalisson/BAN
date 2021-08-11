/**
 *
 * @author alisson
 */
public class ArtigosBean {
    private int artigoid;
    private String titulo;
    private int tipoid;
    private int edicaoid;
    private TiposBean tipos;

    public ArtigosBean(int artigoid, String titulo, int tipoid, int edicaoid) {
        this.artigoid = artigoid;
        this.titulo = titulo;
        this.tipoid = tipoid;
        this.edicaoid = edicaoid;
    }

    public int getArtigoid() {
        return artigoid;
    }

    public void setArtigoid(int artigoid) {
        this.artigoid = artigoid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipoid() {
        return tipoid;
    }

    public void setTipoid(int tipoid) {
        this.tipoid = tipoid;
    }

    public int getEdicaoid() {
        return edicaoid;
    }

    public void setEdicaoid(int edicaoid) {
        this.edicaoid = edicaoid;
    }

    public TiposBean getTipos() {
        return tipos;
    }

    public void setTipos(TiposBean tipos) {
        this.tipos = tipos;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ArtigoID: " +artigoid+ " Titulo: " +titulo+ " TipoID: " +tipoid+ " EdiçãoID: " +edicaoid);
        if (tipos != null) {
            sb.append(" Nome tipo: " +tipos.getNome());
        }
        return sb.toString();
    }
}
