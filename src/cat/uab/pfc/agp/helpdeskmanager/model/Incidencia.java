package cat.uab.pfc.agp.helpdeskmanager.model;

import java.util.Date;

public class Incidencia {

	private Estat estat;
	private String assumpte;
	private Date data;
	private String tipus;

	// FIXME BORRAME Soy para pruebas
	public Incidencia(Estat estat, String assumpte, Date data, String tipus) {
		super();
		this.estat = estat;
		this.assumpte = assumpte;
		this.data = data;
		this.tipus = tipus;
	}

	public Estat getEstat() {
		return estat;
	}

	public void setEstat(Estat estat) {
		this.estat = estat;
	}

	public String getAssumpte() {
		return assumpte;
	}

	public void setAssumpte(String assumpte) {
		this.assumpte = assumpte;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

}
