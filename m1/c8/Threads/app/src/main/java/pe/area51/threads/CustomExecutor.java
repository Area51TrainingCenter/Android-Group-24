package pe.area51.threads;

import android.os.Handler;

public abstract class CustomExecutor<Params, Result> {

    private final Handler handler;

    public CustomExecutor() {
        handler = new Handler();
    }

    protected abstract void onPreExecute();

    protected abstract Result doInBackground(final Params... params);

    protected abstract void onPostExecute(final Result result);

    public void execute(final Params... params) {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                onPreExecute();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final Result result = doInBackground(params);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                onPostExecute(result);
                            }
                        });
                    }
                }).start();
            }
        };
        if (Thread.currentThread().getId() != handler.getLooper().getThread().getId()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

}
