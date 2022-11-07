import java.util.ArrayList;

public class MadamIrmaGael {
    public static int numeroDeLaChance(String prenom) {
        int output = 0;
        prenom = prenom.toLowerCase();
        for (int i = 0; i < prenom.length(); i++) {
            output += (int) prenom.charAt(i);
        }
        return output % 50;
    }

    public static ArrayList<String> preoccupations(int age) {
        ArrayList<String> preoclist = new ArrayList<String>();
        if (age > 60) {
            preoclist.add("retraite");
        }
        if (age >= 0 && age <= 12) {
            preoclist.add("ecole");
        }
        if (age >= 12 && age <= 20) {
            preoclist.add("trucs d'ados");
        }
        if (age >= 20 && age <= 65) {
            preoclist.add("travail");
        }
        if (age >= 20 && age <= 40) {
            preoclist.add("enfants");
        }
        if (age >= 20 && age <= 30) {
            preoclist.add("conjoint");
        }
        if (age >= 60) {
        }
        return preoclist;
    }

    public static void main(String[] args) {
        String prenom = "Gertrude";
        int age = 25;
        int numDeChance = numeroDeLaChance(prenom);
        System.out.println(String.format("le numéro de la chance de %s est %d", prenom, numDeChance));
        ArrayList<String> preocs = preoccupations(age);
        System.out.println(String.format("vos préoccupations sont: %s", String.join(", ", preocs)));
    }
}
