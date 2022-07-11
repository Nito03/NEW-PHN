import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class creer extends JFrame{
    private JPanel fenetrePrinicipale;
    private JButton validerButton;
    private JTextPane code;
    private JTextPane designation;
    private JTextPane uniteMesure;
    private JTextPane dateExpiration;
    private JTextArea prix;

    public creer() {
        this.setSize(900, 600);
        this.setTitle("Création d'un produit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null) ;
        this.setContentPane(this.fenetrePrinicipale);
        this.setVisible(true);

        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produit<String> p = new Produit(code.getText(), designation.getText(), Double.parseDouble(prix.getText()), new Date(), uniteMesure.getText());

                new Connect().AjouterProduit(p);
            }
        });
    }
}
