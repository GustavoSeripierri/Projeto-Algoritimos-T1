public class MacTeste {
    public static void main(String[] args) {
       for (int i = 1; i<= 10; i++) {
            NossoVetor v = new NossoVetor(100000);
            System.out.println(v.selectionSort());
        }
    }
}
