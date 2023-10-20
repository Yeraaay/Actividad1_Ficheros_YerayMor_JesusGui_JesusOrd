package Ficheros;

import java.io.File;
import java.io.StringReader;
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
import org.xml.sax.InputSource;

public class Metodos {

	public void leerXML(String rutaArchivo) {
		try {
			File archivoXML = new File(rutaArchivo);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(archivoXML);

			// Mostrar el contenido de las etiquetas
			NodeList nodeList = document.getElementsByTagName("*");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String tagName = element.getTagName();
					String textContent = element.getTextContent();
					System.out.println(tagName + ": " + textContent);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(pelicula.getEspectadores())).append("\n");
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(pelicula.getEspectadores())).append("\n");
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(pelicula.getEspectadores())).append("\n");
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(pelicula.getEspectadores())).append("\n");
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(serie.getEspectadores())).append("\n");
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(serie.getEspectadores())).append("\n");
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(serie.getEspectadores())).append("\n");
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
				info.append("Espectadores Anuales: ").append(Arrays.toString(serie.getEspectadores())).append("\n");
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
