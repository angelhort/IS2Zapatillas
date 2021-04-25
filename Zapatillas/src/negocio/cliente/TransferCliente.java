package negocio.cliente;

public class TransferCliente {
	private String nombre;
	private boolean socio;
	private String DNI;
	private int ID;
	
	public TransferCliente(String nombre, boolean socio, String DNI) {
		this.nombre = nombre;
		this.socio = socio;
		this.DNI = DNI;
	}
	
	public TransferCliente(int ID, String nombre, boolean socio, String DNI) {
		this.ID = ID;
		this.nombre = nombre;
		this.socio = socio;
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isSocio() {
		return socio;
	}

	public String getDNI() {
		return DNI;
	}

	public int getID() {
		return ID;
	}
}
