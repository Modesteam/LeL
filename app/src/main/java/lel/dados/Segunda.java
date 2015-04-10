package lel.dados;

public class Segunda extends Time {
	private Float renda;
	public Segunda(StringBuffer nome, Integer quantidade, Integer matricula,Float renda){
		super(nome,quantidade,matricula);
		this.renda = renda;
	}
	public String toString(){
		return (nome+"\t\t\t"+matricula+"\t\t"+quantidade+"\t\t-------\t\t"+ renda);
	}
	public String toStringAviso(){
		return ("Nome: "+nome+"\nMatr�cula: "+matricula+"\nQuantidade de torcedores: "+quantidade+"\nRenda: "+renda);
	}
	public String getRendaString(){
		return renda.toString();
	}
}
