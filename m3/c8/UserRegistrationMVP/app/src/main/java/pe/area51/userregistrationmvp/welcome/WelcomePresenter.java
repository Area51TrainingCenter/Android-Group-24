package pe.area51.userregistrationmvp.welcome;

public class WelcomePresenter {

    private WelcomeView welcomeView;

    public WelcomePresenter(final WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
    }

    public void onCreate(final User user) {
        welcomeView.showWelcomeMessage(user);
    }

}
