package cat.uab.pfc.agp.helpdeskmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import cat.uab.pfc.agp.helpdeskmanager.server.Servidor;
import cat.uab.pfc.agp.helpdeskmanager.server.ServidorDummy;

public class LoginActivity extends Activity {

	// UI references.
	private EditText nameView;
	private EditText mPasswordView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setTitle("HelpDesk Manager");
		setContentView(R.layout.activity_login);

		nameView = (EditText) findViewById(R.id.name);
		mPasswordView = (EditText) findViewById(R.id.password);

		// FIXME ESTO ES PARA ENTRAR DIRECTO
		nameView.setText("Client");
		mPasswordView.setText("1234");
		// FIXME BORRAR HASTA AQUI

		findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Servidor dummy = new ServidorDummy();
				String nomUsuari = nameView.getText().toString();
				String contrasenya = mPasswordView.getText().toString();
				boolean successfulLogin = dummy.login(nomUsuari, contrasenya);
				if (successfulLogin) {
					//controller
					Controller controller = new Controller();
					controller.guardarUsuari(LoginActivity.this, nomUsuari);
					startActivity(new Intent(LoginActivity.this, LlistaIncidenciesActivity.class));
				} else {
					
					AlertDialog.Builder alertLogin = new AlertDialog.Builder(LoginActivity.this);
					alertLogin.setTitle("Error")
						.setMessage("Las credencials no son correctes.")
						.setCancelable(false)
						.setNeutralButton("Acceptar", new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog, int id) {
		                        dialog.cancel();
		                    }
		                });
						AlertDialog alert = alertLogin.create();
						alertLogin.show();
					
					
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

}
