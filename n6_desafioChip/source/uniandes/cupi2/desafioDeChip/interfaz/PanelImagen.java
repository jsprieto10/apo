package uniandes.cupi2.desafioDeChip.interfaz;

import javax.swing.*;
/**
 * Panel con la imagen del encabezado.
 */
public class PanelImagen extends JPanel {

	/**
	 * Imagen del encabezado
	 */
	private JLabel lblImagen;
	/**
	 * Crea el panel con la imagen del encabezado.
	 */
	public PanelImagen()
	{
		lblImagen = new JLabel();
		ImageIcon icono = new ImageIcon( "data/imagenes/Encabezado.png" );
		lblImagen.setIcon(icono);
		add(lblImagen);
	}

}
