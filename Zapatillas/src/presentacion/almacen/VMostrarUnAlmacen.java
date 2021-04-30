package presentacion.almacen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import negocio.almacen.TransferAlmacen;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VMostrarUnAlmacen extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VMostrarUnAlmacen () {
		super("Foot World");
		this.setBounds(100, 100, 1000, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/1000x230.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initGUI(TransferAlmacen almacen) {
		JLabel label = ComponentsBuilder.createLabel("Mostrar Almacen", 355, 20, 290, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarUnAlmacen.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIAlmacen, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JTable table = ComponentsBuilder.creteTable(2, 5, 50, 115, 900, 32);
		table.setValueAt("ID", 0, 0);
		table.setValueAt(almacen.getID(), 1, 0);
		
		table.setValueAt("Direccion", 0, 1);
		table.setValueAt(almacen.getDireccion(), 1, 1);
		
		table.setValueAt("Telefono", 0, 2);
		table.setValueAt(almacen.getTelefono(), 1, 2);
		
		table.setValueAt("Capacidad", 0, 3);
		table.setValueAt(almacen.getCapacidad(), 1, 3);
		
		table.setValueAt("Activo", 0, 4);
		table.setValueAt(almacen.getActivo() ? "SI" : "NO", 1, 4);
	
		this.add(table);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.MostrarUnAlmacen:
			initGUI((TransferAlmacen) datos);
			this.setVisible(true);
			break;
		}
	}


}
