import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JPanel partOne = new JPanel();
    private JPanel partTwo = new JPanel();

    private JPanel c;
    private JLabel title;
    private JLabel title2;
    private JLabel name;
    private JTextField tname;
    private JLabel pre;
    private JTextField tpre;
    private JLabel mno;
    private JTextField tmno;
    private JLabel add;
    private JTextArea tadd;
    private JButton reset;
    private JButton enter;
    private JButton imprimer;
    private PreviewFacture tout;
    private JLabel res;
    private JComboBox patternList;
    private JComboBox intList;
    private JScrollPane scroll;

    private Facture fact = new Facture();
    private Client client = new Client();
    private Detail detail = new Detail();

    String[] tab_string = new String[]{"Stylo", "Crayon", "Cahier", "Sac", "Uniforme"};
    String[] tab_int = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    public Fenetre(){
        fact.setDetail(detail);
        fact.setClient(client);
        this.setSize(1200, 900);
        this.setTitle("Facturation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initComposant();
        this.setLocationRelativeTo(null) ;
        this.setContentPane(this.c);
        this.setVisible(true);
    }

    public void initComposant(){

        c =(JPanel) getContentPane();
        c.setLayout(null);

        title = new JLabel("Client");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        c.add(title);

        title2 = new JLabel("Article(s)");
        title2.setFont(new Font("Arial", Font.PLAIN, 30));
        title2.setSize(300, 30);
        title2.setLocation(600, 30);
        c.add(title2);

        name = new JLabel("Nom");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        pre = new JLabel("Prenom");
        pre.setFont(new Font("Arial", Font.PLAIN, 20));
        pre.setSize(100, 20);
        pre.setLocation(100, 150);
        c.add(pre);

        tpre = new JTextField();
        tpre.setFont(new Font("Arial", Font.PLAIN, 15));
        tpre.setSize(190, 20);
        tpre.setLocation(200, 150);
        c.add(tpre);

        mno = new JLabel("Numero");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 200);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 20);
        tmno.setLocation(200, 200);
        c.add(tmno);


        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 250);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(250, 100);
        tadd.setLocation(200, 280);
        tadd.setLineWrap(true);
        c.add(tadd);

        tout = new PreviewFacture();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(1100, 300);
        tout.setLocation(50, 400);
        tout.setEditable(true);
        scroll = new JScrollPane(tout);

        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 650);
        c.add(res);

        enter = new JButton("Ajouter");
        enter.setSize(new Dimension(100, 40));
        enter.setFont(new Font("Times New Roman", Font.BOLD, 15));
        enter.setLocation(680, 300);
        enter.addActionListener(new validerClient());

        imprimer = new JButton("Imprimer");
        imprimer.setSize(new Dimension(100, 40));
        imprimer.setFont(new Font("Times New Roman", Font.BOLD, 15));
        imprimer.setLocation(800, 750);
        imprimer.addActionListener(new validerClient());


        reset = new JButton("Annuler");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 40);
        reset.setLocation(1000, 750);
        reset.addActionListener(new validerClient());
        c.add(reset);


        patternList = new JComboBox(this.tab_string);
        patternList.setSize(new Dimension(200, 40));
        patternList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        patternList.setLocation(580, 100);

        intList = new JComboBox(this.tab_int);
        intList.setSize(new Dimension(200, 40));
        intList.setFont(new Font("Times New Roman", Font.BOLD, 15));
        intList.setLocation(800, 100);


        c.add(patternList);
        c.add(intList);
        c.add(enter);
        c.add(imprimer);
        c.add(partTwo);
    }

    private class  validerClient implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String patternValue = patternList.getSelectedItem().toString();
            String intValue = intList.getSelectedItem().toString();
            if (e.getSource() == enter) {
                String nom;
                nom = tname.getText();
                String prenom = tpre.getText();
                String numero = tmno.getText();
                String address = tadd.getText();

                client.setNom(nom);
                client.setPrenom(prenom);
                client.setNumero(numero);
                client.setAdresse(new Adresse("8", "Congo", "Kinkole", "Bel-Air", "L'shi"));

                detail.ajouterLigne(new Ligne(1, intValue, new Produit<String>(numero, patternValue, 500, new Date(), "Kg")));
                tout.display(detail);
                res.setText("Ajout Réussi");
            } else if (e.getSource() == reset) {
                String def = "";
                tname.setText(def);
                tpre.setText(def);
                tadd.setText(def);
                tmno.setText(def);
                res.setText(def);
                tout.setText(def);
            } else if (e.getSource() == imprimer){
                Editor editor = new Editor();
                editor.display(fact, "Jambo");

                Facture fact = new Facture();
                fact.setNumero(1);
                fact.setClient(client);
                fact.setDetail(detail);

                Editor frame = new Editor();
                frame.display(fact, "Jambo MART");
                frame.setVisible(true);
            }
        }
    }
}

