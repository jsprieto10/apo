package uniandes.cupi2.desafioDeChip.interfaz;


import java.awt.*; 
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.desafioDeChip.mundo.Casilla;
public class PanelTablero extends JPanel{

	
	private InterfazJuego principal;
	private JLabel[][] casillas;
	private int filas;
	private int columnas;

	
	public PanelTablero(InterfazJuego v){
		principal = v;
		TitledBorder border = BorderFactory.createTitledBorder("");
		border.setTitleColor( Color.BLACK );
		setBorder( border );
		setLayout ( new GridLayout());
		
	}

	
	public void inicializar(){
		
		//Limpia las imagenes existentes en el panel
		removeAll();
		
		//Crea la forma
		filas = principal.darFilas();
		columnas = principal.darColumnas();
		setLayout( new GridLayout(filas, columnas));

		casillas= new JLabel[filas][columnas];
		
		for ( int i = 0; i< casillas.length; i++){
			for( int j =0; j<casillas[0].length; j++){
				
					JLabel actual = new JLabel();
					int estado = principal.darEstado(i,j);
					ImageIcon icono = new ImageIcon( principal.darRutaImagenes(estado));
					actual.setIcon(icono);
					casillas[i][j] = actual;
					actual.setPreferredSize(new Dimension( 51, 52));
					add(actual);
				
				
			}
		}
		validate();
	} 
	
	public JLabel[][] darTablero(){
		return casillas;
	}
	public void actualizarMapa() 
	{
		for ( int i = 0; i< casillas.length; i++){
			for( int j =0; j<casillas[0].length; j++){

				int estado = principal.darEstado(i,j);
				ImageIcon icono = new ImageIcon( principal.darRutaImagenes(estado));
				casillas[i][j].setIcon(icono);

			}
		}
	}
	public void finJuego(){
		for ( int i = 0; i< casillas.length; i++){
			for( int j =0; j<casillas[0].length; j++){
				JLabel actual = casillas [i][j];
				actual.setEnabled(false);


			}
		}
	}
	





}


