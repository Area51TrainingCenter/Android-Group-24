package pe.area51.welcomeuser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    public static final String ARG_NAME = "name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
	/*
	Obtenemos el "Intent" que inició a este "Activity" para obtener el texto.
	*/
        final String name = getIntent().getStringExtra(ARG_NAME);
	//Construimos el mensaje de bienvenida.
        final String welcomeMessage = getString(R.string.welcome_message, name);
	//Mostramos el mensaje de bienvenida.
        ((TextView) findViewById(R.id.textview_welcome_message)).setText(welcomeMessage);
        findViewById(R.id.button_dismiss_welcome)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
			//Si presionamos el botón entonces se terminará el "Activity" actual.
                        finish();
                    }
                });
    }
}
