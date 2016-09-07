package pe.area51.userregistrationmvp.registration;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import pe.area51.userregistrationmvp.R;
import pe.area51.userregistrationmvp.welcome.WelcomeActivity;

public class MainActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.edittext_firstname)
    EditText editTextFirstName;

    @BindView(R.id.edittext_lastname)
    EditText editTextLastName;

    @BindView(R.id.edittext_email)
    EditText editTextEmail;

    @BindView(R.id.button_register)
    Button buttonRegister;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this, new LoginInteractor());
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(@StringRes int message) {
        showMessage(getString(message));
    }

    @Override
    public void goToWelcomeActivity() {
        final String name = editTextFirstName.getText().toString() + " " + editTextLastName.getText().toString();
        final String email = editTextEmail.getText().toString();
        startActivity(new Intent(this, WelcomeActivity.class)
                .putExtra(WelcomeActivity.NAME, name)
                .putExtra(WelcomeActivity.EMAIL, email)
        );
    }
}
