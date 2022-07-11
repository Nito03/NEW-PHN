import java.util.ArrayList;
import java.util.List;

public class Detail {
    public List<Ligne> lignes;

    public Detail(){
        lignes = new ArrayList<Ligne>();
    }

    public void ajouterLigne(Ligne l){
        lignes.add(l);
    }

    public void enleverLigne(Ligne l){
        lignes.remove(l);
    }

    public int nombreLigne(){
        return lignes.size();
    }
}
