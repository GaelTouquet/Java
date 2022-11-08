import java.util.*;
import java.util.ArrayList.*;

class Point {
    protected Integer x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("Point : (%d, %d)", this.x, this.y);
    }
}

class Cercle extends Point {
    int rayon;

    public Cercle(int x, int y, int r) {
        super(x, y);
        this.rayon = r;
    }

    public String toString() {
        return String.format("Cercle : (%d, %d) rayon=%d", this.x, this.y, this.rayon);
    }
}

class Carre extends Point {

    int cote;

    public Carre(int x, int y, int cote) {
        super(x, y);
        this.cote = cote;
    }

    public String toString() {
        return String.format("Cercle : (%d, %d) cote=%d", this.x, this.y, this.cote);
    }
}

class Rectangle extends Carre {
    int coteY;

    public Rectangle(int x, int y, int xLen, int coteY) {
        super(x, y, xLen);
        this.coteY = coteY;
    }

    public String toString() {
        return String.format("Rectangle : (%d, %d) cotex=%d cotey=%d", this.x, this.y, this.cote, this.coteY);
    }
}


class POOFigureOne {
    // Xavier

    public static void main(String[] args) {

        Point p1 = new Point(5, 6);
        System.out.println(p1);
        // (5, 6)

        Cercle c1 = new Cercle(11, 61, 45);
        System.out.println(c1); // (5, 6)

        Carre k1 = new Carre(18, -3, 15);
        System.out.println(k1);
        // Carre : (5, 6) cote=15
        Rectangle r1 = new Rectangle(3, 19, 99, 18);
        System.out.println(r1);
        // Rectangle : (5, 6) long=99 lar=18
    }
}