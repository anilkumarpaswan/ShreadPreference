package com.example.shareadperfence_pifort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class FragViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_frag_view );
    }

    public void loadFrag1 (View view) {
        FragmentOne obj = new FragmentOne ( );
        FragmentManager manager = getSupportFragmentManager ( );
        FragmentTransaction tx = manager.beginTransaction ( );
        tx.replace ( R.id.frame, obj );
        tx.commit ( );
    }

    public void loadFrag2 (View view) {
        FragmentTwo obj = new FragmentTwo ( );
        getSupportFragmentManager ( ).beginTransaction ( ).replace ( R.id.frame, obj ).commit ( );
    }
}
