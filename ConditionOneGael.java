import java.util.ArrayList;
import java.util.HashMap;

/*
 * 
    toto -> tennis
    jean -> velo
    Sigismond -> joute
    Gontrand  -> bridge
    titi -> ski
 * 
 * 
 */
public class ConditionOneGael {

    static HashMap<String, String> hobbyDict = new HashMap<String, String>() {
        {
            put("toto", "tennis");
            put("jean", "velo");
            put("Sigismond", "joute");
            put("Gontrand", "bridge");
            put("titi", "ski");
        }
    };

    public static String quelSportFait(String nom) {
        if (hobbyDict.containsKey(nom)) {
            return hobbyDict.get(nom);
        } else {
            return "rien";
        }
    }

    public static void main(String[] args) {

        for (String nom : hobbyDict.keySet()) {
            System.out.println(String.format(" %s fait %s ", nom, quelSportFait(nom)));

        }

    }
}
