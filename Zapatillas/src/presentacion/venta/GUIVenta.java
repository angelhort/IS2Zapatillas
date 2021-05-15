package presentacion.venta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class GUIVenta extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;

	public GUIVenta() {
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
		
	private void initGUI() {
		JLabel label = ComponentsBuilder.createLabel("Venta", 250, 30, 500, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton buttonAniadir = ComponentsBuilder.createButton("<html>Añadir producto<br>a venta</html>", 100, 200, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAniadir);
		
		ActionListener lAniadir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVenta.this.dispose();
			}
			
		};
		
		buttonAniadir.addActionListener(lAniadir);
		
		JButton buttoneliminar = ComponentsBuilder.createButton("<html>Eliminar producto<br>de venta</html>", 407, 200, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttoneliminar);
		
		ActionListener leliminar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVenta.this.dispose();
			}
			
		};
		
		buttoneliminar.addActionListener(leliminar);
		
		JButton buttonCerrarVenta = ComponentsBuilder.createButton("Cerrar venta", 715, 200, 185, 100, new Font("Serif", Font.PLAIN, 17));
		this.add(buttonCerrarVenta);
		
		ActionListener lCerrarVenta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVenta.this.dispose();
			}
			
		};
		
		buttonCerrarVenta.addActionListener(lCerrarVenta);
		JButton atrasButton = ComponentsBuilder.createBackButton();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Salir","Cancelar"};
				int n = JOptionPane.showOptionDialog(null,"¿Desea salir de la venta? Se perderan los datos", "Atrás",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
				if (n==JOptionPane.YES_OPTION) {
					GUIVenta.this.dispose();
					Controller.getInstance().action(Evento.MostrarGUIPrincipal, null);					
				}
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
			case Evento.MostrarGUIVenta:
			this.setVisible(true);
			break;
		}
	}

}
