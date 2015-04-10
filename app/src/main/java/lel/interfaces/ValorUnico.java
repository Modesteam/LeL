package lel.interfaces;

import java.util.ArrayList;

import lel.dados.Time;

public interface ValorUnico {
	boolean unicoNome(ArrayList<Time> times,String nome);
	boolean unicaMatricula(ArrayList<Time> times,Integer matricula);
}
