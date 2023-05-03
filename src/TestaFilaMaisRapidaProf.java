public class TestaFilaMaisRapidaProf {

	public static void main(String[] args) throws Exception {
		FilaMaisRapidaProf<Integer> fila = new FilaMaisRapidaProf<Integer>(6);

		fila.guardeUmItem(5);
		fila.guardeUmItem(10);
		fila.guardeUmItem(15);
		fila.guardeUmItem(20);
		fila.guardeUmItem(25);
		fila.guardeUmItem(30);


		// int i = 0;
		// try {
		// 	Cronometro c = new Cronometro();
			for (int i = 0; i < 6; i++) {
				System.out.println(fila.recupereUmItem());
				fila.removaUmItem();


			}
				
		// 	if (i == 1000000) {
		// 		c.iniciar();
		// 	}
		// 	for (i = 1000000; i > 0; i--) {
		// 		fila.removaUmItem();

		// 		System.out.println(fila);

		// 	}
		// 	if (i == 0) {
		// 		c.parar();
		// 	}


		// } catch (Exception erro) {
		// 	System.out.println(erro.getMessage());

		// }

	}

}
