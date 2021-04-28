package negocio.proveedor;

public class TransferProveedor {
	
	private int ID;
	private int telefono;
	private String direccion;
	private String nombre;
	private boolean activo;
	
	public TransferProveedor(int telefono, String direccion, String nombre) {
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
	}
	
	public TransferProveedor(int ID, int telefono, String direccion, String nombre, boolean activo) {
		this.ID = ID;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
		this.activo = activo;
	}
	
	// GETTERS
	public int getID() {
		return ID;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean getActivo() {
		return activo;
	}
}
