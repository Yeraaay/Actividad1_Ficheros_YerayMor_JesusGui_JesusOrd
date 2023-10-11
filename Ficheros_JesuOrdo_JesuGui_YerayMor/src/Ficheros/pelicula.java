

package Ficheros;

import java.util.ArrayList;
import java.util.List;

public class pelicula extends producto {

	public List<String> secuelas = new ArrayList<>();
	public int duracion = 0;

	
	
	public pelicula(List<String> secuelas, int duracion) {
		super();
		this.secuelas = secuelas;
		this.duracion = duracion;
	}

	public pelicula() {
		super();
	}

	public List<String> getSecuelas() {
		return secuelas;
	}

	public void setSecuelas(List<String> secuelas) {
		this.secuelas = secuelas;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "pelicula [secuelas=" + secuelas + ", duracion=" + duracion +
				", getSecuelas()=" + getSecuelas() + ", getDuracion()=" + getDuracion() +
				", getClass()=" + getClass() + ", hashCode()=" + hashCode() +
				", toString()=" + super.toString() + "]";
	}
}





