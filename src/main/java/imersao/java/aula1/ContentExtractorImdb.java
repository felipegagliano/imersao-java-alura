package imersao.java.aula1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorImdb implements ContentExtractor {

    public List<Conteudo> extrairConteudo (String json) {

        // extrai os dados do json e retorna uma lista de chave/valor
        JsonParser parser = new JsonParser();
        List<Map<String, String>> rawContent = parser.parse(json);

        // corre o conteudo da lista de valores,
        // cria um novo conteudo e adiciona a lista de conteudos
        List<Conteudo> conteudos = new ArrayList<Conteudo>();
        for (Map<String, String> rawContentItem : rawContent ){

            Double score = Double.parseDouble( rawContentItem.get("imDbRating") );

            var classificacao = new Classificacao(score);

            String texto = classificacao.getTexto();

            Conteudo conteudoItem = new Conteudo(
                    rawContentItem.get("title"),
                    rawContentItem.get("image"),
                    score.intValue(),
                    texto
            );
            conteudos.add(conteudoItem);
        }

        return conteudos;
    }


}
