package com.reihan.reihanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private final List<String> mList = new ArrayList<>();
    private  ClubAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mList.add("Real Madrid FC");
        mList.add("Fiorentina FC");
        mList.add("fenarbache FC");

        mAdapter = new ClubAdapter(this, mList  );

        RecyclerView receyclerView = findViewById(R.id.rececylerview);
        receyclerView.setAdapter(mAdapter);
        receyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab_reycyclerview);
        fab.setOnClickListener(this::addClub);
    }

    private void addClub(View view) {
        View subView = LayoutInflater.from(this)
                .inflate(R.layout.layout_input_item, null, false);
        EditText etClub = subView.findViewById(R.id.et_item);
        etClub.setHint("Enter your club ");
        etClub.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        new AlertDialog.Builder(this)
                .setTitle("Add Club")
                .setView(subView)
                .setCancelable(false)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Add",(dialogInterface, i) -> {
                    if (!etClub.getText().toString().isEmpty()) {
                        mList.add(etClub.getText().toString());
                        mAdapter.notifyDataSetChanged();
                    }
                } )
                .show();
    }
}