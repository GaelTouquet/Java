public class Surface {

    public static double surfaceCarre(double longueur) {
        return surfaceRect(longueur, longueur);
    }

    public static double surfaceRect(double largeur, double longueur) {
        return largeur * longueur;
    }

    public static double surfaceCercle(double rayon) {
        return 2 * Math.PI * rayon;
    }

    public static void main(String[] args) {
        System.out.println(surfaceRect(5, 8));
        System.out.println(surfaceCarre(7));
        System.out.println(surfaceCercle(7.5));
    }
}
