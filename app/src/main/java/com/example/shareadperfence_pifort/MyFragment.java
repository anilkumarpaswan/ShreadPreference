package com.example.shareadperfence_pifort;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    TextView tvCounter;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate ( R.layout.activity_asynk_task_demo, container, false );
        tvCounter = view.findViewById ( R.id.tvCounter );
        new MyTask ( ).execute ( );

        return view;

    }

    class MyTask extends AsyncTask {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute () {
            super.onPreExecute ( );
            tvCounter.setText ( "GETTING READY TO RUN..." );
//            dialog = new ProgressDialog ( AsynkTaskDemo.this );
//            dialog.setTitle ( "Loading..." );
//            dialog.setMessage ( "Please wait..." );
//            dialog.setCancelable ( false );
//            dialog.show ( );
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
//            dialog.dismiss ( );
        }
    }
}
