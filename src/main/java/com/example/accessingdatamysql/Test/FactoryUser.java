package com.example.accessingdatamysql.Test;

public class FactoryUser {
    public BasicUser createObj(Enum e)
    {
        BasicUser bs;
        if(e == Enum.Angajat)
            bs = new Angajat("Andrei","C");
        else {
            if(e == Enum.Colaborator)
                bs = new Colaborator("","");
            else
                bs = new Vizitator("","");
        }
        return bs;
    }
}
