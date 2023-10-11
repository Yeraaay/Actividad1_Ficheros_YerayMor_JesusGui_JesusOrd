package Ficheros;

public class serie extends producto {

	public int temporadas=0;

	public serie() {
	    super();
	    this.temporadas = temporadas; 
	}
	
	
	public  int getTemporadas() {
		return temporadas;
	}

	public  void setTemporadas(int temporadas) {
		temporadas = temporadas;
	}
	

	@Override
	public String toString() {
		return "serie [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
