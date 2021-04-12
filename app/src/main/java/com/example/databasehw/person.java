package com.example.databasehw;

public class person {

    String name;
    int id;
    String sex;
    float B,T,C;


    public person(String name, int id, String sex, float b, float t, float c) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        B = b;
        T = t;
        C = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getB() {
        return B;
    }

    public void setB(float b) {
        B = b;
    }

    public float getT() {
        return T;
    }

    public void setT(float t) {
        T = t;
    }

    public float getC() {
        return C;
    }

    public void setC(float c) {
        C = c;
    }
}
