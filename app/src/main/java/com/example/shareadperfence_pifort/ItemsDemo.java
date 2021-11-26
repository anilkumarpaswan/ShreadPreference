package com.example.shareadperfence_pifort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ItemsDemo {

    public View onCreateView(LayoutInflater inflater, ViewGroup cotainer, Bundle savedIntanceState) {

        View v = inflater.inflate(R.layout.items_list, cotainer, false);
        return v;


    }
}