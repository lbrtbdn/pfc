package cat.uab.pfc.agp.helpdeskmanager;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Helpers;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cat.uab.pfc.agp.helpdeskmanager.adapter.LlistaIncidenciesAdapter;
import cat.uab.pfc.agp.helpdeskmanager.model.Estat;
import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;
import cat.uab.pfc.agp.helpdeskmanager.server.Servidor;
import cat.uab.pfc.agp.helpdeskmanager.server.ServidorDummy;

public class LlistaIncidenciesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_llista_incidencies);
		configurarListView();
		getActionBar().setTitle("Llista incidències");
	}

	private void configurarListView() {
		ListView listView = (ListView) findViewById(R.id.listView1);
		final List<Incidencia> incidencies = getIncidenciesDelServidor();
		listView.setAdapter(new LlistaIncidenciesAdapter(this, incidencies));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				obrirDetallDeIncidencia(position);
			}

			private void obrirDetallDeIncidencia(int position) {
				Incidencia incidencia = incidencies.get(position);
				long id = incidencia.getId();
				Intent intent = new Intent(LlistaIncidenciesActivity.this, DetallIncidenciaActivity.class);
				intent.putExtra(DetallIncidenciaActivity.PARAM_INDICENCIA_ID, id);
				startActivity(intent);
			}

		});
	}

	private List<Incidencia> getIncidenciesDelServidor() {
		Servidor dummy = new ServidorDummy();
		List<Incidencia> incidencies = dummy.obtenirIncidencies();
		return incidencies;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_llista_incidencies, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.faq:
			obrirFAQActivity();
			return true;
		case R.id.guia:
			obrirGuiaActivity();
			return true;
		case R.id.nova:
			obrirNovaIncidenciaActivity();
			return true;
		case R.id.sortir:
			sortirActivity();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void sortirActivity() {
		LlistaIncidenciesActivity.this.finish();
		
	}

	private void obrirNovaIncidenciaActivity() {
		Intent intent = new Intent(LlistaIncidenciesActivity.this, NovaIncidenciaActivity.class);
		startActivity(intent);
	}

	private void obrirGuiaActivity() {
		Intent intent = new Intent(LlistaIncidenciesActivity.this, GuiaActivity.class);
		startActivity(intent);
	}

	private void obrirFAQActivity() {
		Intent intent = new Intent(LlistaIncidenciesActivity.this, FAQActivity.class);
		startActivity(intent);
	}

}
