package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class DamasGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelImagen imagen;
	PanelDeJuego juego;	
	PanelBarraDeHerramientas panel1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DamasGui frame = new DamasGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DamasGui() {
		super("Damas");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		iniciar();
		alinear();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width/2, height/2);		
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void alinear() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Informacion")));
		panel.add(imagen);
		
		setLayout(new BorderLayout());
		add(juego, BorderLayout.CENTER);
		add(panel1, BorderLayout.NORTH);
	}

	public void Actualizar_botones() {
		juego.ResetearTablero();
		juego.dibujar_en_los_botones();
		
	}
	
	public void iniciar() {
		juego = new PanelDeJuego();
		panel1 = new PanelBarraDeHerramientas(this,juego);
		imagen = new PanelImagen();
	}

}
