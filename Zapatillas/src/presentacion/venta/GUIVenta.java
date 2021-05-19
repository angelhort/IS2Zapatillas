package presentacion.venta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import negocio.venta.TransferVenta;
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
	}
		
	private void initGUI(TransferVenta venta) {
		JLabel label = ComponentsBuilder.createLabel("Venta", 250, 30, 500, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton buttonAniadir = ComponentsBuilder.createButton("<html>Añadir producto<br>a venta</html>", 100, 200, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAniadir);
		
		JPanel panelAniadir = new JPanel(); 
		panelAniadir.setLayout(new FlowLayout());
		panelAniadir.add(new JLabel("ID Producto: "));
		
		JTextField idAniadir = new JTextField();
		idAniadir.setPreferredSize(new Dimension(50,20));
		panelAniadir.add(idAniadir);
		
		JSpinner spinnerUnidades = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		panelAniadir.add(spinnerUnidades);
		
		ActionListener lAniadir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"AÑADIR","CANCELAR"};
				int n = JOptionPane.showOptionDialog(GUIVenta.this, panelAniadir, "Añadir producto",
						JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION, null, options, options[1]);
				
				if (n==JOptionPane.YES_OPTION) {
					
				}
			}
			
		};
		
		buttonAniadir.addActionListener(lAniadir);
		
		JButton buttoneliminar = ComponentsBuilder.createButton("<html>Eliminar producto<br>de venta</html>", 407, 200, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttoneliminar);
		
		ActionListener leliminar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
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
			initGUI((TransferVenta) datos);
			this.setVisible(true);
			break;
		}
	}

}
