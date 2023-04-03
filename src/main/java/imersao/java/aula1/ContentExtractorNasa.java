package imersao.java.aula1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ContentExtractorNasa implements ContentExtractor {

    public List<Conteudo> extrairConteudo (String json) {

        // extrai os dados do json e retorna uma lista de chave/valor
        JsonParser parser = new JsonParser();
        List<Map<String, String>> rawContent = parser.parse(json);

        // corre o conteudo da lista de valores,
        // cria um novo conteudo e adiciona a lista de conteudos
        List<Conteudo> conteudos = new ArrayList<Conteudo>();
        for (Map<String, String> rawContentItem : rawContent ){

            Conteudo conteudoItem = new Conteudo(
                    rawContentItem.get("title"),
                    rawContentItem.get("url"),
                    10,
                    rawContentItem.get("title") );

            conteudos.add(conteudoItem);
        }

        return conteudos;
    }


}
