class Hourglasses {

  // public static String fillHourglass(String val, int count, int max) {
  //   val+=
  // }

  // public static String Hourglass(int largeur) {
  //   String output = "";
  //   fillHourglass();
  //   return output;
  // }

  public static String HourglassLine(int i_line, int largeur) {
    String Line = "";
      for (int j = 0; j < i_line; j++) {
        Line += " ";
      }
      for (int j = i_line; j < largeur - i_line; j++) {
        Line += "*";
      }
      return Line;
  }

  public static String Hourglass(int hauteur) {
    String output = "";
    int largeur = hauteur*2-1;
    for (int i = 0; i < hauteur; i++) {
      output += HourglassLine(i, largeur) + "\n";
    }
    for (int i = hauteur-2; i >= 0; i--) {
      output += HourglassLine(i, largeur) + "\n";
    }
    return output;
  }

  public static String FatHourglass(int hauteur) {
    String output = "";
    int largeur = hauteur*2;
    for (int i = 0; i < hauteur; i++) {
      output += HourglassLine(i, largeur) + "\n";
    }
    for (int i = hauteur-2; i >= 0; i--) {
      output += HourglassLine(i, largeur) + "\n";
    }
    return output;
  }
  public static void main(String[] args) {
    System.out.println(Hourglass(4));
    System.out.println(Hourglass(3));
    System.out.println(FatHourglass(4));
    System.out.println(FatHourglass(3));
  }
}