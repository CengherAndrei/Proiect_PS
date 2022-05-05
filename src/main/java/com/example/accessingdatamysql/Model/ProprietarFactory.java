package com.example.accessingdatamysql.Model;

public class ProprietarFactory {

    Integer idProprietar;
    String nume;
    String CNP;
    String adresa;
    String nrTelefon;
    String email;
    Proprietar pr = null;

        public ProprietarFactory(String nume,String CNP, String adresa, String nrTelefon, String email) {
            this.nume = nume;
            this.CNP = CNP;
            this.adresa = adresa;
            this.nrTelefon = nrTelefon;
            this.email = email;
        }

            public Proprietar create(EnumProprietari myVar){


                switch(myVar){
                    case ProprietarBasic:
                        pr = new ProprietarBasic(nume, CNP, adresa, nrTelefon, email);
                        break;
                    case ProprietarPremium:
                        pr = new ProprietarPremium(nume, CNP, adresa, nrTelefon, email);
                        break;
                        case ProprietarAdmin:
                        pr = new ProprietarAdmin(nume, CNP, adresa, nrTelefon, email);
                        break;
                }
                return pr;
            }
        }
