public class Cronometro {
    // Criar cronometro
    private long tempoInicial;
    private long tempoFinal;
    private long tempoTotal;

    // Metodos
    public void iniciar() {
        tempoInicial = System.currentTimeMillis();

    }

    public void parar() {
        tempoFinal = System.currentTimeMillis();
        tempoTotal = tempoFinal - tempoInicial;

        if (tempoTotal < 1000)
            System.out.println("Tempo total: " + tempoTotal + " milisegundos");
        else if (tempoTotal < 60000)
            System.out.println("Tempo total: " + tempoTotal / 1000 + " segundos");
        else
            System.out.println("Tempo total: " + tempoTotal / 60000 + " minutos");
    }

    public long getTempoTotal() {
        return tempoTotal;

    }

}
