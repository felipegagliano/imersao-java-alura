package imersao.java.aula1;

public class Conteudo {

    private final String titulo;
    private final String urlImagem;
    private final int score;
    private final String texto;

    public Conteudo (String titulo, String urlImagem, int score, String texto){
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.score = score;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public int getScore() {
        return score;
    }
    public String getTexto() {
        return texto;
    }
}
