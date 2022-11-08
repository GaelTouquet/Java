import java.util.ArrayList;

abstract class Animal {
    String name;
    String food;
    String category;
    String className;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("Hello I'm %s a %s, which is a %s and I eat %s", this.name, this.className, this.category,
                this.food);
    }
}

abstract class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
        this.category = "mammal";
    }
}

abstract class Oviparous extends Animal {

    public Oviparous(String name) {
        super(name);
        this.category = "oviparous";
    }

}

class Cow extends Mammal {

    public Cow(String name) {
        super(name);
        this.food = "grass";
        this.className = "cow";
    }
}

class Chicken extends Oviparous {

    public Chicken(String name) {
        super(name);
        this.food = "seeds";
        this.className = "chicken";
    }
}

class Chameleon extends Oviparous {

    public Chameleon(String name) {
        super(name);
        this.food = "insects";
        this.className = "chameleon";
    }
}

public class POOFarm {

    ArrayList<Animal> animals = new ArrayList<Animal>();

    public POOFarm(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public POOFarm() {

    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public String toString() {
        String output = "Animals of the farm, present yourselves!\n";
        for (Animal animal : animals) {
            output += animal.toString();
            output += "\n";
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        Cow marguerite = new Cow("marguerite");
        animalList.add(marguerite);
        POOFarm myFarm = new POOFarm(animalList);
        myFarm.addAnimal(new Chicken("babs"));
        myFarm.addAnimal(new Cow("milka"));
        myFarm.addAnimal(new Chameleon("rango"));
        myFarm.addAnimal(new Chicken("marie-therese"));
        System.out.println(myFarm);
    }
}
