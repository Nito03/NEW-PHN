public class Facture extends DocumentCommercial {
    
    public double getTotal(){
        double somme = 0.0;
        for(Ligne l: detail.lignes){
            somme += l.getPrixTotal();
        }
        return somme;
    }

    public double getTVA(){
        double total = getTotal();
        return total - (total * 0.16);
    }

    public void setNumero(long n){
        numero = n;
    }

    public void setClient(Client c){
        client = c;
    }

    public Client getClient(){
        return client;
    }

    public void setDetail(Detail d){
        detail = d;
    }
    public Detail getDetail(){
        return detail;
    }
}