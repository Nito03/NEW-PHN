import java.util.Calendar;
import java.text.*;

public class Displayer {
    /**
     * WIDTH = 97
     *  _________________________________________________________________________________________________
     * | Client                                                                      Date :              |
     * | Numero : {}                                                                                     |
     * | Nom :  {}                                                                                       |
     * | Adresse : {}                                                                                    |
     * |                                                                                                 |
     * |                                     Jambo MART                                                  |
     * |                                                                                                 |
     * |                       |  PRODUIT        |   PRIX    |   QTE   |   TOTAL   |                     |
     * |                       |___________________________________________________|                     |
     * |                       | Stylo           |   500     |   9     |   4500    |                     |
     * |                       |_________________|___________|_________|___________|                     |
     * |                       | TOTAL                                 |   4500    |                     |
     * |                       |_______________________________________|___________|                     |
     * |                       | TVA                                   |   16%     |                     |
     * |                       |_______________________________________|___________|                     |
     * |                                                                                                 |
     * |_________________________________________________________________________________________________|
     */
    private int width;
    private String company;
    private String printableFacture;
    private Facture facture;
    private double total;
    public Displayer(Facture fact, String Company){
        width = 97;
        company = Company;
        facture = fact;
        printableFacture = " _________________________________________________________________________________________________\n";
        drawDate();
        drawClientAndCompany();
        drawProduitTable();
     }

     private void drawDate(){
        // dessin la date
        DateFormat Date = DateFormat.getDateInstance();
        Calendar cal = Calendar.getInstance();
        String datefmt = Date.format(cal.getTime());
        printableFacture = printableFacture.concat("| Client                                                                      Date : "+ datefmt +" |\n");
     }

     private void drawClientAndCompany(){
        int nomTaille = facture.getClient().getNom().length();
        int prenomTaille = facture.getClient().getPrenom().length();
        int numeroTaille = facture.getClient().getNumero().length();
        int adreseTaille = facture.getClient().getAdresse().toString().length();

        // Ajouter la ligne Numero client
        printableFacture = printableFacture + "| Numero : "+ facture.getClient().getNumero() + getChar(width - (numeroTaille + 10)) + "|\n";

        // Ajouter la ligne Nom client
        printableFacture = printableFacture + "| Nom : "+ facture.getClient().getNom() + getChar(width - (nomTaille + 7)) + "|\n";

        // Ajouter la ligne Prenom client
        printableFacture = printableFacture + "| Prenom : "+ facture.getClient().getPrenom() + getChar(width - (prenomTaille + 10)) + "|\n";
        printableFacture = printableFacture + "| Adresse : "+ facture.getClient().getAdresse().toString() + getChar(width - (adreseTaille + 11)) + "|\n";

        // Ajouter le nom de la company
        int middle =  (int)((width - company.length()) / 2);
        printableFacture = printableFacture + "|" + getChar(width) + "|\n";
        // Ajuster le nom 
        String nom = getChar(middle) + company + getChar(middle);
        if (nom.length() <= 97){
            nom += " ";
        }
        printableFacture = printableFacture + "|" + nom + "|\n";

     }
     
     private void drawProduitTable(){
        int tableWith = 53;
        int pxTaille = 17;
        int prixTaille = 11;
        int qteTaille = 9;
        double pxtotal;
        int middle = (int)((width - tableWith) / 2);
        printableFacture = printableFacture + "|" + getChar(width) + "|\n";
        printableFacture = printableFacture + "|" + getChar(middle) + "|  PRODUIT        |   PRIX    |   QTE   |   TOTAL   |" + getChar(middle) + "|\n";
        printableFacture = printableFacture + "|" + getChar(middle) + "|___________________________________________________|" + getChar(middle) + "|\n";

        Detail detail = facture.getDetail();
        for(Ligne l: detail.lignes){
            pxtotal = l.getPrixTotal();
            total += pxtotal;
            printableFacture = printableFacture + "|" + getChar(middle) + "|" + Limited(l.getProduit().getDesignation(), pxTaille) + "|"+ Limited(l.getProduit().getPrix()+ "", prixTaille) +"|"+ Limited(l.getQuantite()+ "", qteTaille) +"|"+ Limited(pxtotal+ "", prixTaille) +"|" + getChar(middle) + "|\n";
        }
        printableFacture = printableFacture + "|" + getChar(middle) + "|_________________|___________|_________|___________|" + getChar(middle) + "|\n";
        printableFacture = printableFacture + "|" + getChar(middle) + "| TOTAL                                 |"+ Limited(total + "", prixTaille) +"|" + getChar(middle) + "|\n";
        printableFacture = printableFacture + "|" + getChar(middle) + "|_______________________________________|___________|" + getChar(middle) + "|\n";
        printableFacture += "|_________________________________________________________________________________________________|\n";
     }
     
     private String getChar(int n){
        String res = "";
        int i  = 0;
        while (i < n){
            res = res + " ";
            i++;
        }
        return res;
     }

     private String Limited(String value, int n){
        if (value.length() > n){
            value = value.substring(0, n-1);
        }
        value = value + getChar(n - value.length());
        return value;
     }

     public void print(){
        System.out.println(printableFacture);
     }

     public String toString(){
        return printableFacture;
     }
}
