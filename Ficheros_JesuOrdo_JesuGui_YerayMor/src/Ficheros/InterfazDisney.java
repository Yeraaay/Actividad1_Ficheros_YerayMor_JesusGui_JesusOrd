package Ficheros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class InterfazDisney {
	
	// ATRIBUTOS
	static Disney disney = new Disney();

	private static JFrame frame;
	private static JPanel panelConFondo;
	private static JButton botonAnimado = new JButton("Bienvenido a Disney");
	private static GridBagConstraints constraints;
	private static JPanel panelBotonesPeliculasSeries = new JPanel(new GridBagLayout());
	private static JPanel panelBotones= new JPanel(new GridBagLayout());
	private static BufferedImage imagenFondo = null;
	private static Dimension dimensionFija= new Dimension(200, 80);;
	private static JTextArea textArea;
	private static JScrollPane scrollPane;
	private static Font customFont;
	private static Font fontDisney;
	private static Font fontDisneyChiquitita;
	private static Clip clip;
	private static JButton botonPeliculas = new JButton("Películas");
	private static JButton botonSeries = new JButton("Series");
	private static JButton botonMostrarXML = new JButton("Mostrar xml");
	private static JButton botonOtrosDatos = new JButton("Otros Datos");
	private static JButton botonDesplegarSeriesMarvel = new JButton();
	private static JButton botonDesplegarSeriesPixar  = new JButton();
	private static JButton botonDesplegarSeriesStarWars  = new JButton();
	private static JButton botonDesplegarSeriesDisney  = new JButton();
	private static JButton botonDesplegarDisney  = new JButton();
	private static JButton botonDesplegarMarvel  = new JButton();
	private static JButton botonDesplegarPixar  = new JButton();
	private static JButton botonDesplegarStarWars  = new JButton();
	private static JButton btnModificarTitulo = new JButton("<html>Modificar<br>Título</html>");
	private static JButton btnAgregarPelicula = new JButton("<html>Agregar<br>Película</html>");
	private static JButton btnAgregarSerie = new JButton("<html>Agregar<br>Serie</html>");
	private static JButton btnEliminarContenido = new JButton("<html>Eliminar<br>Contenido</html>");
	private static JButton btnEspectadores = new JButton("<html>Espectadores<br>Anuales</html>");
	
	// Opciones de los desplegables
	private static String[] opcionesPeliculasMarvel= {"Iron Man", "Deadpool"};
	private static String[] opcionesPeliculasPixar = {"Toy Story", "Cars"};
	private static String[] opcionesPeliculasStarWars = {"El Ascenso De Sky-Walker", "Han Solo"};
	private static String[] opcionesPeliculasDisney = {"El Rey Leon", "Frozen"};

	private static String[] opcionesSeriesMarvel = {"Loki", "Daredevil"};
	private static String[] opcionesSeriesPixar = {"Monstruos a la obra", "Dug y Carl"};
	private static String[] opcionesSeriesStarWars = {"Mandalorian", "Kenobi"};
	private static String[] opcionesSeriesDisney = {"Chip y Chop", "Dinosaurios"};

	// JComboBox para las películas
	private static JComboBox<String> desplegableMarvel = new JComboBox<>(opcionesPeliculasMarvel);
	private static JComboBox<String> desplegablePixar = new JComboBox<>(opcionesPeliculasPixar);
	private static JComboBox<String> desplegableStarWars = new JComboBox<>(opcionesPeliculasStarWars);
	private static JComboBox<String> desplegableDisney = new JComboBox<>(opcionesPeliculasDisney);

	// JComboBox para las series
	private static JComboBox<String> desplegableSeriesMarvel = new JComboBox<>(opcionesSeriesMarvel);
	private static JComboBox<String> desplegableSeriesPixar = new JComboBox<>(opcionesSeriesPixar);
	private static JComboBox<String> desplegableSeriesStarWars = new JComboBox<>(opcionesSeriesStarWars);
	private static JComboBox<String> desplegableSeriesDisney = new JComboBox<>(opcionesSeriesDisney);

	// Añadimos un boton que nos permita volver al inicio del programa
	private static JButton btnVolver  = new JButton("volver al inicio");
	
	// Agregamos los atributos necesarios para configurar correctamente la musica
	private static String[] opcionesMusica = {"Iron Man", "Deadpool", "Toy Story", "Cars",
			"El Ascenso De Sky-Walker", "Han Solo", "El Rey Leon", "Frozen","Loki", "Daredevil",
			"Monstruos a la obra", "Dug y Carl", "Mandalorian", "Kenobi", "Chip y Chop", "Dinosaurios", "Ciclo sin fin"};
	private static JComboBox<String> desplegableMusica = new JComboBox<String>(opcionesMusica);
	
	// Para controlar el volumen
	private static JButton btnDetenerCancion = new JButton("Detener Canción");
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDisney window = new InterfazDisney();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazDisney() {
		initialize();
	}
	
	// MÉTODOS PARA LA FUNCIONALIDAD DE LA INTERFAZ GRÁFICA
	
	// Carga y reproduce la música
	public static void reproducirMusica(String cancion) {
		try {
			String rutaMusica = "audio/" + cancion.toLowerCase().replaceAll(" ", "_") + ".wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(rutaMusica));
			if (clip != null) {
				clip.stop(); // La musica actual se detiene si se está reproduciendo otra
				clip.close(); // Cerramos el clip actual
			}
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Define el valor de atenuación del volumen 
            float attenuation = -10.0f; 
            gainControl.setValue(attenuation);
			clip.start(); // Reproducimos la música
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		frame = new JFrame("Bienvenido a Disney");
		frame.setSize(1150, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		reproducirMusica("Ciclo sin fin");

		// Cargamos la fuente personalizada
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("waltograph42.otf"));
			ge.registerFont(customFont);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Personalizamos las fuentes del programa
		fontDisney = new Font(customFont.getFontName(), Font.PLAIN, 35);
		fontDisneyChiquitita = new Font(customFont.getFontName(), Font.PLAIN, 20);

		File archivo = new File("Disney.xml");

		if (archivo.exists()) {
			disney = Metodos.reutilizarXML();
		} else {
			disney = Metodos.crearXML();
		}
		
		// Configuramos el boton de detener la música para que detecte la canción y la detenga
		btnDetenerCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clip != null && clip.isRunning()) clip.stop();
			}
		});
		
		
		desplegableMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos la cancion seleccionada en el desplegable
				String cancionSeleccionada = (String) desplegableMusica.getSelectedItem();
				// Llamamos al metodo de reproducir música según la cancion seleccionada
				reproducirMusica(cancionSeleccionada);
			}
		});

		try {
			imagenFondo = ImageIO.read(new File("imagenes/portadaMM.jpg"));
			panelConFondo = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
				}
			};
		} catch (IOException e) {
			e.printStackTrace();
			panelConFondo = new JPanel();
		}

		botonAnimado.setFont(fontDisney);
		botonAnimado.setBackground(new Color(0, 123, 255));
		botonAnimado.setForeground(Color.WHITE);
		botonAnimado.setFocusPainted(false);
		botonAnimado.setBorderPainted(false);
		botonAnimado.setOpaque(true);

		botonAnimado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Creamos la estructura del XML
				abrirXML();
				botonAnimado.setVisible(false);
				botonAnimado.setEnabled(false);
				btnVolver.setVisible(true);
				btnVolver.setEnabled(true);
			}
		});

		try {
			BufferedImage cursorImage = ImageIO.read(new File("imagenes/varita.png"));
			Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");
			frame.setCursor(customCursor);
		} catch (IOException e) {
			e.printStackTrace();
		}

		panelConFondo.setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(150, 0, 0, 0);

		panelConFondo.add(botonAnimado, constraints);

		btnVolver.setFont(fontDisney);
		btnVolver.setBackground(new Color(255, 0, 0));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFocusPainted(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setOpaque(true);
		btnVolver.setVisible(false);
		btnVolver.setEnabled(false);

		// Agrega un ActionListener al botón "Volver al Inicio"
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Llama a un método para volver a la interfaz principal
				volverAInterfazPrincipal();
			}
		});
		
		frame.setLayout(new BorderLayout());
		// Agregar el desplegable de música en la esquina superior izquierda
		frame.add(desplegableMusica, BorderLayout.NORTH);

		// Configura la posición del botón en el panel
		constraints.gridx = 0;
		constraints.gridy = 1; // Colócalo debajo de los demás componentes
		constraints.insets = new Insets(10, 0, 10, 0); // Ajustamos los márgenes

		// Agrega el botón "Volver al Inicio" al panel
		panelConFondo.add(btnVolver, constraints);
		
		// Agregamos el botón de detener la música debajo de la ventana
		frame.add(btnDetenerCancion, BorderLayout.SOUTH);

		frame.add(panelConFondo);
	}


	public static void abrirXML() {
		GridBagConstraints constraints = new GridBagConstraints();

		botonPeliculas = new JButton("Películas");
		botonSeries = new JButton("Series");
		botonMostrarXML = new JButton("Mostrar xml");
		botonOtrosDatos = new JButton("Otros Datos");

		botonPeliculas.setFont(fontDisney);
		botonSeries.setFont(fontDisney);
		botonMostrarXML.setFont(fontDisney);
		botonOtrosDatos.setFont(fontDisney);

		Color colorFijo = new Color(0, 80, 250);
		botonPeliculas.setBackground(colorFijo);
		botonSeries.setBackground(colorFijo);
		botonMostrarXML.setBackground(colorFijo);
		botonOtrosDatos.setBackground(colorFijo);

		botonPeliculas.setForeground(Color.WHITE);
		botonSeries.setForeground(Color.WHITE);
		botonMostrarXML.setForeground(Color.WHITE);
		botonOtrosDatos.setForeground(Color.WHITE);

		botonPeliculas.setFocusPainted(false);
		botonSeries.setFocusPainted(false);
		botonMostrarXML.setFocusPainted(false);
		botonOtrosDatos.setFocusPainted(false);

		botonPeliculas.setBorderPainted(false);
		botonSeries.setBorderPainted(false);
		botonMostrarXML.setBorderPainted(false);
		botonOtrosDatos.setBorderPainted(false);

		botonPeliculas.setOpaque(true);
		botonSeries.setOpaque(true);
		botonMostrarXML.setOpaque(true);
		botonOtrosDatos.setOpaque(true);

		botonPeliculas.setPreferredSize(dimensionFija);
		botonSeries.setPreferredSize(dimensionFija);
		botonMostrarXML.setPreferredSize(dimensionFija);
		botonOtrosDatos.setPreferredSize(dimensionFija);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelBotonesPeliculasSeries.add(botonPeliculas, constraints);

		constraints.gridx = 1;
		panelBotonesPeliculasSeries.add(botonSeries, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		panelBotonesPeliculasSeries.add(botonMostrarXML, constraints);

		constraints.gridx = 1;
		panelBotonesPeliculasSeries.add(botonOtrosDatos, constraints);

		panelBotonesPeliculasSeries.setOpaque(false);

		botonPeliculas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarDesplegablesPeliculas();
				botonPeliculas.setVisible(false);
				botonSeries.setVisible(false);
				botonMostrarXML.setVisible(false);
				botonOtrosDatos.setVisible(false);
				btnVolver.setVisible(true);
				btnVolver.setEnabled(true);

				//Volvemos a activar los desplegables de las películas
				desplegableMarvel.setVisible(true);
				desplegableMarvel.setEnabled(true);

				desplegableDisney.setVisible(true);
				desplegableDisney.setEnabled(true);

				desplegablePixar.setVisible(true);
				desplegablePixar.setEnabled(true);

				desplegableStarWars.setVisible(true);
				desplegableStarWars.setEnabled(true);
			}
		});
		botonSeries.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarDesplegablesSeries();
				botonPeliculas.setVisible(false);
				botonSeries.setVisible(false);
				botonMostrarXML.setVisible(false);
				botonOtrosDatos.setVisible(false);
				btnVolver.setVisible(true);
				btnVolver.setEnabled(true);

				//Volvemos a activar los desplegables de las series
				desplegableSeriesMarvel.setVisible(true);
				desplegableSeriesMarvel.setEnabled(true);

				desplegableSeriesPixar.setVisible(true);
				desplegableSeriesPixar.setEnabled(true);

				desplegableSeriesStarWars.setVisible(true);
				desplegableSeriesStarWars.setEnabled(true);

				desplegableSeriesDisney.setEnabled(true);
				desplegableSeriesDisney.setVisible(true);
			}
		});

		botonMostrarXML.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String mostrar = Metodos.leerXML("Disney.xml");
				textArea = new JTextArea(20, 40); // Crear un JTextArea con 20 filas y 40 columnas
				textArea.setText(mostrar);

				scrollPane = new JScrollPane(textArea);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				JOptionPane.showMessageDialog(frame, scrollPane, "DISNEY", JOptionPane.INFORMATION_MESSAGE);

				botonPeliculas.setVisible(true);
				botonSeries.setVisible(true);
				botonMostrarXML.setVisible(true);
				botonOtrosDatos.setVisible(true);
			}
		});

		botonOtrosDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desplegarOtrosDatos();
				botonPeliculas.setVisible(false);
				botonSeries.setVisible(false);
				botonMostrarXML.setVisible(false);
				botonOtrosDatos.setVisible(false);
				btnVolver.setVisible(true);
				btnVolver.setEnabled(true);
			}
		});

		panelConFondo.add(panelBotonesPeliculasSeries);
		panelConFondo.revalidate();
	}

	public static void agregarDesplegablesPeliculas() {
		GridBagConstraints constraints = new GridBagConstraints();

		// Crear un ícono con la imagen escalada
		ImageIcon iconoMarvel = new ImageIcon("imagenes/marvel.png");
		Image imageMarvel = iconoMarvel.getImage();
		Image newImageMarvel = imageMarvel.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoMarvel = new ImageIcon(newImageMarvel);
		botonDesplegarMarvel = new JButton(iconoMarvel);

		ImageIcon iconoPixar = new ImageIcon("imagenes/pixar.jpg");
		Image imagePixar = iconoPixar.getImage();
		Image newImagePixar = imagePixar.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoPixar = new ImageIcon(newImagePixar);
		botonDesplegarPixar = new JButton(iconoPixar);

		ImageIcon iconoStarWars = new ImageIcon("imagenes/starwars.png");
		Image imageStarWars = iconoStarWars.getImage();
		Image newImageStarWars = imageStarWars.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoStarWars = new ImageIcon(newImageStarWars);
		botonDesplegarStarWars = new JButton(iconoStarWars);

		ImageIcon iconoDisney = new ImageIcon("imagenes/disney.jpg");
		Image imageDisney = iconoDisney.getImage();
		Image newImageDisney = imageDisney.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoDisney = new ImageIcon(newImageDisney);
		botonDesplegarDisney = new JButton(iconoDisney);

		botonDesplegarMarvel.setFont(fontDisney);
		botonDesplegarMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opcionesPeliculasMarvel= new String[disney.getPeliculas().getPeliculasMarvel().size()];
				for (int i=0;i<disney.getPeliculas().getPeliculasMarvel().size();i++){
					opcionesPeliculasMarvel[i]=disney.getPeliculas().getPeliculasMarvel().get(i).getTitulo();
				}
				desplegableMarvel.setModel(new DefaultComboBoxModel<>(opcionesPeliculasMarvel));
				desplegableMarvel.showPopup();
			}
		});
		botonDesplegarPixar.setFont(fontDisney);
		botonDesplegarPixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opcionesPeliculasPixar= new String[disney.getPeliculas().getPeliculasPixar().size()];
				for (int i=0;i<disney.getPeliculas().getPeliculasPixar().size();i++){
					opcionesPeliculasPixar[i]=disney.getPeliculas().getPeliculasPixar().get(i).getTitulo();
				}				
				desplegablePixar.setModel(new DefaultComboBoxModel<>(opcionesPeliculasPixar));
				desplegablePixar.showPopup();
			}
		});
		botonDesplegarStarWars.setFont(fontDisney);
		botonDesplegarStarWars.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opcionesPeliculasStarWars= new String[disney.getPeliculas().getPeliculasStarWars().size()];
				for (int i=0;i<disney.getPeliculas().getPeliculasStarWars().size();i++){
					opcionesPeliculasStarWars[i]=disney.getPeliculas().getPeliculasStarWars().get(i).getTitulo();
				}				
				desplegableStarWars.setModel(new DefaultComboBoxModel<>(opcionesPeliculasStarWars));
				desplegableStarWars.showPopup();
			}
		});
		botonDesplegarDisney.setFont(fontDisney);
		botonDesplegarDisney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opcionesPeliculasDisney= new String[disney.getPeliculas().getPeliculasDisney().size()];
				for (int i=0;i<disney.getPeliculas().getPeliculasDisney().size();i++){
					opcionesPeliculasDisney[i]=disney.getPeliculas().getPeliculasDisney().get(i).getTitulo();
				}				
				desplegableDisney.setModel(new DefaultComboBoxModel<>(opcionesPeliculasDisney));
				desplegableDisney.showPopup();
			}
		});

		desplegableMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String peliculaSeleccionada = (String) desplegableMarvel.getSelectedItem();

				// Obtenemos la información de la película
				String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);

				// Cambiamos la imagen de fondo
				if (peliculaSeleccionada.equalsIgnoreCase("Iron Man")) cargarImagenFondo("ironman.jpg");
				else if (peliculaSeleccionada.equalsIgnoreCase("DeadPool")) cargarImagenFondo("deadpool.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegablePixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String peliculaSeleccionada = (String) desplegablePixar.getSelectedItem();

				// Obtenemos la información de la película
				String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);


				// Cambiamos la imagen de fondo
				if (peliculaSeleccionada.equalsIgnoreCase("Toy Story")) cargarImagenFondo("toystory.jpg");
				else if (peliculaSeleccionada.equalsIgnoreCase("Cars")) cargarImagenFondo("cars.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);

			}
		});

		desplegableStarWars.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String peliculaSeleccionada = (String) desplegableStarWars.getSelectedItem();

				// Obtenemos la información de la película
				String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);


				// Cambiamos la imagen de fondo
				if (peliculaSeleccionada.equalsIgnoreCase("El Ascenso De Sky-Walker")) cargarImagenFondo("skywalker.jpg");
				else if (peliculaSeleccionada.equalsIgnoreCase("Han Solo")) cargarImagenFondo("hansolo.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegableDisney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String peliculaSeleccionada = (String) desplegableDisney.getSelectedItem();

				// Obtenemos la información de la película
				String infoPelicula = Metodos.obtenerInfoPorTitulo(disney, peliculaSeleccionada);


				// Cambiamos la imagen de fondo
				if (peliculaSeleccionada.equalsIgnoreCase("El Rey Leon")) cargarImagenFondo("reyleon.jpg");
				else if (peliculaSeleccionada.equalsIgnoreCase("Frozen")) cargarImagenFondo("frozen.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoPelicula, "Información de la Película: " + peliculaSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegableMarvel.setFont(fontDisneyChiquitita);
		desplegablePixar.setFont(fontDisneyChiquitita);
		desplegableStarWars.setFont(fontDisneyChiquitita);
		desplegableDisney.setFont(fontDisneyChiquitita);
		((JLabel) desplegableMarvel.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegablePixar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegableStarWars.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegableDisney.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		desplegableMarvel.setPreferredSize(dimensionFija);
		desplegablePixar.setPreferredSize(dimensionFija);
		desplegableStarWars.setPreferredSize(dimensionFija);
		desplegableDisney.setPreferredSize(dimensionFija);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(20, 20, 20, 20);

		panelBotonesPeliculasSeries.add(botonDesplegarMarvel, constraints);
		constraints.gridx = 1;
		panelBotonesPeliculasSeries.add(botonDesplegarPixar, constraints);
		constraints.gridx = 2;
		panelBotonesPeliculasSeries.add(botonDesplegarStarWars, constraints);
		constraints.gridx = 3;
		panelBotonesPeliculasSeries.add(botonDesplegarDisney, constraints);

		constraints.gridx = 0;
		panelBotonesPeliculasSeries.add(desplegableMarvel, constraints);
		constraints.gridx = 1;
		panelBotonesPeliculasSeries.add(desplegablePixar, constraints);
		constraints.gridx = 2;
		panelBotonesPeliculasSeries.add(desplegableStarWars, constraints);
		constraints.gridx = 3;
		panelBotonesPeliculasSeries.add(desplegableDisney, constraints);

		panelConFondo.revalidate();
	}

	public static void cargarImagenFondo(String nombreImagen) {
		try {
			imagenFondo = ImageIO.read(new File("imagenes/" + nombreImagen));
			panelConFondo.repaint(); //Vuelve a pintar el panel para mostrar la nueva imagen de fondo
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void agregarDesplegablesSeries() {
		GridBagConstraints constraints = new GridBagConstraints();

		// Crear un ícono con la imagen escalada para que coincida con el tamaño del botón
		ImageIcon iconoSeriesMarvel = new ImageIcon("imagenes/marvel.png");
		Image imageSeriesMarvel = iconoSeriesMarvel.getImage();
		Image newImageSeriesMarvel = imageSeriesMarvel.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoSeriesMarvel = new ImageIcon(newImageSeriesMarvel);
		botonDesplegarSeriesMarvel = new JButton(iconoSeriesMarvel);

		ImageIcon iconoSeriesPixar = new ImageIcon("imagenes/pixar.jpg");
		Image imageSeriesPixar = iconoSeriesPixar.getImage();
		Image newImageSeriesPixar = imageSeriesPixar.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoSeriesPixar = new ImageIcon(newImageSeriesPixar);
		botonDesplegarSeriesPixar = new JButton(iconoSeriesPixar);

		ImageIcon iconoSeriesStarWars = new ImageIcon("imagenes/starwars.png");
		Image imageSeriesStarWars = iconoSeriesStarWars.getImage();
		Image newImageSeriesStarWars = imageSeriesStarWars.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoSeriesStarWars = new ImageIcon(newImageSeriesStarWars);
		botonDesplegarSeriesStarWars = new JButton(iconoSeriesStarWars);

		ImageIcon iconoSeriesDisney = new ImageIcon("imagenes/disney.jpg");
		Image imageSeriesDisney = iconoSeriesDisney.getImage();
		Image newImageSeriesDisney = imageSeriesDisney.getScaledInstance(dimensionFija.width, dimensionFija.height, Image.SCALE_SMOOTH);
		iconoSeriesDisney = new ImageIcon(newImageSeriesDisney);
		botonDesplegarSeriesDisney = new JButton(iconoSeriesDisney);

		botonDesplegarSeriesMarvel.setFont(fontDisney);
		botonDesplegarSeriesMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desplegableSeriesMarvel.showPopup();
			}
		});
		botonDesplegarSeriesPixar.setFont(fontDisney);
		botonDesplegarSeriesPixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desplegableSeriesPixar.showPopup();
			}
		});
		botonDesplegarSeriesStarWars.setFont(fontDisney);
		botonDesplegarSeriesStarWars.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desplegableSeriesStarWars.showPopup();
			}
		});
		botonDesplegarSeriesDisney.setFont(fontDisney);
		botonDesplegarSeriesDisney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desplegableSeriesDisney.showPopup();
			}
		});

		desplegableSeriesMarvel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String SerieSeleccionada = (String) desplegableSeriesMarvel.getSelectedItem();

				// Obtenemos la información de la Serie
				String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);


				// Cambiamos la imagen de fondo
				if (SerieSeleccionada.equals("Loki")) cargarImagenFondo("loki.jpg");
				else if (SerieSeleccionada.equals("Daredevil")) cargarImagenFondo("daredevil.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegableSeriesPixar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String SerieSeleccionada = (String) desplegableSeriesPixar.getSelectedItem();

				// Obtenemos la información de la Serie
				String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);

				// Cambiamos la imagen de fondo
				if (SerieSeleccionada.equalsIgnoreCase("Monstruos a la obra")) cargarImagenFondo("monstruosSA.jpg");
				else if (SerieSeleccionada.equalsIgnoreCase("Dug y Carl")) cargarImagenFondo("dugDays.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		desplegableSeriesStarWars.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String SerieSeleccionada = (String) desplegableSeriesStarWars.getSelectedItem();

				// Obtenemos la información de la Serie
				String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);

				// Cambiamos la imagen de fondo
				if (SerieSeleccionada.equals("Mandalorian")) cargarImagenFondo("mandalorian.jpg");
				else if (SerieSeleccionada.equals("Kenobi")) cargarImagenFondo("kenobi.jpg");

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});


		desplegableSeriesDisney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String SerieSeleccionada = (String) desplegableSeriesDisney.getSelectedItem();

				// Obtenemos la información de la Serie
				String infoSerie = Metodos.obtenerInfoPorTitulo(disney, SerieSeleccionada);

				// Cambiamos la imagen de fondo
				if (SerieSeleccionada.equalsIgnoreCase("Chip y Chop")) {
					cargarImagenFondo("chipychop.jpg");
				}else if (SerieSeleccionada.equalsIgnoreCase("Dinosaurios")) {
					cargarImagenFondo("pete.jpg");
				}

				// Mostramos la información en un diálogo de mensaje (JOptionPane)
				JOptionPane.showMessageDialog(frame, infoSerie, "Información de la Serie: " + SerieSeleccionada, JOptionPane.INFORMATION_MESSAGE);
			}
		});


		desplegableSeriesMarvel.setFont(fontDisneyChiquitita);
		desplegableSeriesPixar.setFont(fontDisneyChiquitita);
		desplegableSeriesStarWars.setFont(fontDisneyChiquitita);
		desplegableSeriesDisney.setFont(fontDisneyChiquitita);
		((JLabel) desplegableSeriesMarvel.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegableSeriesPixar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegableSeriesStarWars.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) desplegableSeriesDisney.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		desplegableSeriesMarvel.setPreferredSize(dimensionFija);
		desplegableSeriesPixar.setPreferredSize(dimensionFija);
		desplegableSeriesStarWars.setPreferredSize(dimensionFija);
		desplegableSeriesDisney.setPreferredSize(dimensionFija);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(20, 20, 20, 20);

		panelBotonesPeliculasSeries.add(botonDesplegarSeriesMarvel, constraints);
		constraints.gridx = 1;
		panelBotonesPeliculasSeries.add(botonDesplegarSeriesPixar, constraints);
		constraints.gridx = 2;
		panelBotonesPeliculasSeries.add(botonDesplegarSeriesStarWars, constraints);
		constraints.gridx = 3;
		panelBotonesPeliculasSeries.add(botonDesplegarSeriesDisney, constraints);

		constraints.gridx = 0;
		panelBotonesPeliculasSeries.add(desplegableSeriesMarvel, constraints);
		constraints.gridx = 1;
		panelBotonesPeliculasSeries.add(desplegableSeriesPixar, constraints);
		constraints.gridx = 2;
		panelBotonesPeliculasSeries.add(desplegableSeriesStarWars, constraints);
		constraints.gridx = 3;
		panelBotonesPeliculasSeries.add(desplegableSeriesDisney, constraints);

		panelConFondo.revalidate();
	}

	public static void desplegarOtrosDatos() {
		frame.getContentPane().add(panelBotones, BorderLayout.CENTER);
		GridBagConstraints constraints = new GridBagConstraints();
		panelBotones.setVisible(true);
		panelBotones.setEnabled(true);

		btnModificarTitulo.setFont(fontDisney);
		btnAgregarPelicula.setFont(fontDisney);
		btnAgregarSerie.setFont(fontDisney);
		btnEliminarContenido.setFont(fontDisney);
		btnEspectadores.setFont(fontDisney);

		Color colorFijo = new Color(0, 80, 250);
		btnModificarTitulo.setBackground(colorFijo);
		btnAgregarPelicula.setBackground(colorFijo);
		btnAgregarSerie.setBackground(colorFijo);
		btnEliminarContenido.setBackground(colorFijo);
		btnEspectadores.setBackground(colorFijo);

		btnModificarTitulo.setForeground(Color.WHITE);
		btnAgregarPelicula.setForeground(Color.WHITE);
		btnAgregarSerie.setForeground(Color.WHITE);
		btnEliminarContenido.setForeground(Color.WHITE);
		btnEspectadores.setForeground(Color.WHITE);

		btnModificarTitulo.setFocusPainted(false);
		btnAgregarPelicula.setFocusPainted(false);
		btnAgregarSerie.setFocusPainted(false);
		btnEliminarContenido.setFocusPainted(false);
		btnEspectadores.setFocusPainted(false);

		btnModificarTitulo.setBorderPainted(false);
		btnAgregarPelicula.setBorderPainted(false);
		btnAgregarSerie.setBorderPainted(false);
		btnEliminarContenido.setBorderPainted(false);
		btnEspectadores.setBorderPainted(false);

		btnModificarTitulo.setOpaque(true);
		btnAgregarPelicula.setOpaque(true);
		btnAgregarSerie.setOpaque(true);
		btnEliminarContenido.setOpaque(true);
		btnEspectadores.setOpaque(true);

		btnModificarTitulo.setPreferredSize(dimensionFija);
		btnAgregarPelicula.setPreferredSize(dimensionFija);
		btnAgregarSerie.setPreferredSize(dimensionFija);
		btnEliminarContenido.setPreferredSize(dimensionFija);
		btnEspectadores.setPreferredSize(dimensionFija);

		btnModificarTitulo.setVisible(true);
		btnAgregarPelicula.setVisible(true);
		btnAgregarSerie.setVisible(true);
		btnEliminarContenido.setVisible(true);
		btnEspectadores.setVisible(true);

		btnModificarTitulo.setEnabled(true);
		btnAgregarPelicula.setEnabled(true);
		btnAgregarSerie.setEnabled(true);
		btnEliminarContenido.setEnabled(true);
		btnEspectadores.setEnabled(true);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(20, 20, 20, 20);
		panelBotones.add(btnAgregarPelicula, constraints);

		constraints.gridx = 1;
		panelBotones.add(btnAgregarSerie, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		panelBotones.add(btnModificarTitulo, constraints);

		constraints.gridx = 1;
		panelBotones.add(btnEliminarContenido, constraints);

		constraints.gridx = 2;
		panelBotones.add(btnEspectadores, constraints);

		panelBotones.setOpaque(false);

		//Agregamos ActionListener para cada botón
		btnModificarTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.modificarTitulo(disney);
			}
		});

		btnAgregarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.agregarPelicula(disney);
			}
		});

		btnAgregarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.agregarSerie(disney);
			}
		});

		btnEliminarContenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.eliminarPorCodigo(disney);
			}
		});

		btnEspectadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.espectadoresAnuales(disney);
			}
		});
	}

	// Método para volver a la interfaz principal
	private static void volverAInterfazPrincipal() {
		// Ocultar y deshabilitar componentes específicos
		desplegableDisney.setVisible(false);
		desplegableDisney.setEnabled(false);

		desplegableMarvel.setVisible(false);
		desplegableMarvel.setEnabled(false);

		desplegablePixar.setVisible(false);
		desplegablePixar.setEnabled(false);

		desplegableStarWars.setVisible(false);
		desplegableStarWars.setEnabled(false);

		desplegableSeriesMarvel.setVisible(false);
		desplegableSeriesMarvel.setEnabled(false);

		desplegableSeriesPixar.setVisible(false);
		desplegableSeriesPixar.setEnabled(false);

		desplegableSeriesStarWars.setVisible(false);
		desplegableSeriesStarWars.setEnabled(false);

		desplegableSeriesDisney.setVisible(false);
		desplegableSeriesDisney.setEnabled(false);

		btnAgregarPelicula.setVisible(false);
		btnAgregarPelicula.setEnabled(false);
		btnAgregarSerie.setVisible(false);
		btnAgregarSerie.setEnabled(false);
		btnModificarTitulo.setVisible(false);
		btnModificarTitulo.setEnabled(false);
		btnEliminarContenido.setVisible(false);
		btnEliminarContenido.setEnabled(false);
		btnEspectadores.setVisible(false);
		btnEspectadores.setEnabled(false);

		botonDesplegarMarvel.setVisible(false);
		botonDesplegarMarvel.setEnabled(false);

		botonDesplegarPixar.setVisible(false);
		botonDesplegarPixar.setEnabled(false);

		botonDesplegarStarWars.setVisible(false);
		botonDesplegarStarWars.setEnabled(false);

		botonDesplegarDisney.setVisible(false);
		botonDesplegarDisney.setEnabled(false);

		botonDesplegarSeriesMarvel.setVisible(false);
		botonDesplegarSeriesMarvel.setEnabled(false);

		botonDesplegarSeriesPixar.setVisible(false);
		botonDesplegarSeriesPixar.setEnabled(false);

		botonDesplegarSeriesStarWars.setVisible(false);
		botonDesplegarSeriesStarWars.setEnabled(false);

		botonDesplegarSeriesDisney.setVisible(false);
		botonDesplegarSeriesDisney.setEnabled(false);

		btnVolver.setVisible(false);
		btnVolver.setEnabled(false);

		panelBotones.setVisible(false);
		panelBotones.setEnabled(false);


		//Declaramos todos los botones anteriores visibles y disponibles
		botonPeliculas.setVisible(true);
		botonPeliculas.setEnabled(true);

		botonSeries.setVisible(true);
		botonSeries.setEnabled(true);

		botonMostrarXML.setVisible(true);
		botonMostrarXML.setEnabled(true);

		botonOtrosDatos.setVisible(true);
		botonOtrosDatos.setEnabled(true);

		frame.validate(); // Actualiza la interfaz
	}
}