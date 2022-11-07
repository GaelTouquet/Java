import java.util.*;
import java.util.ArrayList.*;


class Ligne
{
    // variables d'instance'
    String libel            = "";
    Double prixUnitaire     = 0.0;
    Double quantite         = 0.0;
    Double prixTot          = 0.0;

    // variable de classe
    static Integer nbrLigne = 0;  

    public Ligne( String nom, Double pu, Double qte   )
    {
        this.libel          = nom;        
        this.prixUnitaire   = pu;        
        this.quantite       = qte;        
        this.prixTot  = this.quantite * this.prixUnitaire;
        nbrLigne++;
    } 

    public void affLigne()
    {
        System.out.println(  String.format("%15s %8.2f %8.2f = %8.2f",   this.libel, this.prixUnitaire, this.quantite, this.prixTot     ) );
    }
}


class Ticket
{
    // variables d'instance'
    String client            = "";
    Double prixTot           = 0.0;
    ArrayList<Ligne> lignes  = new ArrayList();

    public Ticket( )
    {
    } 

    public void addAchat(  Ligne l  )
    {
        lignes.add( l );
    }

    public void afffiche()
    {
        System.out.println(  "============================= " );
        System.out.println(  String.format("client : %15s",   this.client  ) );
        for (Ligne l : lignes ) 
        {
            l.affLigne();
        }
        System.out.println(  "============================= " );
    }
}

class TicketCaissePOOOne {
    // Xavier

    public static void main(String[] args) {

        Ticket t1 = new Ticket();
 
        t1.addAchat( new Ligne("romarin", 7.56, 1.0 ) );
        t1.addAchat( new Ligne("romarin", 7.56, 1.0) );
        t1.addAchat( new Ligne("rutabaga", 1.5, 5.0));
        t1.addAchat( new Ligne("choux de Brx", 4.50, 1.0));
        t1.addAchat( new Ligne("réglisse", 8.75, 0.5));
        t1.addAchat( new Ligne("bettes", 2.4, 1.0));
        t1.afffiche();


        Ticket t2 = new Ticket();
        t2.addAchat( new Ligne("livre", 7.56, 1.0 ) );
        t2.addAchat( new Ligne("essence", 7.56, 1.0) );
        t2.addAchat( new Ligne("fil à coudre", 1.5, 5.0));
        t2.addAchat( new Ligne("banane", 4.50, 1.0));
        t2.afffiche();

        System.out.println(  String.format("nombre de lignes :  %d ", Ligne.nbrLigne  ) );
    }
}