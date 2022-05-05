package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Model.Proprietar;

import java.io.IOException;
import java.util.List;

public interface ProprietarRepoDate {

    public List<Proprietar> readFromFile();
    public void writeDataInFile(Proprietar pr) throws IOException;
    public void writeProprietarDataInFile(List<Proprietar> proprietars) throws IOException;
    public void deleteProprietarInFile(Proprietar user) throws IOException;
    public Proprietar findById(Integer id);
    public Proprietar createProprietar(Proprietar pr);
    public void deleteByID(Integer id);
}
