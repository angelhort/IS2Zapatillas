package presentacion.mostrar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentacion.vista.ComponentsBuilder;

public class VMostrarUno extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private String entidad = null;
	
	public VMostrarUno(String entidad){
		super("Foot World");
		this.entidad = entidad;
		this.setBounds(100, 100, 330, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x230.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initGUI(JFrame instance) {
		JLabel label = ComponentsBuilder.createLabel("Mostrar un " + entidad, 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 20));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		JLabel labelID = ComponentsBuilder.createLabel("ID " + entidad +":", 10, 100, 80, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 13));
		this.add(labelID);
		
		JTextField fieldID = ComponentsBuilder.createTextField(100, 100, 200, 20);
		this.add(fieldID);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(true);
				VMostrarUno.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 140, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		atrasButton.addActionListener(lAceptar);
	}
}
