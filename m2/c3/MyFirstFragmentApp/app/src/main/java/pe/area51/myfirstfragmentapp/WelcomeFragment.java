package pe.area51.myfirstfragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {

    private TextView welcomeTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        welcomeTextView = (TextView) view.findViewById(R.id.textview_welcome_text);
        return view;
    }

    public void showWelcomeMessage(final String name) {
        welcomeTextView.setText(getString(R.string.welcome_message, name));
    }

}
