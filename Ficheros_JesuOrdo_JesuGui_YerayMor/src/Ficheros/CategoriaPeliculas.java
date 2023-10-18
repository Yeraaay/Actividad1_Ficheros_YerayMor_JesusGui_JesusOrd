package Ficheros;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CategoriaPeliculas {
	@XmlElement(name = "peliculasMarvel")
    private List<Pelicula> peliculasMarvel;

    @XmlElement(name = "peliculasPixar")
    private List<Pelicula> peliculasPixar;

	public List<Pelicula> getPeliculasMarvel() {
		return peliculasMarvel;
	}

	public void setPeliculasMarvel(List<Pelicula> peliculasMarvel) {
		this.peliculasMarvel = peliculasMarvel;
	}

	public List<Pelicula> getPeliculasPixar() {
		return peliculasPixar;
	}

	public void setPeliculasPixar(List<Pelicula> peliculasPixar) {
		this.peliculasPixar = peliculasPixar;
	}

	public CategoriaPeliculas(List<Pelicula> peliculasMarvel, List<Pelicula> peliculasPixar) {
		super();
		this.peliculasMarvel = peliculasMarvel;
		this.peliculasPixar = peliculasPixar;
	}
    
}
