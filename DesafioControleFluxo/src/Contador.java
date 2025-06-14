import br.com.dio.exception.ParametrosInvalidosException;

import java.util.Scanner;

public class Contador {
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Informe o valor inicial:");
            final var inicio = entrada.nextInt();
            System.out.println("Informe o valor final:");
            final var fim = entrada.nextInt();

            try {
                verificarEntradas(inicio, fim);
                contarInteracoes(inicio, fim);
            } catch (ParametrosInvalidosException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void contarInteracoes(int inicio, int fim) {
        var contador = fim - inicio;
        int largura = String.valueOf(contador).length();

        System.out.printf("==========INICIO========%s\n", normalizarLimites(largura));

        String mensagem = gerarMensagem(largura);

        for (int interacao = 1; interacao <= contador; interacao++)
            System.out.printf(mensagem, interacao);

        System.out.printf("==========FIM===========%s\n\n", normalizarLimites(largura));
    }

    private static String normalizarLimites(final int largura){
        return "=".repeat(largura);
    }

    private static String gerarMensagem(final int largura){
        return "| Imprimindo o número %0" + largura + "d |\n";
    }

    private static void verificarEntradas(int inicio, int fim) throws ParametrosInvalidosException {
        if (inicio >= fim) throw new ParametrosInvalidosException();
    }
}