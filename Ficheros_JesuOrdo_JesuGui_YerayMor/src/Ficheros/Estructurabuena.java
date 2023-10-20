package Ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Estructurabuena {

	public static void crearXML() {

		//Creamos las listas para agregar las peliculas
		List<Pelicula> peliculasMarvel = new ArrayList<>();
		List<Pelicula> peliculasPixar = new ArrayList<>();
		List<Pelicula> peliculasStarWars = new ArrayList<>();
		List<Pelicula> peliculasDisney = new ArrayList<>(); 


		//CREACION DE ESPECTADORES DE PELICULAS
		int[] espectadoresIronman = {1000, 1800, 1500, 1900, 1200, 1300, 1400, 900, 2200, 2000, 1700, 1600};
		int[] espectadoresdeadpool = {950, 1750, 1600, 1850, 1350, 1450, 1250, 850, 2350, 1950, 1675, 1625};
		int[] espectadorestoystory = {1100, 1950, 1700, 2000, 1400, 1600, 1350, 800, 2100, 1900, 1750, 1550};
		int[] espectadorescars = {1050, 1900, 1650, 1925, 1300, 1400, 1450, 875, 2250, 2050, 1725, 1575};
		int[] espectadoreselAscensoDeSkyWalker = {980, 1740, 1480, 1870, 1250, 1350, 1420, 920, 2380, 2030, 1760, 1590};
		int[] espectadoreshanSolo = {1025, 1825, 1575, 1905, 1285, 1385, 1465, 945, 2315, 2075, 1735, 1515};
		int[] espectadoresreyLeon = {1050, 1850, 1550, 1975, 1325, 1375, 1435, 925, 2435, 2095, 1785, 1560};
		int[] espectadoresfrozen = {975, 1785, 1525, 1935, 1275, 1340, 1405, 910, 2265, 2025, 1705, 1585};
		
		//CREACION DE PELICULAS
		//Peliculas Marvel
		Pelicula ironman = new Pelicula("IRON MAN", 1000, "kikewest", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 120, espectadoresIronman);
		Pelicula deadpool = new Pelicula("DEADPOOL", 1001, "Tim Miller", 5.1, Genero.comedia, Genero.acción, Genero.super_heroes, 110, espectadoresdeadpool);

		//Peliculas Pixar
		Pelicula toystory = new Pelicula("TOY STORY", 1002, "John Lasseter", 5.1, Genero.comedia, Genero.acción, Genero.animación, 120, espectadorestoystory);
		Pelicula cars = new Pelicula("CARS", 1003, "John Lasseter", 8.1, Genero.deportes, Genero.comedia, Genero.animación, 116, espectadorescars);

		//Peliculas Star Wars
		Pelicula elAscensoDeSkyWalker = new Pelicula("EL ASCENSO DE SKY-WALKER", 1004, "J. J. Abrams", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 146, espectadoreselAscensoDeSkyWalker);
		Pelicula hanSolo = new Pelicula("HAN SOLO", 1005, "Ron Howard", 8.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 135, espectadoreshanSolo);

		//Peliculas Disney Classic
		Pelicula reyLeon  = new Pelicula("EL REY LEON", 1006, "Rob Minkoff", 5.1, Genero.musical, Genero.acción, Genero.super_heroes, 127, espectadoresreyLeon);
		Pelicula frozen  = new Pelicula("FROZEN", 1007, "Chris Buck", 8.1, Genero.musical, Genero.familiar, Genero.animación, 120, espectadoresfrozen);


		//Añadimos las peliculas
		peliculasMarvel.add(ironman);
		peliculasMarvel.add(deadpool);

		peliculasPixar.add(toystory);
		peliculasPixar.add(cars);

		peliculasStarWars.add(elAscensoDeSkyWalker);
		peliculasStarWars.add(hanSolo);

		peliculasDisney.add(reyLeon);
		peliculasDisney.add(frozen);


		//Creamos instancias de las categorias para agregar las listas
		CategoriaPeliculas categoriaPeliculas = new CategoriaPeliculas(peliculasMarvel, peliculasPixar,  peliculasDisney, peliculasStarWars);

		//Creamos las listas para agregar las series
		List<Serie> seriesMarvel = new ArrayList<>();
		List<Serie> seriesPixar = new ArrayList<>();
		List<Serie> seriesStarWars = new ArrayList<>();
		List<Serie> seriesDisney = new ArrayList<>();
		
		
		//CREACION DE ESPECTADORES DE SERIES
		// CREACION DE ESPECTADORES DE SERIES
		int[] espectadoresloki = {1100, 1900, 1600, 2000, 1300, 1400, 1500, 1000, 2300, 2100, 1800, 1700};
		int[] espectadoresdaredevil = {1050, 1850, 1700, 1950, 1450, 1550, 1350, 950, 2450, 2050, 1775, 1725};
		int[] espectadoresmonstruosSA = {1200, 2050, 1800, 2100, 1500, 1700, 1450, 900, 2200, 2000, 1850, 1650};
		int[] espectadoresdugDays = {1150, 2000, 1750, 2025, 1400, 1500, 1550, 925, 2350, 2150, 1825, 1675};
		int[] espectadoresmandalorian = {1080, 1840, 1580, 1970, 1350, 1450, 1520, 980, 2420, 2070, 1790, 1620};
		int[] espectadoreskenobi = {1125, 1925, 1675, 2005, 1385, 1485, 1565, 945, 2355, 2115, 1775, 1555};
		int[] espectadoreschipychop = {1150, 1950, 1650, 2075, 1425, 1475, 1535, 925, 2535, 2195, 1885, 1660};
		int[] espectadoresdinosaruios = {1075, 1885, 1625, 2035, 1375, 1440, 1505, 910, 2365, 2125, 1805, 1685};


		//CREACION DE SERIES
		//Peliculas Marvel
		Serie loki  = new Serie("LOKI", 2000, "Kate Herron", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.super_heroes, 2, espectadoresloki);
		Serie daredevil  = new Serie("DAREDEVIL", 2001, "Mark Steven Johnson", 5.1, Genero.aventura, Genero.acción, Genero.super_heroes, 3, espectadoresdaredevil);

		//Peliculas Pixar
		Serie monstruosSA  = new Serie("MONSTRUOS A LA OBRA", 2002, "Pete Docter", 5.1, Genero.familiar, Genero.comedia, Genero.animación, 1, espectadoresmonstruosSA);
		Serie dugDays  = new Serie("DUG Y CARL", 2003, "Bob Peterson", 8.1, Genero.familiar, Genero.comedia, Genero.animación, 1, espectadoresdugDays);

		//Peliculas Star Wars
		Serie mandalorian = new Serie("MANDALORIAN", 2004, "Jon Favreau", 5.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 3, espectadoresmandalorian);
		Serie kenobi = new Serie("KENOBI", 2005, "Deborah Chow", 8.1, Genero.ciencia_ficción, Genero.acción, Genero.aventura, 1, espectadoreskenobi);

		//Peliculas Disney Classic
		Serie chipychop = new Serie("CHIP Y CHOP", 2006, "Josh Becker", 5.1, Genero.comedia, Genero.animación, Genero.infantil, 2, espectadoreschipychop);
		Serie dinosaruios = new Serie("DINOSAURIOS", 2007, "Guy Ritchie", 8.1, Genero.familiar, Genero.comedia, Genero.animación, 4, espectadoresdinosaruios);

		//Añadimos las series
		seriesMarvel.add(loki);
		seriesMarvel.add(daredevil);

		seriesPixar.add(monstruosSA);
		seriesPixar.add(dugDays);

		seriesStarWars.add(mandalorian);
		seriesStarWars.add(kenobi);

		seriesDisney.add(chipychop);
		seriesDisney.add(dinosaruios);

		//Creamos una instancia de las categorias para agregar las listas de series
		CategoriaSeries categoriaSeries = new CategoriaSeries(seriesMarvel, seriesPixar, seriesDisney, seriesStarWars);


		// Crear un objeto de la clase Disney y configurar las categorías en ese objeto.
		Disney disney = new Disney(categoriaPeliculas, categoriaSeries);

		// Utilizar JAXB para marshalling y convertir objetos en XML
		System.out.println("disney creado");
		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo realisado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		crearXML();
	}
}
