package uniandes.cupi2.desafioDeChip.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



public class PanelObjetos extends JPanel  {

  private InterfazJuego principal;
  private JLabel chips;
  private JLabel casillas;
  private JLabel amarillas;
  private JLabel azules;
  private JLabel rojas;

  
  public PanelObjetos(InterfazJuego v)
  {
	  principal = v;
	  inicializar();
  }
  
  public void inicializar()
  {
	    chips = new JLabel("0");
	    casillas = new JLabel("0");
	    amarillas = new JLabel("0");
	    azules = new JLabel("0");
	    rojas = new JLabel("0");
	    
	    
	    setLayout(new GridLayout(5, 4));
	    setPreferredSize(new Dimension(210, 360));
	    TitledBorder border = BorderFactory.createTitledBorder( "Informacion");
	    border.setTitleColor( Color.BLACK );
	    setBorder( border );
	    
	    add(new JLabel(""));
	    JLabel lblImagen = new JLabel();
	    ImageIcon chip = new ImageIcon( "data/imagenes/etiquetaChip.png" );
	    lblImagen.setIcon(chip);
	    add(lblImagen);
	    add(chips);
	    add(new JLabel(""));
	    add(new JLabel(""));
	    JLabel lblCasilla = new JLabel();
	    ImageIcon casilla = new ImageIcon( "data/imagenes/etiqueta_casilla.png" );
	    lblCasilla.setIcon(casilla);
	    add(lblCasilla);
	    add(casillas);
	    add(new JLabel(""));
	    add(new JLabel(""));
	    JLabel lblAmarilla = new JLabel();
	    ImageIcon amarilla = new ImageIcon( "data/imagenes/etiqueta_llave_amarilla.png" );
	    lblAmarilla.setIcon(amarilla);
	    add(lblAmarilla);
	    add(amarillas);
	    add(new JLabel(""));
	    add(new JLabel(""));
	    JLabel lblRoja = new JLabel();
	    ImageIcon roja = new ImageIcon( "data/imagenes/etiqueta_llave_roja.png" );
	    lblRoja.setIcon(roja);
	    add(lblRoja);
	    add(rojas);
	    add(new JLabel(""));
	    add(new JLabel(""));
	    JLabel lblAzul = new JLabel();
	    ImageIcon azul = new ImageIcon( "data/imagenes/etiqueta_llave_azul.png" );
	    lblAzul.setIcon(azul);
	    add(lblAzul);
	    add(azules);
	    add(new JLabel(""));
  }
  
  public void actualizar()
  {
	  chips.setText(""+principal.darChips());
	  casillas.setText(""+principal.darMaxVisitas());
	  amarillas.setText(""+principal.darAmarillas());
	  azules.setText(""+principal.darAzules());
	  rojas.setText(""+principal.darRojas());
  }



}
