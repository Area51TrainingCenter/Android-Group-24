package pe.area51.myfirstfragmentapp;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnShowWelcomeButtonClickListener {

    private WelcomeFragment welcomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeFragment = (WelcomeFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_welcome);
        final LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_login);
        loginFragment.setOnShowWelcomeButtonClickListener(this);
    }

    @Override
    public void onClick(final String name) {
        welcomeFragment.showWelcomeMessage(name);
    }
}
