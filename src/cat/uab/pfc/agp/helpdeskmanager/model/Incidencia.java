package cat.uab.pfc.agp.helpdeskmanager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Incidencia {

	private long id;
	private Estat estat;
	private String assumpte;
	private Date data;
	private String tipus;
	private String creador;
	private String assignat;
	private List<Comentari> comentaris;

	public Incidencia(long id, String creador, Estat estat, String assumpte, Date data,
			String tipus) {
		super();
		this.id = id;
		this.creador = creador;
		this.estat = estat;
		this.assumpte = assumpte;
		this.data = data;
		this.tipus = tipus;
		this.comentaris = new ArrayList<Comentari>();
	}

	public long getId() {
		return id;
	}
	
	public String getCreador() {
		return creador;
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

	public Date getData() {
		return data;
	}

	public String getTipus() {
		return tipus;
	}

	public String getAssignat() {
		return assignat;
	}

	public void setAssignat(String assignat) {
		this.assignat = assignat;
	}

	public List<Comentari> getComentaris() {
		return comentaris;
	}

}
