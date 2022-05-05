package com.example.accessingdatamysql.Test;

public class Colaborator extends BasicUser {

    public Colaborator(String nume,String prenume)
    {
        this.nume = nume;
        this.prenume = prenume;
    }
    public boolean equals(Object obj) {
        return obj instanceof Colaborator;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int numarZile() {
        return super.data.zile()*6;
    }
}
