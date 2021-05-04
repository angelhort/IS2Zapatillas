package presentacion.marca;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.marca.TransferMarca;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VModificarMarca extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VModificarMarca() {
		super("Foot World");
		this.setBounds(100, 100, 330, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x230.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initGUI(TransferMarca marca) {
		this.setVisible(true);
		JLabel labelMarca = ComponentsBuilder.createLabel("Modificar Marca", 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(labelMarca);
		
		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre:", 10, 100, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelNombre);
		
		JTextField fieldNombre = ComponentsBuilder.createTextField(80, 100, 220, 20);
		fieldNombre.setText(marca.getNombre());
		this.add(fieldNombre);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.MostrarGUIMarca, null);
				VModificarMarca.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 140, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VModificarMarca.this.dispose();
				Controller.getInstance().action(Evento.ModificarMarca, new TransferMarca(marca.getID(), fieldNombre.getText(), marca.getActivo()));
				Controller.getInstance().action(Evento.MostrarGUIMarca, null);
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
			case Evento.MostrarModificarMarca:
				initGUI((TransferMarca) datos);	
				break;
				
			case Evento.MarcaOK:
				JOptionPane.showMessageDialog(this,"La marca se modifico con exito", "Modificar Marca", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case Evento.MarcaKO:
				if(datos == null)
					JOptionPane.showMessageDialog(this,"La marca no existe", "ERROR Modificar Marca", JOptionPane.ERROR_MESSAGE);
				else 
					JOptionPane.showMessageDialog(this,"Los datos fueron mal introducidos", "ERROR Modificar Marca", JOptionPane.ERROR_MESSAGE);
				
				Controller.getInstance().action(Evento.MostrarGUIMarca, null);
				break;
		}
	}
}
