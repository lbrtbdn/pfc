package cat.uab.pfc.agp.helpdeskmanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NovaIncidenciaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_incidencia);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_nova_incidencia, menu);
		return true;
	}

}
