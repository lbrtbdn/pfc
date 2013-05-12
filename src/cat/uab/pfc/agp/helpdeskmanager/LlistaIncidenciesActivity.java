package cat.uab.pfc.agp.helpdeskmanager;

import cat.uab.pfc.agp.helpdeskmanager.adapter.LlistaIncidenciesAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class LlistaIncidenciesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_llista_incidencies);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(new LlistaIncidenciesAdapter());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_llista_incidencies, menu);
		return true;
	}

}
