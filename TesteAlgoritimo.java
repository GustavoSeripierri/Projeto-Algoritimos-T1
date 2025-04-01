import java.util.Random;
import java.util.Scanner;

public class TesteAlgoritimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int tamanhoVetor = 100000; 

        int[] vetorOriginal = new int[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor; i++) {
            vetorOriginal[i] = random.nextInt(100); 
        }  
        
        int[] vetorAtual = vetorOriginal.clone();
        NossoVetor nossoVetor = new NossoVetor(vetorAtual);
        boolean vetorOrdenado = false; 

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ordenação: Bubble Sort");
            System.out.println("2. Ordenação: Insertion Sort");
            System.out.println("3. Ordenação: Selection Sort");
            System.out.println("4. Busca: Busca Linear");
            System.out.println("5. Busca: Busca Binária");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Bubble Sort
                    vetorAtual = vetorOriginal.clone();
                    nossoVetor = new NossoVetor(vetorAtual);
                    nossoVetor.bubbleSort();
                    vetorOrdenado = true;
                    System.out.println("\n\nNúmero de comparações e trocas: " + nossoVetor.comparacoes + nossoVetor.trocas);
                    break;

                case 2: // Insertion Sort
                    vetorAtual = vetorOriginal.clone();
                    nossoVetor = new NossoVetor(vetorAtual);
                    nossoVetor.insertionSort();
                    vetorOrdenado = true;
                    System.out.println("\n\nNúmero de comparações e trocas: " + nossoVetor.comparacoes + nossoVetor.trocas);
                    break;

                case 3: // Selection Sort
                    vetorAtual = vetorOriginal.clone();
                    nossoVetor = new NossoVetor(vetorAtual);
                    nossoVetor.selectionSort();
                    vetorOrdenado = true;
                    System.out.println("\n\nNúmero de comparações e trocas: " + nossoVetor.comparacoes + nossoVetor.trocas);
                    break;

                case 4: // Busca Linear
                    int valorBuscaLinear = 42; // Número fixo para a busca linear
                    int resultadoBuscaLinear = nossoVetor.buscaLinear(valorBuscaLinear);
                    System.out.println("Resultado da Busca Linear: " + (resultadoBuscaLinear != -1 ? "Encontrado no índice " + resultadoBuscaLinear : "Não encontrado"));
                    System.out.println("Número de comparações: " + nossoVetor.comparacoesBusca);
                    break;
                
                case 5: // Busca Binária
                    if (!vetorOrdenado) {
                        System.out.println("Erro: O vetor precisa estar ordenado para realizar a Busca Binária.");
                        break;
                    }
                    int valorBuscaBinaria = 42; // Número fixo para a busca binária
                    int resultadoBuscaBinaria = nossoVetor.buscaBinaria(valorBuscaBinaria);
                    System.out.println("Resultado da Busca Binária: " + (resultadoBuscaBinaria != -1 ? "Encontrado no índice " + resultadoBuscaBinaria : "Não encontrado"));
                    System.out.println("Número de comparações: " + nossoVetor.comparacoesBusca);
                    break;

                case 6: // Sair
                    System.out.println("Encerrando o programa. Até breve...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}