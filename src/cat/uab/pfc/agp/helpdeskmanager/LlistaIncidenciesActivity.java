package cat.uab.pfc.agp.helpdeskmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import cat.uab.pfc.agp.helpdeskmanager.adapter.LlistaIncidenciesAdapter;
import cat.uab.pfc.agp.helpdeskmanager.model.Estat;
import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;

public class LlistaIncidenciesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_llista_incidencies);
		ListView listView = (ListView) findViewById(R.id.listView1);
		List<Incidencia> incidencies = getIncidenciesDelServidor();
		listView.setAdapter(new LlistaIncidenciesAdapter(this, incidencies));
	}

	private List<Incidencia> getIncidenciesDelServidor() {
		List<Incidencia> incidencies = new ArrayList<Incidencia>();

		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 1", new Date(), "tipus 1"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 2", new Date(), "tipus 2"));
		incidencies.add(new Incidencia(Estat.TANCADA, "Assumpte 3", new Date(), "tipus 3"));
		incidencies.add(new Incidencia(Estat.EN_PROGRES, "Assumpte 4", new Date(), "tipus 4"));
		incidencies.add(new Incidencia(Estat.NOVA, "Assumpte 5", new Date(), "tipus 5"));

		return incidencies;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_llista_incidencies, menu);
		return true;
	}

}
