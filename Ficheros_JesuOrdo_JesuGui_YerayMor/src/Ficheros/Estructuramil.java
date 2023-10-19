package Ficheros;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Estructuramil {
	public static void main(String[] args) {

		Pelicula ironman = new Pelicula("IRON MAN", 1000, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);
		Pelicula deadpool = new Pelicula("deadpool", 1000, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120);


		// Utilizar JAXB para marshalling y convertir objetos en XML
		try {
			JAXBContext context = JAXBContext.newInstance(Pelicula.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Producto (ironman)
			marshaller.marshal(ironman, new File("Disney.xml"));

			// Marshalling de Pelicula (cars)
			marshaller.marshal(deadpool, new File("Disney.xml"));


		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void leerPelicula() {
		try {
			JAXBContext context = JAXBContext.newInstance(Pelicula.class);
			Marshaller marshaller = context.createMarshaller();
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Pelicula peliculaFromXml = (Pelicula) unmarshaller.unmarshal(new File("pelicula.xml")); 
			System.out.println(peliculaFromXml);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
