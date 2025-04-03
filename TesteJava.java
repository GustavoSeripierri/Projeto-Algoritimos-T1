public class TesteJava {
    public static void main(String[] var0) {
        for (int var1 = 1; var1 <= 30; ++var1) {
            int[] vetor = new int[400000]; 
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (int)(Math.random() * 1000); 
            }
            NossoVetor var2 = new NossoVetor(vetor); 
            System.out.println(var2.selectionSort());
        }
    }
}
