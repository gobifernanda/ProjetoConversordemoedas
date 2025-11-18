package com.gobifernanda.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeApiClient {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("EXCHANGE_API_KEY");

    public BigDecimal getRate(String base, String alvo) {
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalStateException("Chave da API não encontrada. Verifique o arquivo .env.");
        }

        try {
            String endpoint = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, base);
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
                JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

                if (!json.get("result").getAsString().equals("success")) {
                    throw new RuntimeException("Falha ao obter dados da API.");
                }

                JsonObject rates = json.getAsJsonObject("conversion_rates");
                if (!rates.has(alvo)) {
                    throw new IllegalArgumentException("Moeda de destino inválida: " + alvo);
                }

                double taxaDouble = rates.get(alvo).getAsDouble();
                return BigDecimal.valueOf(taxaDouble);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar com a API de câmbio.");
        }
    }
}