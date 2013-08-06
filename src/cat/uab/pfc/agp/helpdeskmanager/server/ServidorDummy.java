package cat.uab.pfc.agp.helpdeskmanager.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cat.uab.pfc.agp.helpdeskmanager.model.Comentari;
import cat.uab.pfc.agp.helpdeskmanager.model.Estat;
import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;

public class ServidorDummy implements Servidor {

	private static final String PASSWORD = "1234";

	private static final String USER_CLIENT = "Client";

	private static final String USER_HELP_DESK = "HelpDesk";

	private List<Incidencia> incidencies;

	public ServidorDummy() {
		incidencies = new ArrayList<Incidencia>();
		incidencies.add(new Incidencia(1L, "Client 1", Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(2L, "Client 2", Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(3L, "Client 1", Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(4L, "Client 2", Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(5L, "Client 3", Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(6L, "Client 1", Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(7L, "Client 1", Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(8L, "Client 5", Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(9L, "Client 1", Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(10L, "Client 7", Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(11L, "Client 3", Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(12L, "Client 1", Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(13L, "Client 2", Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(14L, "Client 4", Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(15L, "Client 8", Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));

	}

	@Override
	public boolean login(String nomUsuari, String contrasenya) {
		if (nomUsuari.equals(USER_HELP_DESK) && (contrasenya.equals(PASSWORD))) {
			return true;
		} else if (nomUsuari.equals(USER_CLIENT) && (contrasenya.equals(PASSWORD))) {
			return true;
		}
		return false;
	}

	@Override
	public Incidencia obtenirIncidencia(String nomUsuari, long id) {

		Incidencia incidencia = obtenirIncidenciaPerId(id);

		if (incidencia != null && incidencia.getAssignat() == null && nomUsuari.equals(USER_HELP_DESK)) {
			incidencia.setAssignat(nomUsuari);
			incidencia.setEstat(Estat.EN_PROGRES);
		}

		return incidencia;
	}

	@Override
	public List<Incidencia> obtenirIncidencies() {
		return incidencies;
	}

	@Override
	public boolean afegirComentari(long idIncidencia, String nomUsuari, String comentari) {

		Incidencia incidencia = obtenirIncidenciaPerId(idIncidencia);

		if (incidencia == null) {
			return false;
		}
		if (nomUsuari == null) {
			return false;
		}
		if (comentari == null) {
			return false;
		}

		Comentari nouComentari = new Comentari(nomUsuari, comentari);

		incidencia.getComentaris().add(nouComentari);

		return true;
	}

	@Override
	public boolean afegirIncidencia(String creador, String assumpte, String tipus) {

		long id = incidencies.size();
		Estat estat = Estat.NOVA;
		Date data = new Date();

		Incidencia incidencia = new Incidencia(id, creador, estat, assumpte, data, tipus);

		incidencies.add(incidencia);

		return true;
	}

	private Incidencia obtenirIncidenciaPerId(long id) {
		Incidencia incidencia = null;

		for (Incidencia incidenciaDeLlista : incidencies) {
			if (incidenciaDeLlista.getId() == id) {
				incidencia = incidenciaDeLlista;
			}
		}
		return incidencia;
	}

	@Override
	public boolean tancarIncidencia(long idIncidencia) {
		Incidencia incidencia = obtenirIncidenciaPerId(idIncidencia);

		if (incidencia == null) {
			return false;
		}

		incidencia.setEstat(Estat.TANCADA);

		return true;
	}

}
