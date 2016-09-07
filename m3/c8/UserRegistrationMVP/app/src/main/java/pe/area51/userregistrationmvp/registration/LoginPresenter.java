package pe.area51.userregistrationmvp.registration;

import pe.area51.userregistrationmvp.R;

public class LoginPresenter {

    private final LoginView loginView;
    private final LoginInteractor loginInteractor;

    public LoginPresenter(final LoginView loginView,
                          final LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void login() {
        loginView.showMessage(R.string.registration_initiated);
        loginInteractor.login(new LoginInteractor.OnLoginFinishedListener() {
            @Override
            public void onLoginFinished() {
                loginView.showMessage(R.string.registration_finished);
                loginView.goToWelcomeActivity();
            }
        });
    }

}
