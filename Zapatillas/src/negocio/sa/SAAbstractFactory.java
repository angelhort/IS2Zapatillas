package negocio.sa;

public abstract class SAAbstractFactory {
	
	private static SAAbstractFactory instance;
	
	public static SAAbstractFactory getInstance() {
		if (instance == null) instance = new SAFactoryImp();
		return instance;
	}
	
	public abstract Object getSA(int evento);

}
