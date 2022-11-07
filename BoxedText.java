public class BoxedText {

    static String rectangle(int xsize, int ysize, String character) {
        String linestring = "";
        for (int y = 0; y < ysize; y++) {
            for (int x = 0; x < xsize; x++) {
                if (x == 0 | y == 0 | x == xsize - 1 | y == ysize - 1) {
                    linestring += character;
                } else {
                    linestring += " ";
                }
            }
            linestring += "\n";
        }
        return linestring;
    }

    static int count_returns(String text) {
        return 3;
    }

    static String put_in_box(String text) {
        // int n_returns = text.count
        // String my_box = rectangle(maxlinelength+4, nlines+4);
        return " ";
    }

    public static void main(String[] args) {

        String articles[] = { "patate", "tomate", "oignons", "radis", "salade", "rose", "jasmin", "nénuphar", "oeillet", "tulipe", "rhododendron"  }; 
        double prixs[]    = {   1.5,      4,          1.6,      1.5,    1,       7,       14,        78.55,     5.5,        4,          19.99      }; 

        String format_header = "%14s -> %-15s %6s\n";
        String format = "article n ° %2d -> %-15s %6.2f\n";

        String output = "";
        output += String.format(format_header, "numero", "article", "prix");
        for (int i=0; i<articles.length;i++) {
            output+=String.format(format,i,articles[i],prixs[i]);
        }
        System.out.println(output);
    }
}
