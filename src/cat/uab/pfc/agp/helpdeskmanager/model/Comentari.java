package cat.uab.pfc.agp.helpdeskmanager.model;

public class Comentari {

	private String nomUsuari;
	private String comentari;

	public Comentari(String nomUsuari, String comentari) {
		super();
		this.nomUsuari = nomUsuari;
		this.comentari = comentari;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public String getComentari() {
		return comentari;
	}

}
