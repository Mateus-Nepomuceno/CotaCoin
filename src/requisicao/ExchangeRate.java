package requisicao;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRate {
    public Cotacao consultarValor(String moedaBase) {
        var url = "https://v6.exchangerate-api.com/v6/SUA_NOVA_CHAVE/latest/" + moedaBase;
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cotacao.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Houve um erro ao consultar os dados.");
        }
    }
}
