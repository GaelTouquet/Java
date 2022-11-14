package Adverter;

import java.util.Scanner;

public class ImmoAdvert extends Advert{
    String adress;

    public ImmoAdvert(Person provider) {
        super(provider);
    }

    void objectSaisie(Scanner sc){
        super.objectSaisie(sc);
        System.out.println("What is the adress?");
        this.adress = sc.nextLine();
    }

    @Override
    public String toString() {
        return String.format("%s   adress: %s", super.toString(), this.adress);
    }
}
