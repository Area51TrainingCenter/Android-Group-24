package pe.area51.myfirstfragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText nameEditText;
    private Button loginButton;

    private OnShowWelcomeButtonClickListener onShowWelcomeButtonClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        nameEditText = (EditText) view.findViewById(R.id.edittext_name);
        loginButton = (Button) view.findViewById(R.id.button_show_welcome);
        loginButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (onShowWelcomeButtonClickListener != null) {
            final String name = nameEditText.getText().toString();
            onShowWelcomeButtonClickListener.onClick(name);
        }
    }

    public void setOnShowWelcomeButtonClickListener(final OnShowWelcomeButtonClickListener onShowWelcomeButtonClickListener) {
        this.onShowWelcomeButtonClickListener = onShowWelcomeButtonClickListener;
    }

    public interface OnShowWelcomeButtonClickListener {

        void onClick(final String name);

    }

}
