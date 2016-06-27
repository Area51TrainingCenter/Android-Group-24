package pe.area51.servicetest;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyService extends Service {

    private final static int NOTIFICATION_ID = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        startForeground(NOTIFICATION_ID, createForegroundNotification());
        showMessage(this, "onCreate()");
    }

    @Override
    public void onDestroy() {
        showMessage(this, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showMessage(this, "onStartCommand()");
        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void executeLongTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Notification createForegroundNotification() {
        return new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("MyService")
                .build();
    }

    private static void showMessage(final Context context, @StringRes final int message) {
        showMessage(context, context.getString(message));
    }

    private static void showMessage(final Context context, final String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
