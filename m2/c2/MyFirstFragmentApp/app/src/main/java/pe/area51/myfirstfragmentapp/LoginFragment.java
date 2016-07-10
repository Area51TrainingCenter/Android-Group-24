package pe.area51.myfirstfragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by alumno on 7/7/16.
 */
public class LoginFragment extends Fragment {

    private EditText nameEditText;
    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        nameEditText = (EditText) view.findViewById(R.id.edittext_name);
        loginButton = (Button) view.findViewById(R.id.button_show_welcome);
        return view;
    }
}
