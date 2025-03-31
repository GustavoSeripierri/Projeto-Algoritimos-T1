import java.util.Random;
import java.util.Scanner;

public class TesteAlgoritimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int tamanhoVetor = 100000; 

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Busca Linear");
            System.out.println("5. Busca Binária");
            System.out.println("6. Testes (10 execuções de cada algoritmo)");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Bubble Sort
                    executarTeste("Bubble Sort", tamanhoVetor);
                    break;

                case 2: // Insertion Sort
                    executarTeste("Insertion Sort", tamanhoVetor);
                    break;

                case 3: // Selection Sort
                    executarTeste("Selection Sort", tamanhoVetor);
                    break;

                case 4: // Busca Linear
                    executarBuscaLinear(tamanhoVetor);
                    break;
                
                case 5: // Busca Binária
                    executarBuscaBinaria(tamanhoVetor);
                    break;

                case 6: // Testes de 10 execuções
                    executarTestes(tamanhoVetor);
                    break;

                case 7: // Sair
                    System.out.println("Encerrando o programa. Até breve...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void executarTeste(String tipoOrdenacao, int tamanhoVetor) {
        int[] vetorAtual = gerarVetorAleatorio(tamanhoVetor);
        NossoVetor nossoVetor = new NossoVetor(vetorAtual);
        switch (tipoOrdenacao) {
            case "Bubble Sort":
                nossoVetor.bubbleSort();
                break;
            case "Insertion Sort":
                nossoVetor.insertionSort();
                break;
            case "Selection Sort":
                nossoVetor.selectionSort();
                break;
        }
        System.out.println("\nNúmero de comparações e trocas: " + (nossoVetor.comparacoes + nossoVetor.trocas));
    }

    private static void executarBuscaLinear(int tamanhoVetor) {
        int[] vetorAtual = gerarVetorAleatorio(tamanhoVetor);
        NossoVetor nossoVetor = new NossoVetor(vetorAtual);
        int valorBuscaLinear = 42; 
        int resultadoBuscaLinear = nossoVetor.buscaLinear(valorBuscaLinear);
        System.out.println("Resultado da Busca Linear: " + (resultadoBuscaLinear != -1 ? "Encontrado no índice " + resultadoBuscaLinear : "Não encontrado"));
        System.out.println("Número de comparações: " + nossoVetor.comparacoesBusca);
    }

    private static void executarBuscaBinaria(int tamanhoVetor) {
        int[] vetorAtual = gerarVetorAleatorio(tamanhoVetor);
        NossoVetor nossoVetor = new NossoVetor(vetorAtual);
        nossoVetor.bubbleSort(); // Ordena o vetor para a busca binária
        int valorBuscaBinaria = 42; 
        int resultadoBuscaBinaria = nossoVetor.buscaBinaria(valorBuscaBinaria);
        System.out.println("Resultado da Busca Binária: " + (resultadoBuscaBinaria != -1 ? "Encontrado no índice " + resultadoBuscaBinaria : "Não encontrado"));
        System.out.println("Número de comparações: " + nossoVetor.comparacoesBusca);
    }

    private static void executarTestes(int tamanhoVetor) {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Teste " + (i + 1) + " ---");
            executarTeste("Bubble Sort", tamanhoVetor);
            executarTeste("Insertion Sort", tamanhoVetor);
            executarTeste("Selection Sort", tamanhoVetor);
            executarBuscaLinear(tamanhoVetor);
            // Para busca binária, você deve garantir que o vetor esteja ordenado
            int[] vetorAtual = gerarVetorAleatorio(tamanhoVetor);
            NossoVetor nossoVetor = new NossoVetor(vetorAtual);
            nossoVetor.bubbleSort(); // Ordena o vetor para a busca binária
            executarBuscaBinaria(tamanhoVetor);
        }
    }

    private static int[] gerarVetorAleatorio(int tamanho) {
        Random random = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(100); // Gera números aleatórios entre 0 e 99
        }
        return vetor;
    }
}