package imersao.java.aula1;

public class Classificacao {

    private String texto;
    private String nomeMarker;

    public Classificacao(Double score) {
        getMarker( score.intValue() );
        this.texto = texto;
    }

    private String getMarker(int score){
        if (score <= 7){
            texto = "Não, obrigado.";
            nomeMarker = "ruim.png";

        } else if (score > 7 && score < 9 ) {
            texto = "Vale conferir...";
            nomeMarker = "medio.png";

        } else { // nota maior que 8
            texto = "Imperdível!";
            nomeMarker = "otimo.png";
        }
       return nomeMarker;
    }

    public String getTexto() {
        return texto;
    }

    public String getNomeMarker() {
        return nomeMarker;
    }
}
