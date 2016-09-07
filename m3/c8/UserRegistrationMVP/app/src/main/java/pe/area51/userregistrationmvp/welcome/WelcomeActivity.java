package pe.area51.userregistrationmvp.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pe.area51.userregistrationmvp.R;

public class WelcomeActivity extends AppCompatActivity implements WelcomeView {

    public static final String NAME = "user";
    public static final String EMAIL = "email";

    @BindView(R.id.textview_welcome_message)
    TextView textViewWelcomeMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        final String name = getIntent().getStringExtra(NAME);
        final String email = getIntent().getStringExtra(EMAIL);
        final User user = new User(name, email);
        new WelcomePresenter(this).onCreate(user);
    }

    @Override
    public void showWelcomeMessage(User user) {
        final String message = getString(R.string.welcome_message, user.getName(), user.getEmail());
        textViewWelcomeMessage.setText(message);
    }
}
