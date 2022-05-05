package com.example.accessingdatamysql.Test;

public abstract class BasicUser {

    String nume = null;
    String prenume = null;
    public DataSource data;

    public BasicUser()
    {
        this.nume = "a";
        this.prenume = "c";
        data = new Data();
    }

    public abstract int numarZile();
}
