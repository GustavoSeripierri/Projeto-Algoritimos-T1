public class MacTeste {
    public static void main(String[] args) {
       for (int i = 1; i<= 10; i++) {
            NossoVetor v = new NossoVetor(400000);
            System.out.println(v.bubbleSort());
        }
    }
}
