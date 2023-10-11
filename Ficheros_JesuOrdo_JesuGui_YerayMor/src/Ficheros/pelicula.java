package Ficheros;

import java.util.ArrayList;
import java.util.List;

public class pelicula extends producto {

	public List<String> Secuelas = new ArrayList<>();
	public int Duracion = 0;

	
	
	public pelicula(List<String> secuelas, int duracion) {
		super();
		this.Secuelas = secuelas;
		this.Duracion = duracion;
	}

	public pelicula() {
		super();
	}

	public List<String> getSecuelas() {
		return Secuelas;
	}

	public void setSecuelas(List<String> secuelas) {
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





