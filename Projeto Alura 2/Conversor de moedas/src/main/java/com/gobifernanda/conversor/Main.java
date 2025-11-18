package com.gobifernanda.conversor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Set<String> CODIGOS_VALIDOS = Set.of(
        "USD", "BRL", "EUR", "GBP", "JPY", "ARS", "CAD", "AUD", "CHF", "CNY"
    );

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConversorService conversor = new ConversorService();

            System.out.print("Moeda de origem (ex: BRL): ");
            String from = scanner.nextLine().trim().toUpperCase();
            if (!CODIGOS_VALIDOS.contains(from)) {
                System.out.println("❌ Código de moeda de origem inválido: " + from);
                return;
            }

            System.out.print("Moeda de destino (ex: USD): ");
            String to = scanner.nextLine().trim().toUpperCase();
            if (!CODIGOS_VALIDOS.contains(to)) {
                System.out.println("❌ Código de moeda de destino inválido: " + to);
                return;
            }

            System.out.print("Valor a converter: ");
            String valorTexto = scanner.nextLine().replace(",", ".").trim();
            BigDecimal valor;
            try {
                valor = new BigDecimal(valorTexto);
            } catch (NumberFormatException e) {
                System.out.println("❌ Valor inválido. Digite um número válido.");
                return;
            }

            try {
                BigDecimal resultado = conversor.converter(from, to, valor);
                BigDecimal formatado = resultado.setScale(4, RoundingMode.HALF_UP);
                System.out.println("✅ Valor convertido: " + formatado + " " + to);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("❌ Erro inesperado ao converter: " + e.getMessage());
            }
        }
    }
}