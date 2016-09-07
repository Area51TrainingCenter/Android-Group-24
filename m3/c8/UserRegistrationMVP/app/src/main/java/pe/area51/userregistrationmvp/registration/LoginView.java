package pe.area51.userregistrationmvp.registration;

import android.support.annotation.StringRes;

public interface LoginView {

    void showMessage(String message);

    void showMessage(@StringRes int message);

    void goToWelcomeActivity();

}
