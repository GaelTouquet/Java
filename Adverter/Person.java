package Adverter;

import java.util.ArrayList;

public class Person {
    String name;
    ArrayList<Advert> createdAdverts = new ArrayList<>();
    ArrayList<Advert> answeredAdverts = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void addCreatedAdvert(Advert advert){
        this.createdAdverts.add(advert);
    }

    public void addAnsweredAdvert(Advert advert){
        this.answeredAdverts.add(advert);
    }

    @Override
    public String toString() {
        String output = String.format("name: %s\n",this.name);
        output+="   =======created adverts=======";
        for (Advert advert : createdAdverts) {
            output += String.format("      %s\n",advert.toString());
        }
        output+="   =======answered adverts=======";
        for (Advert advert : answeredAdverts) {
            output += String.format("      %s\n",advert.toString());
        }
        return output;
    }
}
