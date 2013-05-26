package cat.uab.pfc.agp.helpdeskmanager;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * Activity base de la que han d'estendre la resta d'activities
 *
 */
public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		assignarViewsPerId();
		configurarViews();
	}

	/**
	 * Canviar les dades d'una vista. Per exemple actualitzar els elements que
	 * apareixen a una llista.
	 */
	protected abstract void actualitzarViews();

	/**
	 * Assignar les vistes d'un layout a vistes d'una activity fent servir
	 * findViewById
	 */
	protected abstract void assignarViewsPerId();

	/**
	 * Afegir configuracio especial a les vistes. Per exemple assignar adapter a
	 * un ListView
	 */
	protected abstract void configurarViews();

}
