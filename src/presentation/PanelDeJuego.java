package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domine.Damas;


public class PanelDeJuego extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton boton[][];

	private Damas damas;

	private PanelImagen imagen;

	private NuevaPartida sele;
	
	public static int tam_N ;
	private int tamanio = 100, tablero[][] = new int[tam_N][tam_N];
	
	
	
	public void iniciar() {
		tam_N=8;
		imagen = new PanelImagen();
		boton = new JButton[tam_N][tam_N];
		damas = new Damas();
		damas.poner_fichas();
		removeAll();
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton[0].length; j++) {

				boton[i][j] = new JButton();
				boton[i][j].setBackground(Color.WHITE);
				boton[i][j].setBorderPainted(false);
				boton[i][j].setContentAreaFilled(false);
				boton[i][j].setOpaque(false);
				boton[i][j].addActionListener(this);
				boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\EspacionBlanco.png"));
			}
		}
	}

	public void ResetearTablero() {
		damas.poner_fichas();
	}
	
	public void dibujar_tablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (j % 2 == 0) {
					tablero[1][j] = 5;
					tablero[7][j] = 5;
					tablero[5][j] = 5;
					tablero[3][j] = 5;
					System.out.println(i+","+j+"="+5);
				}else {
					tablero[0][j] = 5;
					tablero[6][j] = 5;
					tablero[2][j] = 5;
					tablero[4][j] = 5;
					System.out.println(i+","+j+"="+4);
				}		
				
			}
		}
		System.out.println("!!!-----------!!!");
	}
	
	public void crear_tabero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				if (tablero[i][j] == damas.getNegras()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaNn.jpg"));
				} else if (tablero[i][j] == damas.getRojas()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaRn.jpg"));
				} else if (tablero[i][j] == damas.getReinaR()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaRRn.jpg"));
				} else if (tablero[i][j] == damas.getReinaN()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaRNn.jpg"));
				} else if (tablero[i][j] == damas.getRelleno()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\EspacionNegro.png"));
				}
			}
		}
	}
	
	public void dibujar_en_los_botones() {
		damas.verificar(damas.getColor());
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				if (damas.verdamas(i, j) == damas.getNegras()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaNn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getRojas()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaRn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getReinaR()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaRRn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getReinaN()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\fichaRNn.jpg"));
				} else if (damas.verdamas(i, j) == damas.getRelleno()) {
					boton[i][j].setIcon(new ImageIcon("D:\\\\\\\\Documents\\\\\\\\POOB\\\\\\\\DamasPr\\\\\\\\src\\\\\\\\images\\\\\\\\EspacionNegro.png"));
				}
			}
		}
	}

	public void alo() {
		damas.poner_fichas();
		dibujar_en_los_botones();
	}

	public boolean IA(boolean pasa) {
		int x = (int) (Math.random() * tam_N) + 0;
		int y = (int) (Math.random() * tam_N) + 0;
		int x1 = (int) (Math.random() * tam_N) + 0;
		int y1 = (int) (Math.random() * tam_N) + 0;
		if (damas.jugar(damas.getColor(), x, y, x1, y1) == true) {
			dibujar_en_los_botones();
			boton[x][y].setIcon(new ImageIcon("D:\\\\Documents\\\\POOB\\\\DamasPr\\\\src\\\\images\\\\EspacionNegro.png"));
			return true;
		}
		return pasa;
	}

	public void alinear() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(tam_N, tam_N));

		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton[0].length; j++) {
				panel.add(boton[i][j]);
			}
		}
		add(panel);
	}

	public PanelDeJuego() {
		sele = new NuevaPartida();
		iniciar();
		setLayout(new BorderLayout());
		//setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("juego")));
		setVisible(true);
		alinear();
		dibujar_tablero();
		crear_tabero();
	}

	public void cambiar(int rojas,int negras) {
		this.rojas = rojas;
		this.negras = negras;
	}
	
	int contar = 0;
	int x = 0, y = 0, x1 = 0, y1 = 0,rojas,negras;

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean pasa = false;
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton[0].length; j++) {
				if(e.getSource() == boton[i][j]) {
					
					if(rojas == 1 && negras == 1) {
						//Rojas:Automatico Vs Negras:Automatico
						
						while(IA(pasa) == false) {
							
						}
						damas.CambioDeTurno();
					}else if(rojas == 2 && negras == 2) {
						//Rojas:Manual Vs Negras:Manual
						if(damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
							x = i;
							y = j;
							contar++;
						}else if(contar == 1) {
							if(damas.jugar(damas.getColor(), x, y, i, j)) {
								dibujar_en_los_botones();
								damas.CambioDeTurno();
							}else {
								JOptionPane.showMessageDialog(null,"Movimiento Invalido");
							}
							contar--;
						}
					}else if(rojas == 1 && negras == 2) {
						//Rojas:Automatico Vs Negras:Manual
						
						if(damas.getColor() == 'N') {
							if(damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jugar(damas.getColor(), x, y, i, j)) {
									dibujar_en_los_botones();
									damas.CambioDeTurno();
								}else {
									JOptionPane.showMessageDialog(null,"Movimiento Invalido");
								}
								contar--;
							}
						}else {
							while(IA(pasa) == false) {
								
							}
							damas.CambioDeTurno();
						}
						
						
					}else if(rojas == 2 && negras == 1) {
						//Rojas:Manual Vs Negras:Automatico
						
						if(damas.getColor() == 'R') {
							if(damas.verificar_exitencia_de_ficha(damas.getColor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jugar(damas.getColor(), x, y, i, j)) {
									dibujar_en_los_botones();
									damas.CambioDeTurno();
								}else {
									JOptionPane.showMessageDialog(null,"Movimiento Invalido");
								}
								contar--;
							}
						}else {
							while(IA(pasa) == false) {
								
							}
							damas.CambioDeTurno();
						}
						
					}
				}
			}
		}
	}

}
