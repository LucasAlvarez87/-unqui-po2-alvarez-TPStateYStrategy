package arcade;

public abstract class EstadoDeMaquina {
	
	private Arcade arcade;
	
	public EstadoDeMaquina(Arcade arcade) {
		super();
		this.arcade = arcade;
	}

	public Arcade getArcade() {
		return this.arcade;
	}

	public abstract void ingresarFichas(int cantFichas);
	
	public abstract void iniciar();
	
	public void finalizar() {
		this.getArcade().setEstado(new Inicial(this.getArcade()));
	}
	
}
