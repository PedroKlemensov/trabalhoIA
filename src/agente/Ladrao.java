package agente;

import algoritmo.ProgramaLadrao;

import java.util.Random;

public class Ladrao extends ProgramaLadrao {

	// valores
	int semVisaoPeso = 1;
	int foraPeso =1;
	int peredePeso =1;
	int nadaPeso= 20;
	int moedaPeso = 5;
	int bancoPeso = 6;
	int pastilhaPeso= 5;
	int popadorPeso = 600;
	int ladaoPeso =20;





	public int [] getvisaotopo (int [] visao){
        return new int[]{visao[7], visao[1], visao[2], visao[3], visao[4], visao[5], visao[6], visao[0], visao[8], visao[9]};
	}

	public int [] getvisaobaixo (int [] visao){
        return new int[]{visao[16], visao[15], visao[14], visao[17], visao[18], visao[19], visao[20], visao[21], visao[22], visao[23]};
	}

	public int [] getvisaoesquerda (int [] visao){
        return new int[]{visao[11], visao[1], visao[5], visao[6], visao[10], visao[0], visao[14], visao[15], visao[19], visao[20]};
	}

	public int [] getvisaodireita (int [] visao){
        return new int[]{visao[12], visao[4], visao[8], visao[9], visao[3], visao[13], visao[17], visao[18], visao[22], visao[23]};
	}

	public int somagem (int [] visto){
		int peso = 0;

		if (visto[0]== 0){
			for (int i = 0; i < visto.length; i++) {
				if (visto[i] == -2) {
					peso = peso + semVisaoPeso;
				}
				if (visto[i] == -2) {
					peso = peso + foraPeso;
				}
				if (visto[i] == 0) {
					peso = peso + nadaPeso;
				}
				if (visto[i] == 1) {
					peso = peso + peredePeso;
				}
				if (visto[i] == 3) {
					peso = peso + bancoPeso;
				}
				if (visto[i] == 4) {
					peso = peso + moedaPeso;
				}
				if (visto[i] == 5) {
					peso = peso + pastilhaPeso;
				}
				if (visto[i] >= 100 && visto[i] < 200) {
					peso = peso + popadorPeso;
				}
				if (visto[i] >= 200) {
					peso = peso + ladaoPeso;
				}
			}


		}



		return peso;
	}



	public static int selectRandomIndex(int[] weights) {
		Random random = new Random();
		int totalWeight = 0;

		// Calcula o peso total
		for (int weight : weights) {
			totalWeight += weight;
		}

		// Gera um número aleatório entre 0 e o peso total
		if(totalWeight != 0){
			int randomValue = random.nextInt(totalWeight);

			// Percorre o vetor e escolhe a posição com base no peso
			for (int i = 0; i < weights.length; i++) {
				randomValue -= weights[i];
				if (randomValue <= 0) {
					return i;
				}

			}
		}else {
			return (int) (Math.random() * 5);
		}

		// Em caso de erro, retorne -1 ou outro valor adequado
		return (int) (Math.random() * 5);
	}


	public int acao() {

		int [] visao = sensor.getVisaoIdentificacao();

		int [] pesos = new int[5];


		pesos[0]= 0;
		pesos[1]= somagem(getvisaotopo(visao));
		pesos[2]= somagem(getvisaobaixo(visao));
		pesos[3]= somagem(getvisaodireita(visao));
		pesos[4]= somagem(getvisaoesquerda(visao));


		int maiorValor = pesos[0];
		int maiorPosicao = 0;

		for (int i = 1; i < pesos.length; i++) {
			if (pesos[i] > maiorValor) {
				maiorValor = pesos[i];
				maiorPosicao = i;
			}
		}
		System.out.println(pesos[1]+" "+pesos[2]+" "+pesos[3]+" "+pesos[4]+ "maior :"+ maiorPosicao);

		return selectRandomIndex(pesos);
	}

}