package pe.area51.threads;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_execute_on_main_thread).setOnClickListener(this);
        findViewById(R.id.button_execute_on_worker_thread).setOnClickListener(this);
        findViewById(R.id.button_execute_on_asynctask).setOnClickListener(this);
        findViewById(R.id.button_execute_on_customexecutor).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_execute_on_main_thread:
                executeLongTaskOnMainThread();
                break;
            case R.id.button_execute_on_worker_thread:
                executeLongTaskOnWorkerThread();
                break;
            case R.id.button_execute_on_asynctask:
                executeLongTaskOnAsyncTask();
                break;
            case R.id.button_execute_on_customexecutor:
                executeLongTaskOnCustomExecutor();
                break;
        }
    }

    private void executeLongTaskOnCustomExecutor() {
        new CustomExecutor<Void, Void>() {

            private ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                progressDialog = createProgressDialog();
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                executeLongTask();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                progressDialog.dismiss();
            }
        }.execute();
    }

    private void executeLongTaskOnAsyncTask() {
        new AsyncTask<Void, Integer, Void>() {

            private ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                progressDialog = createProgressDialog();
                progressDialog.setIndeterminate(false);
                progressDialog.setMax(4);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                for (int i = 1; i <= 4; i++) {
                    executeLongTask();
                    publishProgress(i);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                progressDialog.dismiss();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                progressDialog.setProgress(values[0]);
            }
        }.execute();
    }

    private void executeLongTaskOnWorkerThread() {
        final ProgressDialog progressDialog = createProgressDialog();
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                executeLongTask();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                });
            }
        }).start();
    }

    private void executeLongTaskOnMainThread() {
        final ProgressDialog progressDialog = createProgressDialog();
        progressDialog.show();
        executeLongTask();
        progressDialog.dismiss();
    }

    private void executeLongTask() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ProgressDialog createProgressDialog() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(R.string.progress_title);
        progressDialog.setMessage(getString(R.string.progress_content));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        return progressDialog;
    }
}
