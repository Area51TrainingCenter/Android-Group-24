package pe.area51.welcomeuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextName = (EditText) findViewById(R.id.edittext_name);
        findViewById(R.id.button_show_welcome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
		//Capturamos el texto ingresado en el "EditText".
                final String name = editTextName.getText().toString();
		/*
		Creamos un objeto "Intent" que servirá para iniciar el componente "WelcomeActivity",
		agregándole además el texto ingresado como parámetro extra identificándolo con el
		valor de la variable "WelcomeActivity.ARG_NAME" como clave. Recordar que los "Intent"
		tienen una estructura de datos interna tipo clave-valor para almacenar valores extra.
		*/
                final Intent intent = new Intent(MainActivity.this, WelcomeActivity.class)
                        .putExtra(WelcomeActivity.ARG_NAME, name);
		//Indicamos al sistema operativo que inicie el "Activity" descrito por el "Intent" anterior.
                startActivity(intent);
            }
        });
    }
}
