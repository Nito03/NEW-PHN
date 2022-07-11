import javax.swing.JEditorPane;

public class PreviewFacture extends JEditorPane {
    private String HeaderText;
    private String BodyText;
    private String FooterText;
    private double total;

    public PreviewFacture(){
        super();
        this.setEditable( false );
        this.setContentType("text/html");
        HeaderText = "<table border=\"1\" align=\"center\" width=540><tr style=\"color: blue;\"><th>Article</th><th>Prix</th><th>Quantite</th><th>Total</th></tr>";
        FooterText = "</table></body></html>";
        
    }

    public void display(Detail articles){
        BodyText = "";
        double pxtotal;
        for(Ligne l : articles.lignes){
            pxtotal = l.getPrixTotal();
            total += pxtotal;
            BodyText += "<tr><td>" +l.getProduit().getDesignation() + "</td><td>" + l.getProduit().getPrix() + "</td><td>" +l.getQuantite()+ "</td><td>" + pxtotal + "</td></tr>";
        }
        BodyText += "<tr><td colspan=\"3\"><b>TOTAL</td><td>"+ total +"</td></tr>";
        String text = HeaderText + BodyText + FooterText;
        setText(text);
    }

}