package arcade;

public class Arcade {
	
	private EstadoDeMaquina estado;
	private Pantalla pantalla;
	private Ranura ranura;

	public Arcade(Pantalla pantalla,Ranura ranura) {
		super();
		this.pantalla = pantalla;
		this.estado = new Inicial(this);
		this.ranura = ranura;
		}

	public EstadoDeMaquina getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoDeMaquina estado) {
		this.estado = estado;
	}
	
	public void encender(int cantFichas) {
		this.getEstado().ingresarFichas(cantFichas);
		this.getEstado().iniciar();
	}
	
	public void finalizar() {
		this.setEstado(new Inicial(this));
	}
	
	public Ranura getRanura() {
		return this.ranura ;
		
	}

	Pantalla getPantalla() {

		return this.pantalla;
	}
	
	
	
}
