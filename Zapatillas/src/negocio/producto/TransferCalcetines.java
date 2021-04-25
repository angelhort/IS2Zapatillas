package negocio.producto;

public class TransferCalcetines {

	private int ID;
	private int talla;
	private double precio;
	private String nombre;
	private String color;
	private String tejido;
	private boolean inStock;
	
	public TransferCalcetines(int talla, double precio, String nombre, 
								String color, String tejido, boolean inStock) {
		this.talla = talla;
		this.precio = precio;
		this.nombre = nombre;
		this.color = color;
		this.tejido = tejido;
		this.inStock = inStock;
	}
	
	public TransferCalcetines(int ID, int talla, double precio, String nombre, 
								String color, String tejido, boolean inStock) {
		this.ID = ID;
		this.talla = talla;
		this.precio = precio;
		this.nombre = nombre;
		this.color = color;
		this.tejido = tejido;
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
	
	public String getTejido() {
		return tejido;
	}
	
	public boolean getInStock() {
		return inStock;
	}
}
