package Ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Metodos {
	
	
	public static Disney crearXML() {

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
		Serie dinosaurios = new Serie("DINOSAURIOS", 2007, "Guy Ritchie", 8.1, Genero.familiar, Genero.comedia, Genero.animación, 4, espectadoresdinosaruios);

		//Añadimos las series
		seriesMarvel.add(loki);
		seriesMarvel.add(daredevil);

		seriesPixar.add(monstruosSA);
		seriesPixar.add(dugDays);

		seriesStarWars.add(mandalorian);
		seriesStarWars.add(kenobi);

		seriesDisney.add(chipychop);
		seriesDisney.add(dinosaurios);

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
		return disney;
	}


	public static String leerXML(String rutaArchivo) {
	    StringBuilder xmlContent = new StringBuilder();

	    try {
	        File archivoXML = new File(rutaArchivo);

	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document document = builder.parse(archivoXML);

	        boolean firstElementEncountered = false;

	        // Mostrar el contenido de las etiquetas después de la primera
	        NodeList nodeList = document.getElementsByTagName("*");
	        for (int i = 0; i < nodeList.getLength(); i++) {
	            Node node = nodeList.item(i);
	            if (node.getNodeType() == Node.ELEMENT_NODE) {
	                if (firstElementEncountered) {
	                    Element element = (Element) node;
	                    String tagName = element.getTagName();
	                    String textContent = element.getTextContent();
	                    xmlContent.append(tagName).append(": ").append(textContent).append("\n");
	                } else {
	                    firstElementEncountered = true;
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return xmlContent.toString();
	}


	public static void modificarTituloPorCodigo(Disney disney, int codigo, String nuevoTitulo) {
		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		CategoriaSeries categoriaSeries = disney.getSeries();

		// Busca en la lista de películas de Marvel
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
			if (pelicula.getCodigo() == codigo) {
				pelicula.setTitulo(nuevoTitulo);
				return;
			}
		}

		// Busca en la lista de películas de Pixar
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
			if (pelicula.getCodigo() == codigo) {
				pelicula.setTitulo(nuevoTitulo);
				return;
			}
		}

		// Busca en la lista de películas de Star Wars
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
			if (pelicula.getCodigo() == codigo) {
				pelicula.setTitulo(nuevoTitulo);
				return;
			}
		}

		// Busca en la lista de películas de Disney Classic
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
			if (pelicula.getCodigo() == codigo) {
				pelicula.setTitulo(nuevoTitulo);
				return;
			}
		}

		// Si no se encontró en las películas, busca en las series
		for (Serie serie : categoriaSeries.getSeriesMarvel()) {
			if (serie.getCodigo() == codigo) {
				serie.setTitulo(nuevoTitulo);
				return;
			}
		}

		for (Serie serie : categoriaSeries.getSeriesPixar()) {
			if (serie.getCodigo() == codigo) {
				serie.setTitulo(nuevoTitulo);
				return;
			}
		}

		for (Serie serie : categoriaSeries.getSeriesStarWars()) {
			if (serie.getCodigo() == codigo) {
				serie.setTitulo(nuevoTitulo);
				return;
			}
		}

		for (Serie serie : categoriaSeries.getSeriesDisney()) {
			if (serie.getCodigo() == codigo) {
				serie.setTitulo(nuevoTitulo);
				return;
			}
		}
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
	public static int espectadoresAnuales(Disney disney, int codigo) {
		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		CategoriaSeries categoriaSeries = disney.getSeries();

		// Busca en las listas de películas
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
			if (pelicula.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(pelicula.getEspectadores());
			}
		}

		// Busca en las listas de series
		for (Serie serie : categoriaSeries.getSeriesMarvel()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		for (Serie serie : categoriaSeries.getSeriesPixar()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		for (Serie serie : categoriaSeries.getSeriesStarWars()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		for (Serie serie : categoriaSeries.getSeriesDisney()) {
			if (serie.getCodigo() == codigo) {
				return sumarEspectadoresAnuales(serie.getEspectadores());
			}
		}

		// Si no se encontró, devolver -1 o un valor que indique que el código no existe
		return -1;
	}

	// Método auxiliar para sumar los valores de un array
	private static int sumarEspectadoresAnuales(int[] espectadores) {
		int suma = 0;
		for (int espectadoresmes : espectadores) {
			suma += espectadoresmes;
		}
		return suma;
	}

	public static void agregarPelicula(Disney disney) {
		Scanner input = new Scanner(System.in);

		System.out.print("Introduce el título de la película: ");
		String titulo = input.nextLine();

		System.out.print("Introduce el código de la película: ");
		int codigo = input.nextInt();

		input.nextLine(); // Limpia el buffer

		System.out.print("Introduce el nombre del director: ");
		String director = input.nextLine();

		System.out.print("Introduce el rating de la película: ");
		double rating = input.nextDouble();

		System.out.print("Introduce el género 1: (drama,acción,terror,comedia,suspense,bélica,aventura,documental,deportes,ciencia_ficción,animación,super_heroes, musical, familiar, infantil)");
		Genero genero1 = Genero.valueOf(input.next());

		System.out.print("Introduce el género 2: (drama,acción,terror,comedia,suspense,bélica,aventura,documental,deportes,ciencia_ficción,animación,super_heroes, musical, familiar, infantil)");
		Genero genero2 = Genero.valueOf(input.next());

		System.out.print("Introduce el género 3: (drama,acción,terror,comedia,suspense,bélica,aventura,documental,deportes,ciencia_ficción,animación,super_heroes, musical, familiar, infantil)");
		Genero genero3 = Genero.valueOf(input.next());

		System.out.print("Introduce la duración de la película: ");
		int duracion = input.nextInt();

		int[] espectadoresAnuales = new int[12];
		for (int i = 0; i < 12; i++) {
			espectadoresAnuales[i] = 0;
		}

		input.nextLine(); // Limpia el buffer

		System.out.print("Introduce la categoría (marvel, pixar, starwars o disney): ");
		String categoria = input.nextLine().toLowerCase();

		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		List<Pelicula> listaCategoria = null;

		switch (categoria) {
		case "marvel":
			listaCategoria = categoriaPeliculas.getPeliculasMarvel();
			break;
		case "pixar":
			listaCategoria = categoriaPeliculas.getPeliculasPixar();
			break;
		case "starwars":
			listaCategoria = categoriaPeliculas.getPeliculasStarWars();
			break;
		case "disney":
			listaCategoria = categoriaPeliculas.getPeliculasDisney();
			break;
		default:
			System.out.println("Categoría no válida");
			return;
		}

		Pelicula nuevaPelicula = new Pelicula(titulo, codigo, director, rating, genero1, genero2, genero3, duracion, espectadoresAnuales);
		listaCategoria.add(nuevaPelicula);

		System.out.println("Pelicula agregada a la lista de " + categoria);
		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo actualizado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static void agregarSerie(Disney disney) {
		Scanner input = new Scanner(System.in);

		System.out.print("Introduce el título de la serie: ");
		String titulo = input.nextLine();

		System.out.print("Introduce el código de la serie: ");
		int codigo = input.nextInt();

		input.nextLine(); // Limpia el buffer

		System.out.print("Introduce el nombre del director: ");
		String director = input.nextLine();

		System.out.print("Introduce el rating de la serie: ");
		double rating = input.nextDouble();

		System.out.print("Introduce el género 1: (drama,acción,terror,comedia,suspense,bélica,aventura,documental,deportes,ciencia_ficción,animación,super_heroes, musical, familiar, infantil) ");
		Genero genero1 = Genero.valueOf(input.next());

		System.out.print("Introduce el género 2: (drama,acción,terror,comedia,suspense,bélica,aventura,documental,deportes,ciencia_ficción,animación,super_heroes, musical, familiar, infantil)");
		Genero genero2 = Genero.valueOf(input.next());

		System.out.print("Introduce el género 3: (drama,acción,terror,comedia,suspense,bélica,aventura,documental,deportes,ciencia_ficción,animación,super_heroes, musical, familiar, infantil)");
		Genero genero3 = Genero.valueOf(input.next());

		System.out.print("Introduce el numero de temporadas: ");
		int temporadas = input.nextInt();

		int[] espectadoresAnuales = new int[12];
		for (int i = 0; i < 12; i++) {
			espectadoresAnuales[i] = 0;
		}

		input.nextLine(); // Limpia el buffer

		System.out.print("Introduce la categoría (marvel, pixar, star wars o disney): ");
		String categoria = input.nextLine().toLowerCase();

		CategoriaSeries categoriaSeries = disney.getSeries();
		List<Serie> listaCategoria = null;

		switch (categoria) {
		case "marvel":
			listaCategoria = categoriaSeries.getSeriesMarvel();
			break;
		case "pixar":
			listaCategoria = categoriaSeries.getSeriesPixar();
			break;
		case "star wars":
			listaCategoria = categoriaSeries.getSeriesStarWars();
			break;
		case "disney":
			listaCategoria = categoriaSeries.getSeriesDisney();
			break;
		default:
			System.out.println("Categoría no válida");
			return;
		}

		Serie nuevaSerie = new Serie(titulo, codigo, director, rating, genero1, genero2, genero3, temporadas, espectadoresAnuales);
		listaCategoria.add(nuevaSerie);

		System.out.println("Serie agregada a la lista de " + categoria);
		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo actualizado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static void eliminarPorCodigo(Disney disney, int codigo) {
		boolean peliculaEliminada = false;
		boolean serieEliminada = false;

		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		CategoriaSeries categoriaSeries = disney.getSeries();

		// Buscar en las listas de películas
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
			if (pelicula.getCodigo() == codigo) {
				categoriaPeliculas.getPeliculasMarvel().remove(pelicula);
				peliculaEliminada = true;
				break;
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
			if (pelicula.getCodigo() == codigo) {
				categoriaPeliculas.getPeliculasPixar().remove(pelicula);
				peliculaEliminada = true;
				break;
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
			if (pelicula.getCodigo() == codigo) {
				categoriaPeliculas.getPeliculasStarWars().remove(pelicula);
				peliculaEliminada = true;
				break;
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
			if (pelicula.getCodigo() == codigo) {
				categoriaPeliculas.getPeliculasDisney().remove(pelicula);
				peliculaEliminada = true;
				break;
			}
		}

		// Buscar en las listas de series
		for (Serie serie : categoriaSeries.getSeriesMarvel()) {
			if (serie.getCodigo() == codigo) {
				categoriaSeries.getSeriesMarvel().remove(serie);
				serieEliminada = true;
				break;
			}
		}
		for (Serie serie : categoriaSeries.getSeriesPixar()) {
			if (serie.getCodigo() == codigo) {
				categoriaSeries.getSeriesPixar().remove(serie);
				serieEliminada = true;
				break;
			}
		}
		for (Serie serie : categoriaSeries.getSeriesStarWars()) {
			if (serie.getCodigo() == codigo) {
				categoriaSeries.getSeriesStarWars().remove(serie);
				serieEliminada = true;
				break;
			}
		}
		for (Serie serie : categoriaSeries.getSeriesDisney()) {
			if (serie.getCodigo() == codigo) {
				categoriaSeries.getSeriesDisney().remove(serie);
				serieEliminada = true;
				break;
			}
		}

		if (peliculaEliminada) {
			System.out.println("Película con código " + codigo + " eliminada.");
		} else if (serieEliminada) {
			System.out.println("Serie con código " + codigo + " eliminada.");
		} else {
			System.out.println("No se encontró ninguna película o serie con el código " + codigo);
		}
		try {
			JAXBContext context = JAXBContext.newInstance(Disney.class);
			Marshaller marshaller = context.createMarshaller();

			// Marshalling de Disney
			marshaller.marshal(disney, new File("Disney.xml"));


			System.out.println("achivo actualizado");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public static String obtenerInfoPorTitulo(Disney disney, String titulo) {
		StringBuilder info = new StringBuilder();

		CategoriaPeliculas categoriaPeliculas = disney.getPeliculas();
		CategoriaSeries categoriaSeries = disney.getSeries();

		// Buscar en las listas de películas
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasMarvel()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Marvel").append("\n");
				return info.toString();
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasPixar()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Pixar").append("\n");
				return info.toString();
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasStarWars()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Star Wars").append("\n");
				return info.toString();
			}
		}
		for (Pelicula pelicula : categoriaPeliculas.getPeliculasDisney()) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(pelicula.getTitulo()).append("\n");
				info.append("Código: ").append(pelicula.getCodigo()).append("\n");
				info.append("Director: ").append(pelicula.getAutor()).append("\n");
				info.append("Rating: ").append(pelicula.getNota()).append("\n");
				info.append("Géneros: ").append(pelicula.getGenero1()).append(", ").append(pelicula.getGenero2()).append(", ").append(pelicula.getGenero3()).append("\n");
				info.append("Duración: ").append(pelicula.getDuracion()).append(" minutos").append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(pelicula.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Disney").append("\n");
				return info.toString();
			}
		}

		// Buscar en las listas de series
		for (Serie serie : categoriaSeries.getSeriesMarvel()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Marvel").append("\n");
				return info.toString();
			}
		}
		for (Serie serie : categoriaSeries.getSeriesPixar()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Pixar").append("\n");
				return info.toString();
			}
		}
		for (Serie serie : categoriaSeries.getSeriesStarWars()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Star Wars").append("\n");

				return info.toString();
			}
		}
		for (Serie serie : categoriaSeries.getSeriesDisney()) {
			if (serie.getTitulo().equalsIgnoreCase(titulo)) {
				info.append("Título: ").append(serie.getTitulo()).append("\n");
				info.append("Código: ").append(serie.getCodigo()).append("\n");
				info.append("Director: ").append(serie.getAutor()).append("\n");
				info.append("Rating: ").append(serie.getNota()).append("\n");
				info.append("Géneros: ").append(serie.getGenero1()).append(", ").append(serie.getGenero2()).append(", ").append(serie.getGenero3()).append("\n");
				info.append("Número de Temporadas: ").append(serie.getTemporadas()).append("\n");
				String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
				for (int i = 0; i < 12; i++) {
					info.append(meses[i]).append(": ").append(serie.getEspectadores()[i]).append("\n");
				}
				info.append("Categoría: Disney").append("\n");
				return info.toString();
			}
		}
		return "No se encontró ninguna película o serie con el título: " + titulo;
	}
	
}
