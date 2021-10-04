package com.example.semana8_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private TextView tittleText, nameTextView, cantTextView, posTextView,typeTextView;
    private EditText nameEditText, cantEditText, coordxEditText, coordyEditText;
    private Button redButton, greenButton, blueButton, deleteButton, createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        cantEditText = findViewById(R.id.cantEditText);
        coordxEditText = findViewById(R.id.coordxEditText);
        coordyEditText = findViewById(R.id.coordyEditText);
        redButton = findViewById(R.id.redButton);
        greenButton = findViewById(R.id.greenButton);
        blueButton = findViewById(R.id.blueButton);
        deleteButton = findViewById(R.id.deleteButton);
        createButton = findViewById(R.id.createButton);

    }
}