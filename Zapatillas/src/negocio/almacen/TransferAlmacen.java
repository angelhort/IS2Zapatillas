package negocio.almacen;

public class TransferAlmacen {
	
	private int ID;
	private int telefono;
	private int capacidad;
	private String direccion;
	
	public TransferAlmacen(int telefono, int capacidad, String direccion) {
		this.telefono = telefono;
		this.capacidad = capacidad;
		this.direccion = direccion;
	}
	
	public TransferAlmacen(int ID, int telefono, int capacidad, String direccion) {
		this.ID = ID;
		this.telefono = telefono;
		this.capacidad = capacidad;
		this.direccion = direccion;
	}
	
	// GETTERS
	public int getID() {
		return ID;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public String getDireccion() {
		return direccion;
	}
 	
}
