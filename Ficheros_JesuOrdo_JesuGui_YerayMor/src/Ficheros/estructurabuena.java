package Ficheros;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Estructurabuena {

    public static void main(String[] args) {
        ArrayList<String> secuelasironman=new ArrayList<String>();
        secuelasironman.add("ironman 2");
        secuelasironman.add("ironman 3");
        Pelicula ironman = new Pelicula("IRON MAN", 1000, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, secuelasironman, 120);
       
        ArrayList<String> secuelascars=new ArrayList<String>();
        secuelascars.add("CARS 2");
        secuelascars.add("CARS 3");
        Pelicula cars = new Pelicula("CARS", 1001, "John Lasseter", 5.0, Genero.deportes, Genero.acción, Genero.animación, secuelascars, 115);
        

        // Utilizar JAXB para marshalling y convertir objetos en XML
        try {
            JAXBContext context = JAXBContext.newInstance(Producto.class, Pelicula.class);
            Marshaller marshaller = context.createMarshaller();

            // Marshalling de Producto (ironman)
            marshaller.marshal(ironman, new File("producto.xml"));

            // Marshalling de Pelicula (cars)
            marshaller.marshal(cars, new File("pelicula.xml"));

            // Unmarshalling desde XML a objeto
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Producto productoFromXml = (Producto) unmarshaller.unmarshal(new File("producto.xml"));
            Pelicula peliculaFromXml = (Pelicula) unmarshaller.unmarshal(new File("pelicula.xml"));

            // Puedes imprimir los objetos deserializados para verificar
            System.out.println(productoFromXml);
            System.out.println(peliculaFromXml);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
