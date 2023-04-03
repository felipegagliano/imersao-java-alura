package imersao.java.aula1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    public String buscaDados(String url) {
        var client = HttpClient.newHttpClient();
        var endereco = URI.create(url);
        var request = HttpRequest.newBuilder(endereco).GET().build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getLocalizedMessage() );
            return null;
        }
    }
}
