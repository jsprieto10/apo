package uniandes.cupi2.desafioDeChip.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelInformacion  extends JPanel implements ActionListener{
	private PanelControles controles;
	private PanelObjetos objetos;
	private InterfazJuego principal;
	
	public PanelInformacion(InterfazJuego v)
	{
		principal=v;
		setLayout(new GridLayout(2,1));
		
		controles=new PanelControles(v);
		add(controles);
		
		objetos=new PanelObjetos(v);
		add(objetos);
	}
	public void inicializar()
	{
		controles.inicializar();
		objetos.actualizar();
	}
	
	public void actualizar()
	{
		objetos.actualizar();
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void finJuego() {
		// TODO Auto-generated method stub
		controles.finJuego();
		
		
	}

}
