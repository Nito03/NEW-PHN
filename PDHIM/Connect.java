import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Connect {

    static Connection connection = null;


    public static void AjouterProduit(Produit<String> produit){
        String code, designation, uniteMesure;
        double prix;
        int nbreArticleAjouter;
        Date dateExpiration = new Date();

            code = produit.getCode();
            designation = produit.getDesignation();
            uniteMesure = produit.getUniteMesure();
            prix = produit.getPrix();

        try {
            Statement requete = connection.createStatement();

            // Insertion des données dans la base de données
            requete.executeUpdate("insert into produit(codeProduit,designation,uniteMesure,prixProduit, dateExpiration) " +
                    "values('"+code+"','"+designation+"','"+uniteMesure+"','"+prix+"', now() )");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MettreAjourProduit(Produit<String> produit){
        String codeProduit, designation, uniteMesure;
        double prix;

        codeProduit = produit.getCode();
        designation = produit.getDesignation();
        uniteMesure = produit.getUniteMesure();
        prix = produit.getPrix();

        try {
            Statement requete = connection.createStatement();

            // Insertion des données dans la base de données
            requete.executeUpdate("update produit set codeProduit='"+codeProduit+"',designation='"+designation+"',uniteMesure='"+uniteMesure+"',prixProduit='"+prix+"' where codeProduit='"+produit.getCode()+"'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet AfficherProduit(Produit<String> produit) {
        String codeProduit = produit.getCode();

        ResultSet result = null;
        try {
            Statement requete = connection.createStatement();

            result = requete.executeQuery("select codeProduit, designation, prix, dateExpiration from produit where codeProduit ='" + codeProduit + "'");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void SupprimerProduit(Produit<String> produit){

        String codeProduit = produit.getCode();

        try {
            Statement requete = connection.createStatement();

            // Supprimer un produit dans la base de données
            requete.executeQuery("delete from produit where codeProduit ='"+codeProduit+"'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    public static void Connexion(){
        try {

            //Pour ceux qui n'utilise pas mysql, le paramètre serverTimeZone n'est pas nécessaire
            //A la place de "jdbc:mysql://localhost:3306/java", remplacer par l'url de votre base de données
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/facturation", "root", "ROOT");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
