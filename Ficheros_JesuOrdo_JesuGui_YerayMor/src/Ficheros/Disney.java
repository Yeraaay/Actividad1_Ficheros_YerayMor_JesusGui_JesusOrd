package Ficheros;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Disney {
    
	private CategoriaPeliculas peliculas;
    private CategoriaSeries series;
    @XmlElement(name = "peliculas")
	public CategoriaPeliculas getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(CategoriaPeliculas peliculas) {
		this.peliculas = peliculas;
	}
	@XmlElement(name = "series")
	public CategoriaSeries getSeries() {
		return series;
	}
	public void setSeries(CategoriaSeries series) {
		this.series = series;
	}
	
	public Disney(CategoriaPeliculas categoriaPeliculas, CategoriaSeries categoriaSeries) {
		this.peliculas=categoriaPeliculas;
		this.series=categoriaSeries;
	}
	public Disney() {
		
	}
	
    
}