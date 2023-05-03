public class TestaFila {

	public static void main(String[] args) throws Exception {
		Fila<Integer> fila = new Fila<Integer>(5);


		for (int i = 1; i <= 5; i++) {
			fila.guardeUmItem(i);

		}

		for (int i = 1; i <= 5; i++) {
			System.out.println(fila.recupereUmItem());
			fila.removaUmItem();

		}

		for (int i = 1; i <= 5; i++) {
			fila.guardeUmItem(i);

		}
		for (int i = 1; i <= 5; i++) {
			System.out.println(fila.recupereUmItem());
			fila.removaUmItem();

		}
		System.out.println(fila.isVazia());
		


		// int i = 0;
		// try {
		// 	Cronometro c = new Cronometro();
		// 	System.out.println("Começou!");
		// 	for (i = 0; i < 1000000; i++) {
		// 		fila.guardeUmItem(i);


		// 	}
		// 	if (i == 1000000) {
		// 		c.iniciar();
		// 	}
		// 	for (i = 1000000; i > 0; i--) {
		// 		fila.removaUmItem();


		// 	}
		// 	if (i == 0) {
		// 		c.parar();
		// 	}
		// 	System.out.println("Acabou!");

		// } catch (Exception erro) {
		// 	System.out.println(erro.getMessage());

		// }

	}

}
