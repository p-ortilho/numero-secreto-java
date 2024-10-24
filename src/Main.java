import java.util.Random;
import java.util.Scanner;
/**
 @author p-ortilho
 */
public class Main {
    public static void main(String[] args) {
        // Objeto para pegar as entradas do usuario
        Scanner scanner = new Scanner(System.in);

        try {

            // Menu do jogo
            System.out.println("Seja bem-vindo ao Jogo no Numero Secreto!");
            System.out.println("Para sair do jogo basta digitar sair.");
            System.out.println("Escolha o intervalo do número gerado.");

            // Entrada do valor minimo
            System.out.print("Digite o valor minimo: ");
            int valorMinimo = scanner.nextInt();

            // Entrada do valor maximo
            System.out.print("Digite o valor maximo: ");
            int valorMaximo = scanner.nextInt();

            // Condição para verificar a entrada
            if (valorMinimo > valorMaximo) {
                System.out.println("Erro: Valor minimo maior que valor.");

            } else {

                // Gerando o numero secreto
                Random numeroGerado = new Random();
                int numeroTratado = numeroGerado.nextInt((valorMaximo - valorMinimo) + 1) + valorMinimo;

                //System.out.println(numeroTratado);

                // Variavel do numero de tentativas
                int numeroTentativas = 0;

                // Variavel que guarda a tentativa do usuario
                int tentativa = 0;

                // Atribuindo o valor de entarda na variavel tentativa
                System.out.print("Digite um valor para tentar descobrir: ");
                tentativa = scanner.nextInt();

                // Looping roda enquanto a tentiva não estiver correta
                while (tentativa != numeroTratado) {

                    // Condição para verificar se o valor de entarda esta dentro do escopo do numero gerado
                    if (tentativa < valorMinimo || tentativa > valorMaximo) {
                        System.out.println("Digite um valor dentro do escopo dos valores minimos e maximos.");
                    }
                    // Verifica se o numero da tentativa do usuario e menor do que o numero gerado
                    else if (tentativa < numeroTratado) {
                        // Resposta para o usuario
                        System.out.print("O numero digitado e muito baixo, digite outro: ");
                        tentativa = scanner.nextInt();
                        numeroTentativas++;

                    }
                    // Verifica se o numero da tentativa do usuario e maior que o numero gerado
                    else {
                        // Resposta para o usuario
                        System.out.print("O numero digitado e muito alto, digite outro: ");
                        tentativa = scanner.nextInt();
                        numeroTentativas++;

                    }
                }
                // Resposta para o usuario caso ele acerte o numero
                System.out.printf("Voce acertou o numero secreto. Com %d tentativas.", numeroTentativas);
            }
        // Tratando excecoes
        } catch (Exception e){
            // Pega o valor invalido que o usuario digitar
            String entradaSaida = scanner.nextLine();

            // Condicao para verificar se o valor enviado pelo usuario corresponde a strinf sair
            if (entradaSaida.equals("sair")) {
                // Resposta para o usuario quando sair
                System.out.println("Voce saio do jogo!");
                System.exit(0);

            } else{
                // Trata outras entradas invalidas do usuario
                System.out.println("Erro: '" + entradaSaida + "' Essa entrada e invalida!");
                System.exit(0);

            }
        }

        // Finaliza o objeto de entradas do usuario
        scanner.close();
    }
}