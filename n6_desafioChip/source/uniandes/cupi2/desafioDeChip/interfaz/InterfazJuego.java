package uniandes.cupi2.desafioDeChip.interfaz;

import java.awt.*; 
import java.io.File;

import javax.swing.*;

import uniandes.cupi2.desafioDeChip.mundo.*;


public class InterfazJuego extends JFrame {
  private PanelOpciones panelOpciones;
  private PanelTablero panelTablero;
  private PanelImagen panelImagen;
  private PanelInformacion panelInformacion;
  private Mundo mundo;
  private File tablero;
  private int tipo;


  public InterfazJuego(){
    setSize(new Dimension(913, 694));
    setLayout (new BorderLayout());

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    panelImagen =new PanelImagen();
    add(panelImagen, BorderLayout.NORTH);

    panelOpciones =new PanelOpciones(this);
    add(panelOpciones, BorderLayout.WEST);

    panelTablero = new PanelTablero(this);
    System.out.println("lo inicializa");
    add(panelTablero, BorderLayout.CENTER);

    panelInformacion = new PanelInformacion(this);
    add(panelInformacion, BorderLayout.EAST);


  }
  
  public void tipo(File pFile)
  {
    if (pFile.getName().equals("desafio1.properties"))
      tipo = 1;
    else if (pFile.getName().equals("desafio2.properties"))
      tipo = 2;
    else if (pFile.getName().equals("desafio3.properties"))
      tipo = 3;
  }
  
  public void tamnho(int tipo)
  {
    if (tipo == 2)
    setSize(new Dimension(1061, 713));
    
    else if (tipo == 3)
    setSize(new Dimension(865, 688));  
    
    else
    setSize(new Dimension(913, 694));
      
  }

  public void pedirTablero(){  

    JFileChooser fc = new JFileChooser( "./data" );
    fc.setDialogTitle( "Seleccionar mapa" );
    int resultado = fc.showOpenDialog( this );
    if( resultado == JFileChooser.APPROVE_OPTION )
    {
      tablero = fc.getSelectedFile( );
      tipo(tablero);
      tamnho(tipo);
      try{
        mundo=new Mundo(tablero);
        
        panelTablero.inicializar();
        panelOpciones.inicializar();
        panelInformacion.inicializar();

      }
      catch (Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Formato inv�lido", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }


  public String darRutaImagenes(int estado){
    String rpta = "";
    if (estado==Casilla.OBSTACULO)
      rpta= "data/imagenes/muro.png";
    else if (estado==Casilla.VACIA)
      rpta= "data/imagenes/casilla_vacia.png";
    else if (estado==Casilla.LLAVE_AMARILLA)
      rpta = "data/imagenes/llave_amarilla.png";
    else if (estado==Casilla.LLAVE_AZUL)
      rpta= "data/imagenes/llave_azul.png";
    else if (estado==Casilla.LLAVE_ROJA)
      rpta= "data/imagenes/llave_roja.png";
    else if (estado==Casilla.PUERTA_AMARILLA)
      rpta= "data/imagenes/puerta_amarilla.png";
    else if (estado==Casilla.PUERTA_AZUL)
      rpta= "data/imagenes/puerta_azul.png";
    else if (estado==Casilla.PUERTA_ROJA)
      rpta = "data/imagenes/puerta_roja.png";
    else if (estado==Casilla.CHIP)
      rpta= "data/imagenes/chip.png";
    else if (estado==Casilla.SALIDA)
      rpta= "data/imagenes/puerta_salida.png";
    else if (estado==Casilla.PREMIO)
      rpta = "data/imagenes/trofeo.png";
    else if (estado==Casilla.JUGADOR)
      rpta = "data/imagenes/jugador.png";
    return rpta;
  }

  public void mover(int i, int j) {

try
{
    mundo.mover(i,j);
    panelTablero.actualizarMapa();
    panelInformacion.actualizar();
    //Actualizar numeros de visitas
}
catch(Exception e)
{
	if(e.getMessage().equals("No tiene la llave para abrir la puerta"))
	{
		JOptionPane.showMessageDialog( this, e.getMessage(), "Mover", JOptionPane.ERROR_MESSAGE);
	}
	else if(e.getMessage().equals("No ha recogido todos los chips"))
	{
		JOptionPane.showMessageDialog( this, e.getMessage(), "Mover", JOptionPane.ERROR_MESSAGE);
	}
	else if(e.getMessage().equals("¡Felicitaciones! Gano el juego"))
	{
		finJuego(e.getMessage());
	}
}



  }


  public int darFilas(){

    return mundo.darFilas();
  }
  public int darColumnas(){

    return mundo.darColumnas();
  }

  public int darChips()
  {
	  return mundo.darChips();
  }
  public int darAmarillas()
  {
	  return mundo.darAmarillas();
  }
  public int darAzules()
  {
	  return mundo.darAzules();
  }
  public int darRojas()
  {
	  return mundo.darRojas();
  }
  public int darMaxVisitas()
  {
	  return mundo.darMaxVisitas();
  }


  public int darEstado(int i, int j)
  {
    return mundo.darEstadoCasilla(i,j);
  }
  public int darFilaJugador()
  {
    return mundo.darFilaJugador();
  }
  public int darColumnaJugador()
  {
    return mundo.darColumnaJugador();
  }

  public void reiniciar() {
    try{

      mundo=new Mundo(tablero);
      panelTablero.inicializar();
      panelOpciones.inicializar();
      panelInformacion.inicializar();

    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
  public void Req1( )
  {
    String resultado = mundo.Req1( );

    JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
  }


  public void Req2( )
  {
    String resultado = mundo.Req2( );

    JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
  }
  public static void main(String[] args) 
  {
    InterfazJuego vent = new InterfazJuego( );
    vent.setVisible( true );
  }


  public void finJuego(String mensaje) {
		JOptionPane.showMessageDialog( this, mensaje, "Juego Terminado", JOptionPane.INFORMATION_MESSAGE);
		panelInformacion.finJuego();
		panelOpciones.finJuego();
		panelTablero.finJuego();

	}
  

 

}
