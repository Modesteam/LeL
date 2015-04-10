package lel.dados;

import java.util.ArrayList;

import lel.interfaces.ValorUnico;

public abstract class Time implements Comparable<Time>{
	protected StringBuffer nome;
	protected Integer quantidade;
	protected Integer matricula;
	public	Time(StringBuffer nome, Integer quantidade, Integer matricula){
		setNome(nome);
		setQuantidade(quantidade);
		setMatricula(matricula);
	}
	public void setNome(StringBuffer nome){
		this.nome = nome;
	}
	public void setQuantidade(Integer quantidade){
		this.quantidade = quantidade;
	}
	public void setMatricula(Integer matricula){
		this.matricula = matricula;
	}
	public Integer getQuantidade(){
		return quantidade;
	}
	public Integer getMatricula(){
		return matricula;
	}
	public StringBuffer getNome(){
		return this.nome;
	}
	public boolean unicoNome(ArrayList<Time> times, String nome) {
		for(int aux=0; aux< times.size(); aux++){
			if(times.get(aux).getNome().toString().toLowerCase().equals(nome.toLowerCase())){
				return false;
			}
		}
		return true;
	}
	public boolean unicaMatricula(ArrayList<Time> times,Integer matricula) {
		for(int aux=0; aux< times.size(); aux++){
			if(times.get(aux).getMatricula().toString().equals(matricula.toString())){
				return false;
			}
		}
		return true;
	}
	public String toStringAviso() {
		return null;
	}
	public String getRendaString(){
		return "--------";
	}
	public String getEstadioString(){
		return "--------";
	}
	public int compareTo(Time time) {
		return nome.toString().compareTo(time.getNome().toString());
	}
}
