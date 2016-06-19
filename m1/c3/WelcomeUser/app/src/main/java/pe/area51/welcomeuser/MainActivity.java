package pe.area51.welcomeuser;

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
	//Establece el "View" de este Activity.
        setContentView(R.layout.activity_main);
	/*
	Los métodos "findViewById" buscan y obtienen por su ID a un "View"
	dentro del "View tree" del "Activity". Si no lo encuentra retorna "null".
	*/
        final Button buttonShowWelcome = (Button) findViewById(R.id.button_show_welcome);
        final EditText editTextName = (EditText) findViewById(R.id.edittext_name);
	//Establecemos el "listener" del botón para capturar eventos de click.
        buttonShowWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
		//Mostramos el mensaje utilizando un "Toast".
                Toast.makeText(MainActivity.this, editTextName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
