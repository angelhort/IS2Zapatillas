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
	
	public TransferCliente(String nombre, boolean socio, String DNI, int ID) {
		this.nombre = nombre;
		this.socio = socio;
		this.DNI = DNI;
		this.ID = ID;
	}
}
