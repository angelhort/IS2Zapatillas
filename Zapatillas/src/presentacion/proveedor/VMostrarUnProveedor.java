package presentacion.proveedor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.proveedor.TransferProveedor;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VMostrarUnProveedor extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VMostrarUnProveedor(){
		super("Foot World");
		this.setBounds(100, 100, 1000, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/1000x230.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initGUI(TransferProveedor proveedor) {
		JLabel label = ComponentsBuilder.createLabel("Mostrar Cliente", 405, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarUnProveedor.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIProveedor, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JTable table = ComponentsBuilder.creteTable(2, 5, 50, 115, 900, 32);
		
		table.setValueAt("ID", 0, 0);
		table.setValueAt(proveedor.getID(), 1, 0);
		
		table.setValueAt("Nombre", 0, 1);
		table.setValueAt(proveedor.getNombre(), 1, 1);
		
		table.setValueAt("Dirección", 0, 2);
		table.setValueAt(proveedor.getDireccion(), 1, 2);
		
		table.setValueAt("Teléfono", 0, 3);
		table.setValueAt(proveedor.getTelefono(), 1, 3);
		
		table.setValueAt("Activo", 0, 4);
		table.setValueAt(proveedor.getActivo() ? "SI" : "NO", 1, 4);
	
		table.setDefaultEditor(Object.class, null);

		this.add(table);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.MostrarUnProveedor:
			initGUI((TransferProveedor) datos);
			this.setVisible(true);
			break;
		}
	}

}
