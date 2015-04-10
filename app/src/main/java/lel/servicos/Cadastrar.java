package lel.servicos;

import lel.dados.Primeira;
import lel.dados.Segunda;
import java.lang.StringBuffer;
public class Cadastrar {
	public static Primeira cadastrarPrimeira(String nome, String matricula, String quantidade, boolean estadioY,boolean estadioN){
		StringBuffer nomeAux = new StringBuffer();
		nomeAux.append(nome);
		if(estadioY)
			return new Primeira(nomeAux, Integer.valueOf(quantidade), Integer.valueOf(matricula),true);
		else
			return new Primeira(nomeAux, Integer.valueOf(quantidade), Integer.valueOf(matricula),false);
		
	}
	public static Segunda cadastrarSegunda(String nome, String matricula, String quantidade, String renda){
		StringBuffer nomeAux = new StringBuffer();
		nomeAux.append(nome);
		return new Segunda(nomeAux, Integer.valueOf(quantidade), Integer.valueOf(matricula),Float.valueOf(renda));
	}
}