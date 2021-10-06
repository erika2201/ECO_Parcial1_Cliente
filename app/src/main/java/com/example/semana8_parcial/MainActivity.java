package com.example.semana8_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    //private TextView tittleText, nameTextView, cantTextView, posTextView,typeTextView;
    private EditText nameEditText, cantEditText, coordxEditText, coordyEditText;
    private Button redButton, greenButton, blueButton, deleteButton, createButton;

    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;

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

        initClient();

    }

    public void initClient() {
        new Thread(
                ()->{
                    try {
                        //Paso 2: Enviar solicitud de conexion
                        socket = new Socket("192.168.0.32",2021);

                        //Paso 3: Cliente y server conectados
                        System.out.println("Se ha conectado al servidor!!!");

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        writer = new BufferedWriter(osw);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        ).start();

        colorButton();
        deleteButton();
        createButton();
    }

    public void colorButton (){
       /* redButton.setOnClickListener(
                v -> {

                });


        greenButton.setOnClickListener(
                v -> {

                });


        blueButton.setOnClickListener(
                v -> {

                });*/
    }

    public void deleteButton(){
        /*deleteButton.setOnClickListener(
                v -> {

                });*/
    }

    public void createButton(){
       /* createButton.setOnClickListener(
                v -> {

                });*/
    }
}