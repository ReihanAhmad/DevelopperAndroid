package com.reihan.challangelifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    final static String EXTRA_ITEM_VALUE = "SecondActivity.extra.itemValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addItemToFirstAct(View view) {
        Intent returnIntent = new Intent();
        Button b = (Button) view;
        returnIntent.putExtra(EXTRA_ITEM_VALUE, b.getText().toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}