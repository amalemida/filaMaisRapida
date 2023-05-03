public class App {
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        System.out.println("Enfileirando.");
        FilaCircular<Integer> fila;
        try {
            fila = new FilaCircular<Integer>(5);

            for (int i = 1; i <= 5; i++) {
                fila.guardeUmItem(i);
            }
           fila.estadoDaFila();

            System.out.println("Desenfileirando...");
            c.iniciar();
            for (int i = 1; i <= 5; i++) {
                // System.out.print(fila.recupereUmItem());
                fila.removaUmItem();
            }
            fila.estadoDaFila();
       
          
            c.parar();

            if (fila.estaVazia()) {
                System.out.println("\nEnfileirando novamente.");
                for (int i = 1; i <= 5; i++) {
                    fila.guardeUmItem(i);
                }
            }
            fila.estadoDaFila();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
