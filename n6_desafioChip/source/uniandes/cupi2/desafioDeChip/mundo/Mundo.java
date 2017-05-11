package uniandes.cupi2.desafioDeChip.mundo;

import java.io.*;  
import java.util.*;

import uniandes.cupi2.desafioDeChip.mundo.Casilla;




public class Mundo
{


	private int filas;
	private int columnas;

	private Casilla [][] tablero;

	private int filaJugador;
	private int columnaJugador;
	private int chips;
	private  int llaveAmarilla;
	private int llaveRoja;
	private int llaveAzul;
	private int cantidadVisitas;
	private Properties datos;


	public Mundo (File arch) throws Exception{
		datos = cargarTablero(arch);
		llaveAmarilla=0;
		llaveRoja=0;
		llaveAzul=0;
		inicializarTablero(datos);

	}

	public Properties cargarTablero( File arch)throws Exception{

		Properties pDatos = new Properties( );
		FileInputStream in = new FileInputStream( arch );

		try {
			pDatos.load( in );
			in.close( );
		}
		catch( Exception e ) {
			throw new Exception( "Formato inv�lido" );
		}
		return pDatos;
	}

	public  void inicializarTablero(Properties datos){
		String numeroFilas = datos.getProperty("desafio.filas");
		filas = Integer.parseInt(numeroFilas);  

		String numeroColumnas= datos.getProperty("desafio.columnas");
		columnas = Integer.parseInt(numeroColumnas);  

		String fila= datos.getProperty("desafio.jugador.posX");
		filaJugador = Integer.parseInt(fila);

		String columna= datos.getProperty("desafio.jugador.posY");
		columnaJugador = Integer.parseInt(columna);

		String nChips= datos.getProperty("desafio.chips");
		chips = Integer.parseInt(nChips);

		String visitas= datos.getProperty("desafio.cantidadMaximaVisitas");
		cantidadVisitas = Integer.parseInt(visitas);

		tablero = new Casilla [filas][columnas];

		for (int i = 0; i<filas; i++){
			for(int j = 0; j<columnas; j++){
				String[] filaActual = datos.getProperty("desafio.fila"+i).split("-");
				int estado = Integer.parseInt(filaActual[j]);
				tablero[i][j]= new Casilla (estado, i, j );
			}
		}
		tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.JUGADOR);
	} 



	public int darEstadoCasilla(int i, int j){
		int rpta = 0;
		Casilla actual = tablero[i][j];
		rpta = actual.darEstado();
		return rpta;
	}




	public int darFilas(){
		return filas;
	}

	public int darColumnas(){
		return columnas;
	}
	public Casilla[][] darTablero()
	{
		return tablero;
	}

	public int darFilaJugador()
	{
		return filaJugador;
	}
	public int darColumnaJugador()
	{
		return columnaJugador;
	}
	public int darChips()
	{
		return chips;
	}
	public int darAmarillas()
	{
		return llaveAmarilla;
	}
	public int darAzules()
	{
		return llaveAzul;
	}
	public int darRojas()
	{
		return llaveRoja;
	}
	public int darMaxVisitas()
	{
		return cantidadVisitas;
	}

	public void mover( int i, int j) throws Exception
	{

		if (tablero[i][j].darEstado()==(Casilla.VACIA))
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;

		}
		else if (tablero[i][j].darEstado()==Casilla.CHIP)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			chips--;
		}
		else if (tablero[i][j].darEstado()==Casilla.SALIDA && chips == 0)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
		}
		else if (tablero[i][j].darEstado()==Casilla.SALIDA && chips != 0)
		{
			throw new Exception ("No ha recogido todos los chips");
		}
		else if (tablero[i][j].darEstado()==Casilla.PREMIO)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			throw new Exception ("¡Felicitaciones! Gano el juego");
		}
		else if (tablero[i][j].darEstado()==Casilla.LLAVE_AMARILLA)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			llaveAmarilla++;
		}
		else if (tablero[i][j].darEstado()==Casilla.PUERTA_AMARILLA && llaveAmarilla >= 1)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			llaveAmarilla--;
		}
		else if (tablero[i][j].darEstado()==Casilla.PUERTA_AMARILLA && llaveAmarilla == 0)
		{
			throw new Exception ("No tiene la llave para abrir la puerta");
		}

		else if (tablero[i][j].darEstado()==Casilla.LLAVE_ROJA)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			llaveRoja++;
		}
		else if (tablero[i][j].darEstado()==Casilla.PUERTA_ROJA && llaveRoja >= 1)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			llaveRoja--;
		}
		else if (tablero[i][j].darEstado()==Casilla.PUERTA_ROJA && llaveRoja == 0)
		{
			throw new Exception ("No tiene la llave para abrir la puerta");
		}
		else if (tablero[i][j].darEstado()==Casilla.LLAVE_AZUL)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			llaveAzul++;
		}
		else if (tablero[i][j].darEstado()==Casilla.PUERTA_AZUL && llaveAzul >= 1)
		{
			if(tablero[filaJugador][columnaJugador].darVisitas()>=cantidadVisitas)
			{
				tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.OBSTACULO);
			}
			else
			{
			tablero[filaJugador][columnaJugador].cambiarEstado(Casilla.VACIA);
			}
			tablero[i][j].cambiarEstado(Casilla.JUGADOR);
			tablero[i][j].agregarVisitas();
			filaJugador = i;
			columnaJugador = j;
			llaveAzul--;
		}
		else if (tablero[i][j].darEstado()==Casilla.PUERTA_AZUL && llaveAzul == 0)
		{
			throw new Exception ("No tiene la llave para abrir la puerta");
		}
	}
	
	public String ColumnaMasVisitada()
	{
		int columna = 0;
		int sumaParcial = 0;
		int sumaMayor = 0;
		for (int j = 0; j < filas; j++)
		{
			sumaParcial = 0;
			for (int i = 0; i < filas; i++)
			{
				sumaParcial += tablero[i][j].darVisitas();
			}
			if (sumaParcial > sumaMayor)
			{
				sumaMayor = sumaParcial;
				columna = j;
			}
		}
		return "la columna más visita es: "+columna;
	}
	
	public String FilaMasVisitada()
	{
		int fila = 0;
		int sumaParcial = 0;
		int sumaMayor = 0;
		for (int i = 0; i < filas; i++)
		{
			sumaParcial = 0;
			for (int j = 0; j < filas; j++)
			{
				sumaParcial += tablero[i][j].darVisitas();
			}
			if (sumaParcial > sumaMayor)
			{
				sumaMayor = sumaParcial;
				fila = i;
			}
		}
		return "la fila más visitada es: "+fila;
	}

	

	public String Req1( )
	{
		return "Respuesta 1";
	}

	public String Req2( )
	{
		return "Respuesta 2";
	}

}
