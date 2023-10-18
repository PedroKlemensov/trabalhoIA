package agente;

import algoritmo.ProgramaLadrao;

public class Ladrao extends ProgramaLadrao {

	

	public int acao() {

		System.out.println("inicio");
		for (int i = 0; i < sensor.getVisaoIdentificacao().length; i++) {
			System.out.print(sensor.getVisaoIdentificacao()[i]);

			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("fim");
		System.out.println(sensor.getPosicao());

		return (int) (Math.random() * 5);
	}

}