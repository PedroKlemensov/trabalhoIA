package agente;

import algoritmo.ProgramaLadrao;

public class Ladrao extends ProgramaLadrao {

	// valores
	int semVisaoPeso = -5;
	int foraPeso =-4;
	int peredePeso =-3;
	int nadaPeso= 0;
	int moedaPeso = 1;
	int bancoPeso = 2;
	int pastilhaPeso= 2;
	int popadorPeso = 40;
	int ladaoPeso =2;





	public int [] getvisaotopo (int [] visao){
		int[] visto = new int[]{visao[7], visao[1], visao[2], visao[3], visao[4], visao[5], visao[6], visao[0], visao[8], visao[9]};
		return visto;
	}

	public int [] getvisaobaixo (int [] visao){
		int[] visto = new int[]{visao[16], visao[15], visao[14], visao[17], visao[18], visao[19], visao[20], visao[21], visao[22], visao[23]};
		return visto;
	}

	public int [] getvisaoesquerda (int [] visao){
		int[] visto = new int[]{visao[11], visao[1], visao[5], visao[6], visao[10], visao[0], visao[14], visao[15], visao[19], visao[20]};
		return visto;
	}

	public int [] getvisaodireita (int [] visao){
		int[] visto = new int[]{visao[12], visao[4], visao[8], visao[9], visao[3], visao[13], visao[17], visao[18], visao[22], visao[23]};
		return visto;
	}

	public int somagem (int [] visto){
		int [] pesado = new int[visto.length];
		int peso = 0;

		for (int i=0;i<visto.length;i++){
			if (visto[i]== -2){
				pesado [i]= semVisaoPeso;
			}
			if (visto[i]== -2){
				pesado [i]=foraPeso;
			}
			if (visto[i]== 0){
				pesado [i]=nadaPeso;
			}
			if (visto[i]== 1){
				pesado [i]=peredePeso;
			}
			if (visto[i]== 3){
				pesado [i]=bancoPeso;
			}
			if (visto[i]== 4){
				pesado [i]=moedaPeso;
			}
			if (visto[i]== 5){
				pesado [i]=pastilhaPeso;
			}
			if (visto[i] >= 100 && visto[i] < 200){
				pesado [i]=popadorPeso;
			}
			if (visto[i]>= 200){
				pesado [i]=ladaoPeso;
			}



		}

		for (int i=0;i<pesado.length;i++){

			peso = peso + pesado[i];
		}

		return peso;
	}



	public int acao() {

		int [] visao = sensor.getVisaoIdentificacao();

		int [] pesos = new int[5];


		pesos[0]= -500;
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

		return maiorPosicao;
	}

}