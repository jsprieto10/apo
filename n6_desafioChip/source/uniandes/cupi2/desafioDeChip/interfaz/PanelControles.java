package uniandes.cupi2.desafioDeChip.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.desafioDeChip.interfaz.InterfazJuego;

public class PanelControles extends JPanel implements ActionListener {
	public final static String ARRIBA ="arriba";
	public final static String ABAJO ="abajo";
	public final static String DERECHA ="derecha";
	public final static String IZQUIERDA ="izquierda";

	
	private InterfazJuego principal;

	
	private JButton arriba;
	private JButton abajo;
	private JButton derecha;
	private JButton izquierda;

	public PanelControles(InterfazJuego v){
		principal = v;
		
		
		TitledBorder border = BorderFactory.createTitledBorder( "Controles");
		border.setTitleColor( Color.BLACK );
		setBorder( border );
		setLayout(new GridLayout(3,3));
		setPreferredSize(new Dimension(210, 360));





		arriba = new JButton ();
		arriba.setIcon(new ImageIcon("data/imagenes/botonArriba.png"));
		arriba.setEnabled(false);
		arriba.setPreferredSize(new Dimension(36, 36));
		arriba.addActionListener(this);
		arriba.setActionCommand(ARRIBA);


		izquierda = new JButton ();
		izquierda.setIcon(new ImageIcon("data/imagenes/botonIzquierda.png"));
		izquierda.setEnabled(false);
		izquierda.setPreferredSize(new Dimension(36, 36));
		izquierda.addActionListener(this);
		izquierda.setActionCommand(IZQUIERDA);



		derecha = new JButton ();
		derecha.setIcon(new ImageIcon("data/imagenes/botonDerecha.png"));
		derecha.setEnabled(false);
		derecha.setPreferredSize(new Dimension(36, 36));
		derecha.addActionListener(this);
		derecha.setActionCommand(DERECHA);


		abajo = new JButton ();
		abajo.setIcon(new ImageIcon("data/imagenes/botonAbajo.png"));
		abajo.setEnabled(false);
		abajo.setPreferredSize(new Dimension(36, 36));
		abajo.addActionListener(this);
		abajo.setActionCommand(ABAJO);
		
		 add(new JLabel(""));
		 add(arriba);
		 add(new JLabel(""));
		 add(izquierda);
		 add(new JLabel(""));
		 add(derecha);
		 add(new JLabel(""));
		 add(abajo);
		 add(new JLabel(""));
		




	}
	public void inicializar (){
		abajo.setEnabled(true);
		arriba.setEnabled(true);
		derecha.setEnabled(true);
		izquierda.setEnabled(true);		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if (comando.equals(ARRIBA)){
			
				try {
					principal.mover(principal.darFilaJugador()-1, principal.darColumnaJugador());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

		}
		else if ( comando.equals(ABAJO)){
			
				try {
					principal.mover(principal.darFilaJugador()+1, principal.darColumnaJugador());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		else if (comando.equals(DERECHA)){
			
				try {
					principal.mover(principal.darFilaJugador(), principal.darColumnaJugador()+1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		}
		else if (comando.equals(IZQUIERDA)){
			
				try {
					principal.mover(principal.darFilaJugador(), principal.darColumnaJugador()-1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		

	}
	public void finJuego() {
		// TODO Auto-generated method stub
		abajo.setEnabled(false);
		arriba.setEnabled(false);
		derecha.setEnabled(false);
		izquierda.setEnabled(false);	
		
	}
	}
