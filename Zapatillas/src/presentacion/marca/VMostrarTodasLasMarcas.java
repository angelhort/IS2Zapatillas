package presentacion.marca;

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

import negocio.marca.TransferMarca;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VMostrarTodasLasMarcas extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VMostrarTodasLasMarcas() {
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initGUI(List<TransferMarca> marcas) {
		JLabel label = ComponentsBuilder.createLabel("Mostrar todas las Marcas", 325, 20, 350, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarTodasLasMarcas.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIMarca, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JTable table = ComponentsBuilder.creteTable(marcas.size() + 1, 3, 50, 115, 900, 288);
		table.setValueAt("ID", 0, 0);	
		table.setValueAt("Nombre", 0, 1);		
		table.setValueAt("Activo", 0, 2);

		int i = 1;
		for(TransferMarca t: marcas) {
			table.setValueAt(t.getID(), i, 0);
			table.setValueAt(t.getNombre(), i, 1);
			table.setValueAt(t.getActivo() ? "SI" : "NO", i, 2);
			i++;
		}
		
		table.setDefaultEditor(Object.class, null);
	
		this.add(table);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.MostrarTodasLasMarcas:
			initGUI((List<TransferMarca>) datos);
			this.setVisible(true);
			break;
		}
	}


}
