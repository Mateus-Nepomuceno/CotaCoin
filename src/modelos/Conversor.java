package modelos;

import requisicao.Cotacao;

public class Conversor {
    private double valorDolar;
    private double valorReal;
    private double valorPesoArg;
    private double valorPesoCol;

    public Conversor(Cotacao cotacao) {
        this.valorDolar = cotacao.conversion_rates().USD();
        this.valorReal = cotacao.conversion_rates().BRL();
        this.valorPesoArg = cotacao.conversion_rates().ARS();
        this.valorPesoCol = cotacao.conversion_rates().COP();
    }

    public void escolheConversao(int opcao, double valor) {
        double resultado = 0;
        String moedaOrigem = "", moedaDestino = "";
        switch (opcao) {
            case 1:
                resultado = this.converte(valor, this.valorDolar, this.valorPesoArg);
                moedaOrigem = "USD";
                moedaDestino = "ARS";
                break;
            case 2:
                resultado = this.converte(valor, this.valorPesoArg, this.valorDolar);
                moedaOrigem = "ARS";
                moedaDestino = "USD";
                break;
            case 3:
                resultado = this.converte(valor, this.valorDolar, this.valorReal);
                moedaOrigem = "USD";
                moedaDestino = "BRL";
                break;
            case 4:
                resultado = this.converte(valor, this.valorReal, this.valorDolar);
                moedaOrigem = "BRL";
                moedaDestino = "USD";
                break;
            case 5:
                resultado = this.converte(valor, this.valorDolar, this.valorPesoCol);
                moedaOrigem = "USD";
                moedaDestino = "COP";
                break;
            case 6:
                resultado = this.converte(valor, this.valorPesoCol, this.valorDolar);
                moedaOrigem = "COP";
                moedaDestino = "USD";
                break;
        }
        System.out.printf("|->  Valor %.2f [%s] corresponde a %.2f [%s].\n",valor,moedaOrigem,resultado,moedaDestino);
    }

    public double converte(double valor, double moedaOrigem, double moedaDestino) {
        return (valor / moedaOrigem) * moedaDestino;
    }

    @Override
    public String toString() {
        return "Cotação:" +
                "\nDólar: " + valorDolar +
                "\nReal: " + valorReal +
                "\nPeso Argentino: " + valorPesoArg +
                "\nPeso Colombiano: " + valorPesoCol;
    }
}