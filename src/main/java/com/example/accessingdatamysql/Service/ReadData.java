package com.example.accessingdatamysql.Service;

import com.example.accessingdatamysql.Model.Proprietar;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadData implements ProprietarRepoDate{
    List<Proprietar> proprietars = new ArrayList<>();

    public List<Proprietar> getProprietars() {
        return proprietars;
    }

    public void setProprietars(List<Proprietar> proprietars) {
        this.proprietars = proprietars;
    }

    public ReadData(List<Proprietar> pr) {
        this.proprietars = pr;
    }

    public ReadData(){}

    public List<Proprietar> readFromFile(){
        ObjectMapper objectMapper = new ObjectMapper();

        File jsonFile= new File("src/main/java/com/example/accessingdatamysql/proprietari.json");
        try {
            proprietars = objectMapper.readValue(jsonFile, new TypeReference<List<Proprietar>>() {});
            return proprietars;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeDataInFile(Proprietar pr) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Path path = Paths.get("src/main/java/com/example/accessingdatamysql/proprietari.json");
        final String currentJsonArrayAsString = Files.readString(path);

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {

            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(pr));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void writeProprietarDataInFile(List<Proprietar> proprietars) throws IOException {
        JSONArray userList = new JSONArray();
        for(Proprietar pr:proprietars){
            JSONObject userObject = new JSONObject();
            try {
                userObject.put("idProprietar", pr.getIdProprietar());
                userObject.put("nume", pr.getNume());
                userObject.put("email", pr.getEmail());
                userObject.put("adresa", pr.getAdresa());
                userObject.put("CNP", pr.getCNP());
                userObject.put("nrTelefon", pr.getNrTelefon());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            userList.put(userObject);
        }
        try (FileWriter file = new FileWriter("src/main/java/com/example/accessingdatamysql/proprietari.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(userList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteProprietarInFile(Proprietar proprietar) throws IOException {
        List<Proprietar> proprietars= readFromFile();
        for(Proprietar pr:proprietars){
            if(pr.getIdProprietar().equals(proprietar.getIdProprietar())){
                proprietars.remove(pr);
                break;
            }
        }
        writeProprietarDataInFile(proprietars);
    }
    public Proprietar findById(Integer id){
        proprietars=readFromFile();
        for(Proprietar pr: proprietars){
            if(pr.getIdProprietar().equals(id)){
                return pr;
            }
        }
        return null;
    }

    public Proprietar createProprietar(Proprietar pr){
        try {
            writeDataInFile(pr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return pr;
    }
    public void deleteByID(Integer id){
        proprietars=readFromFile();
        for(Proprietar pr: proprietars){
            if(pr.getIdProprietar().equals(id)){
                try {
                    deleteProprietarInFile(pr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}