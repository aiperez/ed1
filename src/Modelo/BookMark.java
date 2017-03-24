package Modelo;

/**
 *
 * @author <David Heredia>
 */
public class BookMark {
    private String titulo;
    private String url;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BookMark(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }
    public String toString (){
        return titulo+","+url;
    }
}
