package com.example.caps;
import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB db;

    public Game(){
        this.db=new CountryDB();
}
    public String qa(){
        int n= this.db.getCapitals().size();
        List<String> capitals= this.db.getCapitals();
        int random_num= (int)(n*Math.random());
        String c= capitals.get(random_num);
        Map<String,Country> data= this.db.getData();
        Country ref= data.get(c);

        if(Math.random()<0.5){
            return "Country of " +ref.getCapital()+"\n"+ref.getName();
    }
        else{
            return "Capital of "+ref.getName()+"?"+"\n"+ref.getCapital();
    }

}
}
