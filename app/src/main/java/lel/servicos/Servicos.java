package lel.servicos;

import java.util.ArrayList;
import java.util.Collections;

import lel.visao.Aviso;
import lel.dados.Time;

public class Servicos {
	public static void listarTime(ArrayList<Time> times){
		if(times.size() !=0){
			System.out.println("Nome\t\t\tMatricula\tQuantidade\tEstadio\t\tRenda");
			System.out.println("##############################################################################");
			for(int aux=0; aux< times.size();aux++){
				 System.out.println(times.get(aux));
			}
		}
		else
			System.out.println("Não há registros.");
	}
	public static void achaTime(ArrayList<Time> times, String matriculaS){
		Integer matriculaI;
		boolean entrou = false;
		if(Validacao.validaConsulta(matriculaS)){
			matriculaI = Integer.parseInt(matriculaS);
			if(times.size() != 0){
				for(Time time: times){
					if(time.getMatricula() == matriculaI){
						//Aviso.avisoSemIcone(time.toStringAviso());
						entrou = true;
					}
				}
				if(entrou == false) {
                    //Aviso.avisoErro("Não há matricula registrada com a matricula da consulta");
                }
			}
			else {
                //Aviso.avisoErro("Não há registros");
            }
		}
	}
	public static ArrayList<Time> achaTimes(ArrayList<Time> timesP, String nome){
		ArrayList<Time> timesR = new ArrayList<Time>();
		for(Time time: timesP){
			if(time.getNome().toString().toLowerCase().trim().contains(nome.toLowerCase().trim())){
				timesR.add(time);
			}
		}
		Collections.sort(timesR);
		return timesR;
	}
	
}