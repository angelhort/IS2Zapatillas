package negocio.producto;

public class TransferCalcetines {

	private int ID;
	private int talla;
	private double precio;
	private String nombre;
	private String color;
	private String tejido;
	private int stock;
	private int almacen;
	private int marca;
	private boolean activo;
	
	public TransferCalcetines(int talla, double precio, String nombre, String color, 
								String tipo, int stock, int almacen, int marca) {
		this.talla = talla;
		this.precio = precio;
		this.nombre = nombre;
		this.color = color;
		this.tejido = tipo;
		this.stock = stock;
		this.almacen = almacen;
		this.marca = marca;
	}
	
	public TransferCalcetines(int ID, int talla, double precio, String nombre, String color, 
								String tipo, int stock, int almacen, int marca, boolean activo) {
		this.ID = ID;
		this.talla = talla;
		this.precio = precio;
		this.nombre = nombre;
		this.color = color;
		this.tejido = tipo;
		this.stock = stock;
		this.almacen = almacen;
		this.marca = marca;
		this.activo = activo;
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
	
	public int getStock() {
		return stock;
	}
	
	public int getAlmacen() {
		return almacen;
	}
	
	public int getMarca() {
		return marca;
	}
	
	public boolean getActivo() {
		return activo;
	}
}
