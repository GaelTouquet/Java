
class ConditionTwoGael {
    // Xavier

    public static void main(String[] args) {

        String nom = "toto";
        int age = 15;

        if (age >= 18)
            System.out.println("majeur");
        else
            System.out.println("mineur");

        System.out.println("---------------------------------------");

        if (age >= 18)
            System.out.println("majeur");
        else if (age < 16) {
            if (nom != "toto") {
                System.out.println("à l'école");
            }
        } else
            System.out.println("mineur");

    }
}