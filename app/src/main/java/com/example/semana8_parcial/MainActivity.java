package com.example.semana8_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana8_parcial.Model.Orden;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, cantEditText, coordxEditText, coordyEditText;
    private Button redButton, greenButton, blueButton, deleteButton, createButton;

    //Variables globales
    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;
    private String name,color;
    private int x,y,number;

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

        redButton.setOnClickListener(
                v -> {
                    color = "ROJO";
                    redButton.setText("✔");
                    greenButton.setText(" ");
                    blueButton.setText(" ");
                   Toast.makeText(this, color, Toast.LENGTH_SHORT).show();
                });
        greenButton.setOnClickListener(
                v -> {
                     color = "VERDE";
                    greenButton.setText("✔");
                    redButton.setText(" ");
                    blueButton.setText(" ");
                    Toast.makeText(this, color, Toast.LENGTH_SHORT).show();
                });
        blueButton.setOnClickListener(
                v -> {
                    color = "AZUL";
                    blueButton.setText("✔");
                    redButton.setText(" ");
                    greenButton.setText(" ");
                    Toast.makeText(this, color, Toast.LENGTH_SHORT).show();
                });

        createButton.setOnClickListener(
                v -> {
                    createButton();
                });

        deleteButton.setOnClickListener(
                v -> {
                    deleteButton();
                });

    }

    public void initClient() {
        new Thread(
                ()->{
                    try {
                        //Paso 2: Enviar solicitud de conexion
                        socket = new Socket("192.168.0.32",2021); //cambiar la ip v:v
                        //Paso 3: Cliente y server conectados
                        System.out.println("Se ha conectado al servidor!!!");

                        InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        reader = new BufferedReader(isr);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        writer = new BufferedWriter(osw);

                        while(true) {
                            System.out.println("Esperando mensaje....");
                            String line = reader.readLine();
                            System.out.println("Recibido: " + line);


                        }

                    } catch (UnknownHostException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }).start();
    }

    public void colorButton (){
        name = nameEditText.getText().toString();
        number = Integer.parseInt(cantEditText.getText().toString());
        x = Integer.parseInt(coordxEditText.getText().toString());
        y = Integer.parseInt(coordyEditText.getText().toString());
    }

    public void deleteButton(){
        nameEditText.setText(" ");
        cantEditText.setText(" ");
        coordxEditText.setText(" ");
        coordyEditText.setText(" ");
    }

    public void createButton(){

        if(!nameEditText.getText().toString().replaceAll("\\s","").isEmpty()&&
           ! cantEditText.getText().toString().replaceAll("\\s","").isEmpty()&&
           ! coordxEditText.getText().toString().replaceAll("\\s","").isEmpty()&&
           ! coordyEditText.getText().toString().replaceAll("\\s","").isEmpty()) {
                    colorButton();
                    Gson gson = new Gson();
                    String json;
                    Orden obj = new Orden(name, number, x, y, color);
                    json = gson.toJson(obj);
                    sendMessage(json);
           }else{
            Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show();
        }
    };

    public void sendMessage(String msg) {
        new Thread(
                ()->{
                    try {
                        writer.write(msg+"\n");
                        writer.flush();

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}