package com.gobifernanda.conversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversorService {

    private final ExchangeApiClient apiClient;

    public ConversorService() {
        this.apiClient = new ExchangeApiClient();
    }

    public BigDecimal converter(String moedaOrigem, String moedaDestino, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        BigDecimal taxa = apiClient.getRate(moedaOrigem, moedaDestino);
        return valor.multiply(taxa).setScale(6, RoundingMode.HALF_UP);
    }
}