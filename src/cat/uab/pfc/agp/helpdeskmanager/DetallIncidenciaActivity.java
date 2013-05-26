package cat.uab.pfc.agp.helpdeskmanager;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import cat.uab.pfc.agp.helpdeskmanager.model.Estat;
import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;

public class DetallIncidenciaActivity extends Activity {

	public final static String PARAM_INDICENCIA_ID = "incidencia_id";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detall_incidencia);

		obternirIPintarIncidencia();
	}

	private void obternirIPintarIncidencia() {
		Bundle extras = this.getIntent().getExtras();
		if (extras != null) {
			long id = extras.getLong(PARAM_INDICENCIA_ID);
			Incidencia incidencia = obtenirIncidenciaPerId(id);
			pintarIncidencia(incidencia);
		} else {
			mostrarNoEsPotTrobarIncidencia();
		}
	}

	private void pintarIncidencia(Incidencia incidencia) {
		// TODO Auto-generated method stub
		
	}

	private Incidencia obtenirIncidenciaPerId(long id) {
		// TODO Aquest metode crida a servidor per obtenir la incidencia. El que
		// hi ha aqui es dummy
		return new Incidencia(id, Estat.NOVA, "Assumpte", new Date(), "Hardware");
	}

	private void mostrarNoEsPotTrobarIncidencia() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_detall_incidencia, menu);
		return true;
	}

}
