package lel.servicos;

import java.util.ArrayList;

import lel.dados.Time;
import lel.visao.Aviso;

public class Validacao {
	public static boolean validaConsulta(String matricula){
		if(validaIntIncoerencia(matricula)){
			if(validaIntMenor(matricula)){
				return true;
			}
			else{
				//Aviso.avisoErro("Matricula menor que zero.");
				return false;
			}
		}
		else{
			//Aviso.avisoErro("Matricula incoerente.");
			return false;
		}
	}
	public static boolean validaNomeVazio(String nome){
		if(nome.isEmpty()){
			return false;
		}
		return true;
	}
	
	public static boolean validaNomeUnico(ArrayList<Time> times, String nome){
		if(times.size()!=0){
			if(!times.get(0).unicoNome(times,nome)){
				return false;
			}
		}
		return true;
	}
	public static boolean validaIntIncoerencia(String numero){
		try{
			Integer.valueOf(numero);
		}catch(NumberFormatException ex){
			return false;
		}
		return true;
	}
	public static boolean validaIntMenor(String numero){
		if(Integer.valueOf(numero).intValue() <= 0)
			return false;
		return true;
	}
	public static boolean validaMatriculaUnica(ArrayList<Time> times, String matricula){
		if(times.size()!=0){
			if(!times.get(0).unicaMatricula(times,Integer.valueOf(matricula))){
				return false;
			}
		}
		return true;
	}
	
	public static String validaTime(String nome, String matricula, String quantidade, boolean estadioY,boolean estadioN,String renda, ArrayList<Time> times,boolean divisao){
		StringBuffer aviso = new StringBuffer("Cadastramento não efetuado, motivos: ");
		boolean validado = true;
		if(!validaNomeVazio(nome)){
			aviso.append("\n-Nome não pode ser vazio.");
			validado = false;
		}
		else{
			if(!validaNomeUnico(times,nome)){
				aviso.append("\n-O nome não é único.");
				validado=false;
			}
		}
		if(!validaIntIncoerencia(matricula)){
			aviso.append("\n-Matricula incoerente.");
			validado=false;
		}
		else{
			if(!validaIntMenor(matricula)){
				aviso.append("\n-O dado em matricula tem que ser maior que zero.");
				validado=false;
			}
			else{
				if(!validaMatriculaUnica(times, matricula)){
					aviso.append("\n-A matricula não é única.");
					validado=false;
				}
			}
		}

		if(!validaIntIncoerencia(quantidade)){
			aviso.append("\n-Quantidade incoerente.");
			validado=false;
		}
		else{
			if(!validaIntMenor(quantidade)){
				aviso.append("\n-O dado em quantidade tem que ser maior que zero.");
				validado=false;
			}
		}
		
		if(divisao == true){
			if(estadioY == false & estadioN == false){
				aviso.append("\n-O dado em estadio TEM que ser selecionado.");
				validado=false;
			}	
		}
		else{
			try{
				if(Float.valueOf(renda).floatValue() <= 0){
					aviso.append("\n-O dado em renda TEM que ser maior que zero.");
					validado=false;
				}
			}catch(NumberFormatException ex){
				aviso.append("\n-O dado em renda TEM que ser digitado.");
				validado=false;
			}
		}
        String resultadoValidacao;
		if(validado == false) {
            resultadoValidacao = aviso.toString();
        }else {
            resultadoValidacao = null;
        }
		return resultadoValidacao;
	}
}