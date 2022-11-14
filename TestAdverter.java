import Adverter.Person;

import java.util.Scanner;

import Adverter.CarAdvert;
import Adverter.ImmoAdvert;
public class TestAdverter {
    public static void main(String[] args) {
        Person michel = new Person("michel");
        Person jean = new Person("jean");

        Scanner sc = new Scanner(System.in);

        ImmoAdvert immotest = new ImmoAdvert(jean);
        immotest.saisie(sc);
        immotest.setClient(michel);

        CarAdvert cartest = new CarAdvert(michel);
        cartest.saisie(sc);
        cartest.setClient(jean);

        System.out.println("========Testing Adverts=======");
        System.out.println(immotest);
        System.out.println(cartest);
        System.out.println("========Testing persons=======");
        System.out.println(jean);
        System.out.println(michel);
        sc.close();
    }
}
