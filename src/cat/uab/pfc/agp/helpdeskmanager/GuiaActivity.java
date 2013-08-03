package cat.uab.pfc.agp.helpdeskmanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GuiaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guia);
		getActionBar().setTitle("Guia");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_guia, menu);
		return true;
	}

}
