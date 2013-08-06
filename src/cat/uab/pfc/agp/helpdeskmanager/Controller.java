package cat.uab.pfc.agp.helpdeskmanager;

import android.content.Context;
import android.content.SharedPreferences;

public class Controller {
	public static final String PREFS_NAME = "Users";
	public void guardarUsuari(Context context, String nUsuari) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
	     editor.putString("Usuari", nUsuari);
	     editor.commit();
	}
	public String recuperarUsuari(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		String nUsuari = settings.getString("Usuari", null);
		return nUsuari;
	}
}
