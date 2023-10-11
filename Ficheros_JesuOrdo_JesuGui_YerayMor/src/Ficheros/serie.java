package Ficheros;

public class serie extends producto {

	public int Temporadas=0;

	public serie() {
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
		return "serie [Temporadas=" + Temporadas + ", Titulo=" + Titulo + ", Codigo=" + Codigo + ", Autor=" + Autor
				+ ", Nota=" + Nota + ", Genero=" + Genero + "]";
	}
}
