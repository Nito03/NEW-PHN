import java.util.Date;

public class Produit<T>{
    private String code;
    private String designation;
    private double prix;
    private T uniteMesure;
    private Date dateExpiration;

    public Produit(String c, String d,double px, Date date, T um){
        code = c;
        designation = d;
        prix = px;
        dateExpiration = date;
        uniteMesure = um;
    }



    public double getPrix(){
        return prix;
    }

    public String getDesignation(){
        return designation;
    }

    public String getCode(){
        return code;
    }

    public Date getDateExpiration(){
        return dateExpiration;
    }

    public T getUniteMesure(){
        return uniteMesure;
    }

}
