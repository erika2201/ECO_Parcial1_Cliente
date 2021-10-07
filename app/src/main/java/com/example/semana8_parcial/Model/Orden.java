package com.example.semana8_parcial.Model;

public class Orden {

    String name;
    int number;
    int x, y;
    String color;

    public Orden(String name, int number, int x, int y, String color) {
        this.name = name;
        this.number = number;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Orden() {
        //Necesario para objeto Gson
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
