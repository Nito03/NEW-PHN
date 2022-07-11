import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class connectGrud extends JFrame {
    private JButton créerUnProduitButton;
    private JButton supprimerUnProduitButton;
    private JButton mettreÀJourUnButton;
    private JButton voirLesDétailsDButton;
    private JPanel fenetrePrincipale;

    public connectGrud() {

        this.setSize(700, 200);
        this.setTitle("Facturation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null) ;
        event();
        this.setContentPane(this.fenetrePrincipale);
        this.setVisible(true);

    }

    public void event(){
        créerUnProduitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new creer();
            }
        });

        supprimerUnProduitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mettreÀJourUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        voirLesDétailsDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



    public static void main(String[] args) {
        new connectGrud();
    }

}


