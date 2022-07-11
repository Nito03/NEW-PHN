
public class Adresse {
	private String avenue;
	private String numero;
	private String cellule;
	private String quartier;
	private String commune;
	private String ville;
	private String pays;

	public Adresse(String n, String p, String av, String q, String v){
		avenue = av;
		numero = n;
		pays = p;
		quartier = q;
		ville = v;
	}
	
	public void setAvenue(String a){
		avenue = a;
	}

	public void setNumero(String a){
		numero = a;
	}

	public void setQuartier(String a){
		quartier = a;
	}

	public void setCommune(String a){
		commune = a;
	}

	public void setCellule(String a){
		cellule = a;
	}

	public void setVille(String a){
		ville = a;
	}

	public void setPays(String a){
		pays = a;
	}

	public String getVille(){
		return ville;
	}
	
	public String getPays(){
		return pays;
	}

	public String getCellule(){
		return cellule;
	}

	public String getAvenue(){
		return avenue;
	}

	public String getCommune(){
		return commune;
	}

	public String getQuartier(){
		return quartier;
	}

	public String getNumero(){
		return numero;
	}

	public String toString(){
		return "C/" + commune + ", Q/" + quartier + ", Av/" + avenue + ", N/" + numero;
	}
}
