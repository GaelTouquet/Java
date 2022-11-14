package Adverter;

import java.util.Scanner;

public class Advert {
    String name;
    Person provider;
    Person client;
    double prix;

    public Advert(Person provider) {
        this.provider = provider;
        provider.addCreatedAdvert(this);
    }

    public void setClient(Person client) {
        this.client = client;
        client.addAnsweredAdvert(this);
    }

    void objectSaisie(Scanner sc){
        System.out.println("What is your advert?");
        this.name = sc.nextLine();
        System.out.println("How much are you selling?");
        this.prix = Double.parseDouble(sc.nextLine());
    }

    public void saisie(Scanner sc){
        this.objectSaisie(sc);
    }

    @Override
    public String toString() {
        return String.format("name: %s   prix: %8.2f   provider: %s   client: %s", this.name, this.prix, this.provider.name, this.client.name);
    }
}
