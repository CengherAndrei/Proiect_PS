package com.example.accessingdatamysql.Test;

public class Angajat extends BasicUser{

    public Angajat(String nume,String prenume)
    {
        this.nume = nume;
        this.prenume = prenume;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Angajat;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int numarZile() {
        return super.data.zile()+15;
    }
}
