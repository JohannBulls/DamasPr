package presentation;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	
	public void iniciar() {
		label = new JLabel();
	}
	
	public PanelImagen() {
		iniciar();
	    JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "D:\\Documents\\POOB\\DamasPr\\src\\images\\FondoInformacion.png" );
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        imagen.setBounds(100,100,100,520);
        add( imagen );
	}
}
