package negocio.trabajador;

public class TransferTrabajador {

	private int ID;
	private int telefono;
	private String DNI;
	private String nombre;
	
	public TransferTrabajador(int telefono, String DNI, String nombre) {
		this.telefono = telefono;
		this.DNI = DNI;
		this.nombre = nombre;
	}

	public TransferTrabajador(int ID, int telefono, String DNI, String nombre) {
		this.ID = ID;
		this.telefono = telefono;
		this.DNI = DNI;
		this.nombre = nombre;
	}
	
	// GETTERS
	public int getID() {
		return ID;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
