package Ficheros;

public class Serie extends Producto {

	private int Temporadas=0;

	public Serie() {
	    super();
	    this.Temporadas =0; 
	}
	
	public  int getTemporadas() {
		return Temporadas;
	}

	public  void setTemporadas(int temporadas) {
		Temporadas = temporadas;
	}

	public String toString() {
		return super.toString()+"serie [Temporadas=" + Temporadas;
	}
}
