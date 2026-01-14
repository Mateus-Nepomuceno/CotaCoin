import modelos.Conversor;
import requisicao.ExchangeRate;
import requisicao.Cotacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExchangeRate exchangeRate = new ExchangeRate();
        boolean isEncerrado = false;

        Cotacao conversao = exchangeRate.consultarValor("USD");
        Conversor conversor = new Conversor(conversao);

        while (!isEncerrado) {
            System.out.print("""
                    _________________________________
                    |     Bem-vindo ao CotaCoin     |
                    |-------------------------------|
                    |  [1] Dólar -> Peso argentino  |
                    |  [2] Peso argentino -> Dólar  |
                    |  [3] Dólar -> Real brasileiro |
                    |  [4] Real brasileiro -> Dólar |
                    |  [5] Dólar -> Peso colombiano |
                    |  [6] Peso colombiano -> Dólar |
                    |  [7] Encerrar programa        |
                    ---------------------------------
                    
                    Escolha uma opção válida:ㅤ""");
            try {
                int opcao = sc.nextInt();
                if (opcao == 7) {
                    System.out.println("Encerrando...");
                    isEncerrado = true;
                } else if (opcao < 1 || opcao > 7) {
                    System.out.println("Opção inválida, digite um número entre 1 e 7.");
                } else {
                    System.out.print("Digite o valor que deseja converter: ");
                    double valor = sc.nextDouble();
                    conversor.escolheConversao(opcao, valor);
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números.");
                sc.nextLine();
            }
        }
    }
}