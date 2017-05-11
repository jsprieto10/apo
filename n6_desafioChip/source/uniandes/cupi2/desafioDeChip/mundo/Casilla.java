package uniandes.cupi2.desafioDeChip.mundo;

public class Casilla {
	public final static int VACIA = 0;
	public final static int OBSTACULO= 1;
	public final static int LLAVE_ROJA =2;
	public final static int LLAVE_AZUL =3;
	public final static int LLAVE_AMARILLA =4;
	public final static int PUERTA_ROJA =5;
	public final static int PUERTA_AZUL =6;
	public final static int PUERTA_AMARILLA = 7;
	public final static int SALIDA =8;
	public final static int CHIP =9;
	public final static int PREMIO = 10;
	public final static int JUGADOR = 11;
	private int estado;
	private int columna;
	private int fila;
	private int visitas;

	public Casilla (int pEstado, int pFila, int pColumna){
		estado = pEstado;
		columna = pColumna;
		fila = pFila;
		visitas = 0;
	}
	public int darEstado()
	{
		return estado; 
	}
	public void agregarVisitas(){
		visitas++;		
	}
	public int darVisitas(){
		return visitas;
	}
	public void reiniciar(){
		visitas = 0;
	}
	public int darFila() {
		return fila;
	}
	public int darColumna(){
		return columna;
	}
	public void cambiarEstado(int pEstado){
		estado=pEstado;
	}
	
}
