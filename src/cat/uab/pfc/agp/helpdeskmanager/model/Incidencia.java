package cat.uab.pfc.agp.helpdeskmanager.model;

import java.util.Date;

public class Incidencia {

	private long id;
	private Estat estat;
	private String assumpte;
	private Date data;
	private String tipus;

	public Incidencia(long id, Estat estat, String assumpte, Date data, String tipus) {
		super();
		this.id = id;
		this.estat = estat;
		this.assumpte = assumpte;
		this.data = data;
		this.tipus = tipus;
	}

	public long getId() {
		return id;
	}

	public Estat getEstat() {
		return estat;
	}

	public String getAssumpte() {
		return assumpte;
	}

	public Date getData() {
		return data;
	}

	public String getTipus() {
		return tipus;
	}

}
