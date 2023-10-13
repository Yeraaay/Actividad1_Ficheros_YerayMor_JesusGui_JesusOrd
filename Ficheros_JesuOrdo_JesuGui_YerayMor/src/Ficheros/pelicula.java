package Ficheros;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends Producto {

	private ArrayList<String> Secuelas = new ArrayList<>();
	private int Duracion = 0;

	
	
	public Pelicula(String string, int i, String string2, double d, Genero cienciaFicción, Genero acción, Genero superHeroes, ArrayList<String> secuelas, int duracion) {
		super();
		this.Secuelas = secuelas;
		this.Duracion = duracion;
	}

	public Pelicula() {
		super();
	}

	public List<String> getSecuelas() {
		return Secuelas;
	}

	public void setSecuelas(ArrayList<String> secuelas) {
		this.Secuelas = secuelas;
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		this.Duracion = duracion;
	}

	public String toString() {
		return "pelicula [secuelas=" + Secuelas + ", duracion=" + Duracion +
				", getSecuelas()=" + getSecuelas() + ", getDuracion()=" + getDuracion() +
				", getClass()=" + getClass() + ", hashCode()=" + hashCode() +
				", toString()=" + super.toString() + "]";
	}
}
