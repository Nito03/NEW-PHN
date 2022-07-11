public class Ligne {
    private int numero;
    private int quantite;
    private Produit<String> produit;

    public Ligne(int n, int q, Produit<String> p){
        numero = n;
        quantite = q;
        produit = p;
    }

    public Ligne(int n, String q, Produit<String> p){
        numero = n;
        quantite = Integer.parseInt(q);
        produit = p;
    }

    public double getPrixTotal(){
        return quantite * produit.getPrix();
    }

    public int getNumero(){
        return numero;
    }

    public void setQuantite(int q){
        quantite = q;
    }

    public int getQuantite(){
        return quantite;
    }

    public Produit<String> getProduit(){
        return produit;
    }

    public void setProduit(Produit<String> p){
        this.produit = p;
    }
}
