package com.example.accessingdatamysql.Test;

public class Vizitator extends BasicUser{

    public Vizitator(String nume,String prenume)
    {
        this.nume = nume;
        this.prenume = prenume;
    }
    public boolean equals(Object obj) {
        return obj instanceof Vizitator;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int numarZile() {
        return super.data.zile()*2+5;
    }
}
