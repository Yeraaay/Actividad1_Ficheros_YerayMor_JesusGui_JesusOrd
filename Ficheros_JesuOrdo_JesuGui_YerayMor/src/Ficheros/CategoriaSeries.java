package Ficheros;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CategoriaSeries {
	@XmlElement(name = "seriesMarvel")
    private List<Serie> seriesMarvel;

    @XmlElement(name = "seriesPixar")
    private List<Serie> seriesPixar;

	public List<Serie> getSeriesMarvel() {
		return seriesMarvel;
	}

	public void setSeriesMarvel(List<Serie> seriesMarvel) {
		this.seriesMarvel = seriesMarvel;
	}

	public List<Serie> getSeriesPixar() {
		return seriesPixar;
	}

	public void setSeriesPixar(List<Serie> seriesPixar) {
		this.seriesPixar = seriesPixar;
	}

	public CategoriaSeries(List<Serie> seriesMarvel, List<Serie> seriesPixar) {
		super();
		this.seriesMarvel = seriesMarvel;
		this.seriesPixar = seriesPixar;
	}
    
    
}