package negocio.producto;

public class TransferZapatillas {

	private int ID;
	private int talla;
	private double precio;
	private String nombre;
	private String color;
	private String tipo;
	private boolean inStock;
	
	public TransferZapatillas(int talla, double precio, String nombre, 
								String color, String tipo, boolean inStock) {
		this.talla = talla;
		this.precio = precio;
		this.nombre = nombre;
		this.color = color;
		this.tipo = tipo;
		this.inStock = inStock;
	}
	
	public TransferZapatillas(int ID, int talla, double precio, String nombre, 
								String color, String tipo, boolean inStock) {
		this.ID = ID;
		this.talla = talla;
		this.precio = precio;
		this.nombre = nombre;
		this.color = color;
		this.tipo = tipo;
		this.inStock = inStock;
	}
	
	// GETTERS
	public int getID() {
		return ID;
	}
	
	public int getTalla() {
		return talla;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public boolean getInStock() {
		return inStock;
	}
}
