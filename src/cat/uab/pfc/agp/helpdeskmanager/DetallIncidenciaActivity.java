package cat.uab.pfc.agp.helpdeskmanager;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import cat.uab.pfc.agp.helpdeskmanager.model.Estat;
import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;
import cat.uab.pfc.agp.helpdeskmanager.server.Servidor;
import cat.uab.pfc.agp.helpdeskmanager.server.ServidorDummy;

public class DetallIncidenciaActivity extends Activity {

	public final static String PARAM_INDICENCIA_ID = "incidencia_id";
	private Incidencia incidencia;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detall_incidencia);
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.canvi){
				CharSequence[] estats = {"Nova", "Pendent", "Resolta"};
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
		if (item.getItemId() == R.id.coment){
			AlertDialog.Builder builder = new AlertDialog.Builder(DetallIncidenciaActivity.this);
		    LayoutInflater inflater = this.getLayoutInflater();
		    builder.setView(inflater.inflate(R.layout.afegir_comentari, null))
		           .setPositiveButton("Afegir", new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {
		                   Servidor dummy = new ServidorDummy();
		                   //TODO 
		                   // succesfulInsert = dummy.afegirComentari(incidencia.getId(), nomUsuari, R.id.afegir_comentari);
		               }
		           })
		           .setNegativeButton("Cancel·lar", new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {
		                   dialog.dismiss();
		               }
		           });      
		    	builder.create().show();
		}
		return true;
	}
	
}
