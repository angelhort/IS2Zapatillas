package presentacion.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ComponentsBuilder {
	
	public static JLabel createLabel(String text, int x, int y, int width, int height, Color color, Font font) {
		JLabel label = new JLabel(text);
		
		label.setBounds(x, y, width, height);
		label.setForeground(color);
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(font);
		return label;
	}
	
	public static JButton createButton(String text, int x, int y, int width, int height, Font font) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		button.setFont(font);
		return button;
	}

	public static JButton createBackButton() {
		JButton button = new JButton();
		button.setBounds(40, 25, 60, 60);
		button.setIcon(new ImageIcon("resources/arrow-left-solid.png"));
		button.setBorderPainted(false); 
        button.setContentAreaFilled(false); 
        button.setFocusPainted(false); 
        button.setOpaque(false);
		return button;
	}
}
