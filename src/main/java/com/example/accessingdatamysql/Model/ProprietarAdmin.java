package com.example.accessingdatamysql.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProprietarAdmin extends Proprietar{
    int id;

    public ProprietarAdmin(String nume, String CNP, String adresa, String nrTelefon, String email) {
        super(nume, CNP, adresa, nrTelefon, email);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietarAdmin that = (ProprietarAdmin) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

