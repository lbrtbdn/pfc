package cat.uab.pfc.agp.helpdeskmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;
import cat.uab.pfc.agp.helpdeskmanager.server.Servidor;
import cat.uab.pfc.agp.helpdeskmanager.server.ServidorDummy;

public class DetallIncidenciaActivity extends Activity {

	public final static String PARAM_INDICENCIA_ID = "incidencia_id";

	private Incidencia incidencia;

	TextView assumpteValor;

	TextView clientValor;

	TextView tipusValor;

	TextView comentariValor;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detall_incidencia);
		assumpteValor = (TextView) findViewById(R.id.detAssumpte);
		clientValor = (TextView) findViewById(R.id.detClient);
		tipusValor = (TextView) findViewById(R.id.detTipusSpin);
		comentariValor = (TextView) findViewById(R.id.detDescripcio);

		obternirIPintarIncidencia();
		getActionBar().setTitle("Detall incidència");

	}

	private void obternirIPintarIncidencia() {
		Bundle extras = this.getIntent().getExtras();
		if (extras != null) {
			long id = extras.getLong(PARAM_INDICENCIA_ID);
			incidencia = obtenirIncidenciaPerId(id);
			pintarIncidencia(incidencia);
		} else {
			mostrarNoEsPotTrobarIncidencia();
		}
	}

	private void pintarIncidencia(Incidencia incidencia) {
		// TODO Auto-generated method stub
		assumpteValor.setText(incidencia.getAssumpte());
		clientValor.setText(incidencia.getCreador());
		tipusValor.setText(incidencia.getTipus());
		// comentariValor.setText(incidencia.getComentaris());

	}

	private Incidencia obtenirIncidenciaPerId(long id) {
		Controller controller = new Controller();
		String nomUsuari = controller.recuperarUsuari(this);

		Servidor servidor = new ServidorDummy();
		Incidencia incidencia = servidor.obtenirIncidencia(nomUsuari, id);

		return incidencia;
	}

	private void mostrarNoEsPotTrobarIncidencia() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertLogin = new AlertDialog.Builder(DetallIncidenciaActivity.this);
		alertLogin.setTitle("Error").setMessage("No s'ha trobat la incidència.").setCancelable(false)
				.setNeutralButton("Acceptar", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		alertLogin.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_detall_incidencia, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.canvi) {
			CharSequence[] estats = { "Nova", "Pendent", "Resolta" };
			AlertDialog.Builder builder = new AlertDialog.Builder(DetallIncidenciaActivity.this);
			builder.setTitle("Escull l'estat");
			builder.setItems(estats, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// The 'which' argument contains the index position
					// of the selected item
				}
			});
			builder.create().show();
		}
		if (item.getItemId() == R.id.coment) {
			final EditText afeCom = new EditText(this);
			AlertDialog.Builder builder = new AlertDialog.Builder(DetallIncidenciaActivity.this);
			builder.setTitle("Introdueix el teu comentari");
			LayoutInflater inflater = this.getLayoutInflater();
			builder.setView(inflater.inflate(R.layout.afegir_comentari, null))
					.setPositiveButton("Afegir", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							Servidor dummy = new ServidorDummy();
							Controller controller = new Controller();
							String nomUsuari = controller.recuperarUsuari(DetallIncidenciaActivity.this);
							String comentari = afeCom.getText().toString();
							boolean comentariAfegit = dummy.afegirComentari(incidencia.getId(), nomUsuari, comentari);
							if (comentariAfegit) {
								Toast.makeText(DetallIncidenciaActivity.this, "Comentari afegit correctament",
										Toast.LENGTH_LONG).show();
							}
						}
					}).setNegativeButton("Cancel·lar", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.dismiss();
						}
					});
			builder.create().show();
		}
		return true;
	}

}
