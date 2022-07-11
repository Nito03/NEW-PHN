import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Calendar;
import java.text.*;
import java.util.Date;

public class Editor extends JFrame {
    private  JPanel containerEditor;
    private JEditorPane helpPane;
    private String HeaderText;
    private String BodyText;
    private String FooterText;
    private double total;


    // --- Construction de l'interface graphique ---
    public Editor(){
        super( "Editeur Facture" );
        this.setSize( 800, 500 );
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        // --- On crée le composant d'affichage JEditorPane ---
        helpPane = new JEditorPane();
        helpPane.setEditable( false );

        //helpPane.setPage( "file:facture.html" );
        // definition du type de contenu
        helpPane.setContentType("text/html");
        BodyText = "<table border=\"1\" align=\"center\" width=400><tr style=\"color: blue;\"><th>Article</th><th>Prix</th><th>Quantite</th><th>Total</th></tr>";
        FooterText = "</table></body></html>";
        JScrollPane scrollPane = new JScrollPane( helpPane );
                
        // --- On récupère le contentPane et on y ajoute notre composant ---
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.add( scrollPane, BorderLayout.CENTER );
    }

    public void setHeaderContent(Client cl, String cp){
        HeaderText = "<html><body><p>Nom : " + cl.getPrenom() + " " + cl.getNom() + "&#9;&#9;&#9;&#9;&#9;&#9;&#9;&#9;Date : " + getDate() +"</p><p>Numero : " + cl.getNumero() + "</p><p>Adresse : "+ cl.getAdresse() + "</p><hr><h1 align=\"center\">"+ cp +"</h1>";

    }

    public void setFooterContent(String txt){
        FooterText = txt;
    }

    public void display(Facture facture, String company){
        setHeaderContent(facture.getClient(), company);
        Detail detail = facture.getDetail();
        double pxtotal;
        for(Ligne l: detail.lignes){
            pxtotal = l.getPrixTotal();
            total += pxtotal;
            BodyText += "<tr><td>" +l.getProduit().getDesignation() + "</td><td>" + l.getProduit().getPrix() + "</td><td>" +l.getQuantite()+ "</td><td>" + pxtotal+ "</td></tr>";
        }
        BodyText += "<tr><td colspan=\"3\"><b>TOTAL</td><td>"+ total +"</td></tr>";
        String fact_text = HeaderText + BodyText + FooterText;
        helpPane.setText(fact_text);
    }

    private String getDate(){
        // retourne la date
        DateFormat Date = DateFormat.getDateInstance();
        Calendar cal = Calendar.getInstance();
        String datefmt = Date.format(cal.getTime());
        return datefmt;
    }
    
    // --- Point d'entrée du programme ---
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );

    }
}
