package Ficheros;


public class Pelicula extends Producto {

	private int Duracion = 0;

	
	
	public Pelicula(String nombre, int codigo, String autor, double nota, Genero cienciaFicción, Genero acción, Genero superHeroes, int duracion) {
		super();
		this.Duracion = duracion;
	}

	public Pelicula() {
		super();
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		this.Duracion = duracion;
	}

	@Override
	public String toString() {
		return super.toString()+"Duracion=" + Duracion;
	}

	
}
