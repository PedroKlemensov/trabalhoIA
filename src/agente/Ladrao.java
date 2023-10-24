package agente;

import algoritmo.ProgramaLadrao;

public class Ladrao extends ProgramaLadrao {

	boolean bucarSeguir = true;

////////////////////////////////////////////////////////
//açoes no modo de busca
	public int buscaa (){

		return (int) (Math.random() * 5);
	}


///////////////////////////////////////////////////////////////////////////


	public int seguindo (int []visao, int [] oufato){
		int index= posicaoP(visao);
		int cima = 7-index;
		int esquerda = 11-index;
		int direita = 12-index;
		int baixo = 16-index;

		//ta travando na esquerda

		if(cima > esquerda && cima > direita && cima> baixo){
			return 1;
		} else if (esquerda > cima && esquerda > direita && esquerda> baixo) {
			return 2;
		} else if (baixo > esquerda && baixo > cima && baixo> cima) {
			return 3;
		} else if (direita > esquerda && direita > cima && direita> baixo) {
			return 4;
		}




		return (int) (Math.random() * 5);
	}

	public int posicaoP (int []visao){
		int valor = -1;
		for (int i = 0; i<visao.length;i++){
			if (visao[i] >= 100 && visao[i] < 200){
				valor = i;
				break;
			}
		}

        return valor;
    }

////////////////////////////////////////////////////////////////////


	public void mudaestado (int []visao){
		for (int i = 0; i < visao.length; i++) {
			if (visao[i] >= 100 && visao[i] < 200){
				bucarSeguir = false;
				System.out.println("Estado mudado");
				break;
			}
		}
	}


	public int acao() {


		if (bucarSeguir){
			mudaestado(sensor.getVisaoIdentificacao());
		}





		if (bucarSeguir){
			return buscaa();
		}else {
			return seguindo(sensor.getVisaoIdentificacao(),sensor.getAmbienteOlfatoLadrao());
		}
	}

}