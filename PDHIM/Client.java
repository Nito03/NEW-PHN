public class Client extends Personne {
    private String numero;

    public String getNumero(){
        return numero;
    }

    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public Adresse getAdresse(){
        return adresse;
    }

    public void setNumero(String n){
        this.numero = n;
    }

    public void setNom(String n){
        this.nom = n;
    }

    public void setPrenom(String n){
        this.prenom = n;
    }

    public void setAdresse(Adresse n){
        this.adresse = n;
    }
}
