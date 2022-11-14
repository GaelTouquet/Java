package Adverter;

import java.util.Scanner;

public class CarAdvert extends Advert{
    String brand;
    String model;

    public CarAdvert(Person provider) {
        super(provider);
    }

    void objectSaisie(Scanner sc){
        super.objectSaisie(sc);
        System.out.println("What is the brand?");
        this.brand = sc.nextLine();
        System.out.println("What is the model?");
        this.model = sc.nextLine();
    }

    @Override
    public String toString() {
        return String.format("%s   brand: %s   model: %s", super.toString(), this.brand, this.model);
    }
    
}
