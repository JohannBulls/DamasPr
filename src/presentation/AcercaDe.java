package presentation;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class AcercaDe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DamasGui damasGui;
	
	private JLabel label1;
	
	private JTextArea area;
	
	private JScrollPane panel;
	
	
	public AcercaDe(DamasGui Pprincipal) {
		damasGui = Pprincipal;
		iniciar();
		alinear();
		setSize(500,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(damasGui);
	}
	
	public void alinear() {
		getContentPane().setLayout(null);
		label1.setBounds(160,0,500,50);
		getContentPane().add(label1);
		panel.setBounds(0,50,485,236);
		getContentPane().add(panel);
	}
	
	public void iniciar() {
		label1 = new JLabel("Juego De Damas");
		label1.setFont(new Font("1942 report", Font.CENTER_BASELINE, 18));

		area = new JTextArea();
		area.setEditable(false);
		area.setText("Proyecto Personal, Recreando el popular juego de damas en el entorno de desarrollo java, \nHecho por: Kevin Rodrigo Guerrero Posso \nEstudiante De: "
				+ "Ingenier�a En Sistemas Cursando cuarto Semestre en la Universidad Santiago De Cali\nEl Programa aun est� en fase beta ya que aun no tiene implementadas \n"
				+ "algunas reglas b�sicas del juego de damas original, los movimientos de las damas se hacen en diagonal,\n"
				+ "si vas a eliminar a una ficha enemiga simplemente le pasas por encima\n"
				+ "Im�genes Pertenecientes a: Freddy Gonz�lez\n"
				+ "modos de juegos: Pc vs Pc, Manual vs Pc y Manual vs Manual\n\n"
				+ "Proyecto hecho de estudiante para estudiantes\n"
				+ "publicado el 27 de Noviembre de 2018");
		panel = new JScrollPane(area);
	}
}
