package com.example.shareadperfence_pifort;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class AsynkTaskDemo extends AppCompatActivity {
    TextView tvCounter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_asynk_task_demo );
        tvCounter = findViewById ( R.id.tvCounter );
        MyTask task = new MyTask ( );
        task.execute ( );

    }

    class MyTask extends AsyncTask {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute () {
            super.onPreExecute ( );
            tvCounter.setText ( "GETTING READY TO RUN..." );
            dialog = new ProgressDialog ( AsynkTaskDemo.this );
            dialog.setTitle ( "Loading..." );
            dialog.setMessage ( "Please wait..." );
            dialog.setCancelable ( false );
            dialog.show ( );
        }

        @Override
        protected Object doInBackground (Object[] objects) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep ( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace ( );
                }
                super.publishProgress ( i );
            }
            return null;
        }

        @Override
        protected void onProgressUpdate (Object[] values) {
            super.onProgressUpdate ( values );
            int n = (int) values[0];
            tvCounter.setText ( n + "" );
        }

        @Override
        protected void onPostExecute (Object o) {
            super.onPostExecute ( o );
            tvCounter.setText ( "DONE..." );
            dialog.dismiss ( );
        }
    }
}
