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



		return (int) (Math.random() * 5);
	}

////////////////////////////////////////////////////////////////////


	public void mudaestado (int []visao){
		for (int i = 0; i < visao.length; i++) {
			if (sensor.getVisaoIdentificacao()[i]==100){
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