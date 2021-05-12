package presentacion.trabajador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import negocio.trabajador.TransferTrabajador;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VMostrarTodosLosTrabajadores extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VMostrarTodosLosTrabajadores() {
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initGUI(List<TransferTrabajador> trabajadores) {
		JLabel label = ComponentsBuilder.createLabel("Mostrar todos los Trabajadores", 300, 20, 400, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarTodosLosTrabajadores.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUITrabajador, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JTable table = ComponentsBuilder.creteTable(trabajadores.size() + 1, 5, 50, 115, 900, 288);
		table.setValueAt("ID", 0, 0);	
		table.setValueAt("Nombre", 0, 1);		
		table.setValueAt("DNI", 0, 2);		
		table.setValueAt("Telefono", 0, 3);		
		table.setValueAt("Activo", 0, 4);

		int i = 1;
		for(TransferTrabajador t: trabajadores) {
			table.setValueAt(t.getID(), i, 0);
			table.setValueAt(t.getNombre(), i, 1);
			table.setValueAt(t.getDNI(), i, 2);
			table.setValueAt(t.getTelefono(), i, 3);
			table.setValueAt(t.getActivo() ? "SI" : "NO", i, 4);
			i++;
		}
		
		table.setDefaultEditor(Object.class, null);
	
		this.add(table);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.MostrarTodosLosTrabajadores:
			initGUI((List<TransferTrabajador>) datos);
			this.setVisible(true);
			break;
		}
	}
}
