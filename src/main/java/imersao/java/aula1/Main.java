package imersao.java.aula1;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        // APIs comsumidas para cada tipo de lista:
        Api api = Api.NASA_APOD;

        //abre a conexao com a API
        var clienteHttp = new ClienteHttp();
        String json = clienteHttp.buscaDados(api.getUrl());

        // extrai os conteudos do json
        ContentExtractor extrator = api.getContentExtractor();

        // ContentExtractor extrator = new ContentExtractorNasa();
        List<Conteudo> conteudos = extrator.extrairConteudo(json);

        // cria o objeto GeradorDeFigurinhas
        var gerador = new GeradorDeFigurinhas();

        // exibe as informações
        for (Conteudo conteudo : conteudos) {

            InputStream is = new URL(conteudo.getUrlImagem()).openStream();
            gerador.cria(is, conteudo.getTitulo().replace(":", "-"), conteudo.getTexto(), (double)conteudo.getScore() );

            // exibe as informções no terminal
            System.out.print("\u001b[34m\u001b[3mTitulo: \u001b[0m");
            System.out.println("\u001b[1m" + conteudo.getTitulo() + "\u001b[0m");

            System.out.print("\u001b[31m\u001b[3mPoster: \u001b[0m");
            System.out.println("\u001b[1m" + conteudo.getUrlImagem() + "\u001b[0m");

            System.out.println();
        }
    }
}