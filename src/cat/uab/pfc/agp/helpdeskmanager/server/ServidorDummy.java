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
		incidencies.add(new Incidencia(1L, Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(2L, Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(3L, Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(4L, Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(5L, Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(6L, Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(7L, Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(8L, Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(9L, Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(10L, Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(11L, Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(12L, Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(13L, Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(14L, Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(15L, Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));

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

		if (incidencia != null && nomUsuari.equals(USER_HELP_DESK)) {
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

		Comentari nouComentari = new Comentari(nomUsuari, comentari);

		incidencia.getComentaris().add(nouComentari);

		return true;
	}

	@Override
	public boolean afegirIncidencia(String assumpte, String tipus) {

		long id = incidencies.size();
		Estat estat = Estat.NOVA;
		Date data = new Date();

		Incidencia incidencia = new Incidencia(id, estat, assumpte, data, tipus);

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
