package com.gobifernanda.conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversorGUI extends JFrame {

    private final JTextField campoOrigem = new JTextField(5);
    private final JTextField campoDestino = new JTextField(5);
    private final JTextField campoValor = new JTextField(10);
    private final JLabel resultadoLabel = new JLabel("Valor convertido: ");
    private final ConversorService conversor = new ConversorService();

    public ConversorGUI() {
        super("Conversor de Moedas");

        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        add(new JLabel("Moeda de origem (ex: BRL):"));
        add(campoOrigem);

        add(new JLabel("Moeda de destino (ex: USD):"));
        add(campoDestino);

        add(new JLabel("Valor a converter:"));
        add(campoValor);

        JButton botaoConverter = new JButton("Converter");
        botaoConverter.addActionListener(this::converterMoeda);
        add(botaoConverter);
        add(resultadoLabel);

        setVisible(true);
    }

    private void converterMoeda(ActionEvent e) {
        try {
            String from = campoOrigem.getText().trim().toUpperCase();
            String to = campoDestino.getText().trim().toUpperCase();
            String valorTexto = campoValor.getText().replace(",", ".").trim();

            BigDecimal valor = new BigDecimal(valorTexto);
            BigDecimal resultado = conversor.converter(from, to, valor);
            BigDecimal formatado = resultado.setScale(4, RoundingMode.HALF_UP);

            resultadoLabel.setText("Valor convertido: " + formatado + " " + to);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConversorGUI::new);
    }
}