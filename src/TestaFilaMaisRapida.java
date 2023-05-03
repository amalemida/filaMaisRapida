public class TestaFilaMaisRapida {

	public static void main(String[] args) throws Exception {
		FilaMaisRapida<Integer> fila = new FilaMaisRapida<Integer>(10000000);
//
//		for (int i = 1; i <= 5; i++) {
//			fila.guardeUmItem(i);
//
//		}
//
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(fila.recupereUmItem());
//			fila.removaUmItem();
//
//		}
//
//		for (int i = 1; i <= 5; i++) {
//			fila.guardeUmItem(i);
//
//		}
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(fila.recupereUmItem());
//			fila.removaUmItem();
//
//		}
//		System.out.println(fila.isVazia());

		int i = 0;
		try {
			Cronometro c = new Cronometro();
			System.out.println("Começou!");
			for (i = 1; i <= 10000000; i++) {
				fila.guardeUmItem(i);

			}

			c.iniciar();

			if (!fila.isVazia()) {
				System.out.println("\nA fila está cheia!\n");
			}
			for (i = 1; i <= 10000000; i++) {
				System.out.println(fila.recupereUmItem());
				fila.removaUmItem();

			}
			System.out.println();
			
			c.parar();

			if (fila.isVazia()) {
				System.out.println("\nA fila está vazia!\n");
			}
			System.out.println("Finalizou!");

		} catch (Exception erro) {
			System.out.println(erro.getMessage());

		}

	}

}
