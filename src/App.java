public class App {
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        System.out.println("Enfileirando.");
        FilaCircular<Integer> fila;
        try {
            fila = new FilaCircular<Integer>(1000000);

            for (int i = 1; i <= 1000000; i++) {
                fila.guardeUmItem(i);
              //  System.out.println("Elemento guardado "+ i);
            }
           fila.estadoDaFila();

            System.out.println("Desenfileirando...");
            c.iniciar();
            
            for (int i = 1; i <= 1000000; i++) {
                 fila.removaUmItem();
              //  System.out.println("Elemento removido "+i );
            }
            fila.estadoDaFila();
       
          
            c.parar();

            if (fila.estaVazia()) {
                System.out.println("\nEnfileirando novamente.");
                for (int i = 1; i <= 1000000; i++) {
                    fila.guardeUmItem(i);
                  //  System.out.println("Elemento guardado novamante " + i);
                }
            }
            fila.estadoDaFila();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
