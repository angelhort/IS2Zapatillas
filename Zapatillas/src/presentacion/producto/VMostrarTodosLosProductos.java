package presentacion.producto;

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

import negocio.producto.TransferCalcetines;
import negocio.producto.TransferProducto;
import negocio.producto.TransferZapatillas;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VMostrarTodosLosProductos extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;

	public VMostrarTodosLosProductos() {
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initGUI(List<TransferProducto> productos) {
		JLabel label = ComponentsBuilder.createLabel("Mostrar todos los Productos", 325, 20, 350, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarTodosLosProductos.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIProducto, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JTable table = ComponentsBuilder.creteTable(productos.size() + 1, 11, 50, 115, 900, 288);
		table.setValueAt("ID", 0, 0);	
		table.setValueAt("Nombre", 0, 1);		
		table.setValueAt("Tipo", 0, 2);		
		table.setValueAt("Stock", 0, 3);		
		table.setValueAt("Precio", 0, 4);
		table.setValueAt("Talla", 0, 5);
		table.setValueAt("Color", 0, 6);
		table.setValueAt("Tejido/Tipo", 0, 7);
		table.setValueAt("Marca", 0, 8);
		table.setValueAt("Almacen", 0, 9);
		table.setValueAt("Activo", 0, 10);

		int i = 1;
		for(TransferProducto t: productos) {
			table.setValueAt(t.getID(), i, 0);
			table.setValueAt(t.getNombre(), i, 1);
			table.setValueAt(t.getClass() == TransferZapatillas.class ? "Zapatillas" : "Calcetines", i, 2);
			table.setValueAt(t.getStock(), i, 3);
			table.setValueAt(t.getPrecio(), i, 4);
			table.setValueAt(t.getTalla(), i, 5);
			table.setValueAt(t.getColor(), i, 6);
			table.setValueAt(t.getClass() == TransferZapatillas.class ? ((TransferZapatillas) t).getTipo() : ((TransferCalcetines) t).getTejido(), i, 7);
			table.setValueAt(t.getMarca(), i, 8);
			table.setValueAt(t.getAlmacen(), i, 9);
			table.setValueAt(t.getActivo() ? "SI" : "NO", i, 10);
			i++;
		}
	
		table.setDefaultEditor(Object.class, null);

		this.add(table);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.MostrarTodosLosProductos:
			initGUI((List<TransferProducto>) datos);
			this.setVisible(true);
			break;
		}
	}

}
