public class Cronometro {
<<<<<<< HEAD
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
=======
	private int segundos;
	private int minutos;
	
	Timer timer = new Timer();
>>>>>>> 1918af61a45286c221e8c35fbc645187f33dfa7b

        if (tempoTotal < 1000)
            System.out.println("Tempo total: " + tempoTotal + " milisegundos");
        else if (tempoTotal < 60000)
            System.out.println("Tempo total: " + tempoTotal / 1000 + " segundos");
        else
            System.out.println("Tempo total: " + tempoTotal / 60000 + " minutos");
    }

<<<<<<< HEAD
    public long getTempoTotal() {
        return tempoTotal;

    }
=======
	public void iniciar() {
		TimerTask tarefa = new TimerTask() {
			public void run() {
				segundos++;
			}
		};

		timer.scheduleAtFixedRate(tarefa, 0, 1000);
	}
	
	public void parar() {
		timer.cancel();
		
		if (segundos <= 60) {
			System.out.println("Tempo gasto: "+ segundos +" segundos.");
		}else  {
			minutos = segundos / 60;
			System.out.println("Tempo gasto: "+ minutos +" minutos.");
		}
		
	}
>>>>>>> 1918af61a45286c221e8c35fbc645187f33dfa7b

}
