
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

class BaseWriter {
        protected int current_adr, current_client,
                 current_cat, current_detail,
                 current_facture, current_ligne,
                 current_prd;
        protected File cur_f = new File("Data/current_id.dat");


    public void get_current_id() {
        try
        {
            Scanner scan_cur = new Scanner(new FileReader(cur_f));
            int current_value;
            while(scan_cur.hasNextLine())
            {
                String line = scan_cur.nextLine();
                String[] elems = line.split("=");
                current_value = Integer.valueOf(elems[1]).intValue();
                if(elems[0].equals("adresses"))
                    current_adr = current_value;
                else if(elems[0].equals("clients"))
                    current_client = current_value;
                else if(elems[0].equals("categories"))
                    current_cat = current_value;
                else if(elems[0].equals("details"))
                    current_detail = current_value;
                else if(elems[0].equals("factures"))
                    current_facture = current_value;
                else if(elems[0].equals("lignes"))
                    current_ligne = current_value;
                else if(elems[0].equals("produits"))
                    current_prd = current_value;
            }
            scan_cur.close();
        } catch(IOException e) {
            System.out.println("[Writer] : Error lors de la recuperation du current id");
        }
    }//End of method get_current_id

    public void update_current_id() {
        try
        {
            BufferedWriter write_cur = new BufferedWriter(new FileWriter(cur_f));
            write_cur.write("adresses="+current_adr+
                        "\nclients="+current_client+
                        "\ncategories="+current_cat+
                        "\ndetails="+current_detail+
                        "\nfactures="+current_facture+
                        "\nlignes="+current_ligne+
                        "\nproduits="+current_prd+"\n");
            write_cur.close();
        } catch(IOException e) {
            System.err.println("[Writer] : Echec lors de la mis a jours de current id");
        }
    }//End of update_current_id

}
