package lel.dados;

public class Primeira extends Time {
	private boolean estadio;
	public Primeira(StringBuffer nome, Integer quantidade, Integer matricula,boolean estadio){
		super(nome,quantidade,matricula);
		this.estadio = estadio;
	}
	public boolean getEstadio(){
		return estadio;
	}
	public String toString(){
		return (nome+"\t\t\t"+matricula+"\t\t"+quantidade+"\t\t"+ (estadio == true?"TEM":"N�O TEM")+"\t\t------" );
	}
	public String toStringAviso(){
		return ("Nome: "+nome+"\nMatr�cula: "+matricula+"\nQuantidade de torcedores: "+quantidade+"\nEstadio pr�prio: "+(estadio == true?"TEM":"N�O TEM"));
	}
	public String getEstadioString(){
		return (estadio == true ? "TEM" : "N�O TEM");
	}
}
