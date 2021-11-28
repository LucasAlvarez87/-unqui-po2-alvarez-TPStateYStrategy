package arcade;

public class Inicial extends EstadoDeMaquina {

	public Inicial(Arcade arcade) {
		super(arcade);
	
	}
	
	@Override
	public void ingresarFichas(int cantFichas) {
		this.getArcade().getRanura().abrir();
		this.getArcade().getPantalla().mostrar("Ingresar fichas");
		this.getArcade().getRanura().cerrar();
		if (cantFichas == 1 ) {
			this.getArcade().setEstado(new PartidaParaUno(this.getArcade()));
		}
		else if(cantFichas == 2) {
			this.getArcade().setEstado(new PartidaParaDos(this.getArcade()));
		}
		else {
			this.getArcade().getPantalla().mostrar("Cantidad de fichas invalidas");
			this.getArcade().getRanura().devolver(cantFichas);
		}
		
	}

	@Override
	public void iniciar() {
		// Al apretar inciar sin poner las fichas no hace nada
		
	}
	
	

}
