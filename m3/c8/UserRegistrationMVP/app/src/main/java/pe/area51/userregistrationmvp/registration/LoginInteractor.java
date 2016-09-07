package pe.area51.userregistrationmvp.registration;

import android.os.Handler;

public class LoginInteractor {

    interface OnLoginFinishedListener {

        void onLoginFinished();

    }

    public void login(final OnLoginFinishedListener onLoginFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginFinishedListener.onLoginFinished();
            }
        }, 5000);
    }

}
