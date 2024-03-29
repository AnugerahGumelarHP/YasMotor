package com.battistradadeveloper.yasmotor.Model;

public class DataModel {
    private int id;
    public String name;
    public String email;
    public String type;
    public String number;
    public String sum;

    public DataModel(){
    }

    public DataModel(String name, String email, String type, String number, String sum) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.number = number;
        this.sum = sum;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType(){return type;}

    public void setType(String type) {this.type = type; }

    public String getNumber(){return number; }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

}
