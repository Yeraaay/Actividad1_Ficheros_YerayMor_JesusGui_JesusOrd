package Ficheros;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Disney {
    private CategoriaPeliculas peliculas;
    private CategoriaSeries series;
}