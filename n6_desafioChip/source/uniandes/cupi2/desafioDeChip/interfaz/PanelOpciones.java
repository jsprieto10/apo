package uniandes.cupi2.desafioDeChip.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.desafioDeChip.interfaz.InterfazJuego;

public class PanelOpciones extends JPanel implements ActionListener {
	public final static  String CARGAR ="cargar";
	public final static  String REINICIAR ="reiniciar";
	public final static  String FILA_VISITADA ="fila";
	public final static  String COLUMNA_VISITADA ="columna";
	public final static  String VECINOS ="vecinos";
	public final static  String OPCION1 ="op1";
	public final static  String OPCION2 ="op2";

	private JButton cargar;
	private JButton reiniciar;
	private JButton filaVisitada;
	private JButton columnaVisitada;
	private JButton vecinos;
	private JButton opcion1;
	private JButton opcion2;
	private InterfazJuego principal;
	public PanelOpciones(InterfazJuego v)
	{

		principal = v;

		TitledBorder border = BorderFactory.createTitledBorder( "Opciones");
		border.setTitleColor( Color.BLACK );
		setBorder( border );
		setLayout(new GridLayout(7,1));
		setPreferredSize(new Dimension(180, 720));

		cargar = new JButton ("Cargar");
		cargar.setActionCommand(CARGAR);
		cargar.addActionListener(this);
		add(cargar);

		reiniciar = new JButton ("Reiniciar");
		reiniciar.setEnabled(false);
		reiniciar.addActionListener(this);
		reiniciar.setActionCommand(REINICIAR);
		add(reiniciar);

		filaVisitada = new JButton ("Fila mas visitada");
		filaVisitada.setEnabled(false);
		filaVisitada.setActionCommand(FILA_VISITADA);
		filaVisitada.addActionListener(this);
		add(filaVisitada);

		columnaVisitada = new JButton ("Columna mas visitada");
		columnaVisitada.setEnabled(false);
		columnaVisitada.setActionCommand(COLUMNA_VISITADA);
		columnaVisitada.addActionListener(this);
		add(columnaVisitada);

		vecinos = new JButton ("Visitas vecinos");
		vecinos.setEnabled(false);
		vecinos.setActionCommand(VECINOS);
		vecinos.addActionListener(this);
		add(vecinos);

		opcion1 = new JButton ("Opción 1");
		opcion1.setActionCommand(OPCION1);
		opcion1.addActionListener(this);
		opcion1.setEnabled(false);
		add(opcion1);

		opcion2 = new JButton ("Opción 2");
		opcion2.setActionCommand(OPCION2);
		opcion2.addActionListener(this);
		opcion2.setEnabled(false);
		add(opcion2);


	}
	
	public void inicializar(){
		reiniciar.setEnabled(true);
		filaVisitada.setEnabled(true);
		columnaVisitada.setEnabled(true);
		vecinos.setEnabled(true);
		opcion1.setEnabled(true);
		opcion2.setEnabled(true);
	}
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand( ); 
		if ( comando.equals( CARGAR )) {
			principal.pedirTablero();
		
		}
		else if ( comando.equals( REINICIAR )) {
			principal.reiniciar();
		}

		else if ( comando.equals( OPCION1 )) {
			principal.Req1();
		}
		else if ( comando.equals( OPCION2 )) {
			principal.Req2();
		}
		else if ( comando.equals( COLUMNA_VISITADA )) {
			principal.columnaMasVisita();
		}
		else if ( comando.equals( FILA_VISITADA)) {
			principal.filaMasVisita();
		}
		else if ( comando.equals( VECINOS)) {
			principal.darVecinos();
			}
	}

	public void finJuego() {
		
		filaVisitada.setEnabled(false);
		columnaVisitada.setEnabled(false);
		vecinos.setEnabled(false);
		opcion1.setEnabled(false);
		opcion2.setEnabled(false);
	}
	

	}



