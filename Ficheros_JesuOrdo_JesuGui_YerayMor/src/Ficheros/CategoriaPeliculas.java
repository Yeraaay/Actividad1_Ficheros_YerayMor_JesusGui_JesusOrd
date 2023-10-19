package Ficheros;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class CategoriaPeliculas {
	@XmlElement(name = "peliculasMarvel")
    public static ArrayList<Pelicula> peliculasMarvel = null;

    @XmlElement(name = "peliculasPixar")
    static public ArrayList<Pelicula> peliculasPixar = null;

	public ArrayList<Pelicula> getPeliculasMarvel() {
		return peliculasMarvel;
	}

	public void setPeliculasMarvel(ArrayList<Pelicula> peliculasMarvel) {
		this.peliculasMarvel = peliculasMarvel;
	}

	public ArrayList<Pelicula> getPeliculasPixar() {
		return peliculasPixar;
	}

	public void setPeliculasPixar(ArrayList<Pelicula> peliculasPixar) {
		this.peliculasPixar = peliculasPixar;
	}

	public CategoriaPeliculas(ArrayList<Pelicula> peliculasMarvel, ArrayList<Pelicula> peliculasPixar) {
		super();
		this.peliculasMarvel = peliculasMarvel;
		this.peliculasPixar = peliculasPixar;
	}
    
}