package cat.uab.pfc.agp.helpdeskmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NovaIncidenciaActivity extends Activity {

	TextView crearValor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_incidencia);
		spinnerCreate();
		getActionBar().hide();
		Controller controller = new Controller();
		String nomCreador = controller.recuperarUsuari(NovaIncidenciaActivity.this);
		crearValor = (TextView) findViewById(R.id.editClient);
		crearValor.setText(nomCreador);
		// Botó CANCEL·LAR
		findViewById(R.id.bCan).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast cancel = Toast.makeText(getApplicationContext(), "Has cancel·lat la creació", Toast.LENGTH_SHORT);
				cancel.show();
				NovaIncidenciaActivity.this.finish();
				
			}

		});
		// Botó Acceptar
		findViewById(R.id.bAce).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast accept = Toast.makeText(getApplicationContext(), "S'ha creat correctament", Toast.LENGTH_SHORT);
				accept.show();
				NovaIncidenciaActivity.this.finish();
				
				// Intent intent = new Intent(NovaIncidenciaActivity.this,
				// LlistaIncidenciesActivity.class);
				// startActivity(intent);

			}

		});
	}

	private void spinnerCreate() {
		Spinner spinner = (Spinner) findViewById(R.id.editTipus);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_tipus,
				android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_nova_incidencia, menu);
		return true;
	}

}
