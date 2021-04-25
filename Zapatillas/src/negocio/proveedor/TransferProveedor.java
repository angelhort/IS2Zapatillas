package negocio.proveedor;

public class TransferProveedor {
	
	private int ID;
	private int telefono;
	private String direccion;
	private String nombre;
	
	public TransferProveedor(int telefono, String direccion, String nombre) {
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
	}
	
	public TransferProveedor(int ID, int telefono, String direccion, String nombre) {
		this.ID = ID;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nombre = nombre;
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
}
