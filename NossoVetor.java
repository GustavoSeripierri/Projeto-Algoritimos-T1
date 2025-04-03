public class NossoVetor {
    private int[] vetor;
    public long comparacoes;
    public long trocas;
    public long comparacoesBusca;

    public NossoVetor(int[] vetor) {
        this.vetor = vetor;
    }

    // Métodos de ordenação (Bubble Sort)
    public long bubbleSort() {
        comparacoes = 0;
        trocas = 0;

        int n = vetor.length;
        boolean trocou = true;
        for (int i = 0; i < n - 1 && trocou; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
        }
        return trocas;
    }

    // Métodos de ordenação (Selection Sort)
    public long selectionSort() {
        comparacoes = 0;
        trocas = 0;

        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
                trocas++;
            }
        }
        return (trocas + comparacoes);
    }

    // Métodos de ordenação (Insertion Sort)
    public long insertionSort() {
        comparacoes = 0;
        trocas = 0;

        int n = vetor.length;
        for (int i = 1; i < n; i++) {
            int key = vetor[i];
            int j = i - 1;
            while (j >= 0) {
                comparacoes++;
                if (vetor[j] > key) {
                    vetor[j + 1] = vetor[j];
                    trocas++;
                    j--;
                } else {
                    break;
                }
            }
            vetor[j + 1] = key;
        }
        return (trocas + comparacoes);
    }

    // Método de busca linear
    public int buscaLinear(int chave) {
        comparacoesBusca = 0;
        for (int i = 0; i < vetor.length; i++) {
            comparacoesBusca++;
            if (vetor[i] == chave) {
                return i;
            }
        }
        return -1;
    }

    // Método de busca binária (vetor deve estar ordenado)
    public int buscaBinaria(int chave) {
        if (vetor == null || vetor.length == 0) {
            return -1;
        }
        int inicio = 0;
        int fim = vetor.length - 1;
        comparacoesBusca = 0;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            comparacoesBusca++;
            if (vetor[meio] == chave) {
                return meio;
            } else if (chave < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1;
    }
}