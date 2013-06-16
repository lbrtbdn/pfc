package cat.uab.pfc.agp.helpdeskmanager.server;

import java.util.List;

import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;

public interface Servidor {

	public boolean login(String nomUsuari, String contrasenya);
	
	public Incidencia obtenirIncidencia(String nomUsuari, long id);
	
	public List<Incidencia> obtenirIncidencies();
	
	public boolean afegirComentari(long idIncidencia, String nomUsuari, String comentari);

	boolean afegirIncidencia(String assumpte, String tipus);

	
}
