import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Seja bem-vindo ao Jogo no Numero Secreto!");
            System.out.println("Para sair do jogo basta digitar sair.");
            System.out.println("Escolha o intervalo do número gerado.");

            System.out.print("Digite o valor minimo: ");
            int valorMinimo = scanner.nextInt();

            System.out.print("Digite o valor maximo: ");
            int valorMaximo = scanner.nextInt();

            if (valorMinimo > valorMaximo) {
                System.out.println("Erro: Valor minimo maior que valor.");

            } else {
                Random numeroGerado = new Random();
                int numeroTratado = numeroGerado.nextInt((valorMaximo - valorMinimo) + 1) + valorMinimo;

                System.out.println(numeroTratado);

                int numeroTentativas = 0;
                int tentativa = 0;

                System.out.print("Digite um valor para tentar descobrir: ");
                tentativa = scanner.nextInt();

                while (tentativa != numeroTratado) {

                    if (tentativa < valorMinimo || tentativa > valorMaximo) {
                        System.out.println("Digite um valor dentro do escopo dos valores minimos e maximos.");

                    } else if (tentativa < numeroTratado) {
                        System.out.print("O numero digitado e muito baixo, digite outro: ");
                        tentativa = scanner.nextInt();
                        numeroTentativas++;

                    } else {
                        System.out.print("O numero digitado e muito alto, digite outro: ");
                        tentativa = scanner.nextInt();
                        numeroTentativas++;

                    }
                }
                System.out.printf("Voce acertou o numero secreto. Com %d tentativas.", numeroTentativas);
            }

        } catch (Exception e){
            String entradaSaida = scanner.nextLine();

            if (entradaSaida.equals("sair")) {
                System.out.println("Voce saio do jogo!");
                System.exit(0);

            } else{
                System.out.println("Erro: '" + entradaSaida + "' Essa entrada e invalida!");
                System.exit(0);

            }
        }

        scanner.close();
    }
}