import java.util.*;
import java.util.ArrayList.*;

class Container {
    // Xavier

    // creation des list qui vont contenir les données
    static ArrayList<String> payss = new ArrayList<String>( Arrays.asList("belgique", "espagne" )); // instancier l'objet ArrayList


    public static void main(String[] args) {

        payss.add( "italie" );
        payss.add( "monaco" );
        payss.add( "andore" );
        payss.add( "vatican" );
        payss.add( "italie" );
        payss.add( "lecheinstein" );
        payss.add( "san marin" );

        int nbrElem = payss.size();

        for ( int i=0 ; i < payss.size() ; i++ )
            System.out.println( payss.get( i ) );

        for (String pays : payss ) {
            System.out.println( pays );
        }

        payss.add( "malte" );
        int position = payss.indexOf( "andore" );
        payss.remove( position );

        payss.remove( "italie" );
        payss.remove( "italie" );
        payss.remove( "italie" );


        System.out.println( "------------------------------" );

        for (String pays : payss ) {
            System.out.println( pays );
        }
    }
}