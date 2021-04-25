package negocio.marca;

public class TransferMarca {
	
	private int ID;
	private String nombre;
	
	public TransferMarca(String nombre) {
		this.nombre = nombre;
	}
	
	public TransferMarca(int ID, String nombre) {
		this.ID = ID;
		this.nombre = nombre;
	}
	
	// GETTERS
	public int getID() {
		return ID;
	}
	
	public String getNombre() {
		return nombre;
	}
 	
}
