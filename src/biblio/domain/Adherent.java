package biblio.domain;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Adherent extends Utilisateur
{
	private String telephone;
	private String cat;
	private int nbMaxPrets = 3;
	private int dureeMaxPrets =15;
		
	public Adherent(int idUtilisateur,String nom, String prenom,String pwd,String pseudonyme,String dateNaissance,String sexe,String cat, String telephone)
	{
		super(idUtilisateur,nom, prenom, dateNaissance,sexe, pwd, pseudonyme);
		setCategorieUtilisateur(cat);
		setTelephone(telephone);
		setCat(cat);
		
	}

	
	@Override
	public String toString() {
		return "Categorie d'utilisateur = " + getCat()+", Nom = " + getNom() + ", Prenom = " + getPrenom()+ " numero de telephone = " + telephone + ", id de l'utilisateur = " + getidUtilisateur() + ", pseudo = " + getpseudonyme() + ", genre = "
				+ getSexe() +".";
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getNbMaxPrets() {
		return nbMaxPrets;
	}

	public void setNbMaxPrets(int nbMaxPrets) {
		this.nbMaxPrets = nbMaxPrets;
	}

	public int getDureeMaxPrets() {
		return dureeMaxPrets;
	}

	public void setDureeMaxPrets(int dureeMaxPrets) {
		this.dureeMaxPrets = dureeMaxPrets;
	}

	public boolean isConditionsPretAcceptees()
	{
		
		if((getNbEmpruntsEnCours()>=nbMaxPrets) )
		{
			System.out.println("Vous avez d?pass? les 3 emprunts autoris?s !!");
			return false; 
		}
		else if(( this.getNbRetards()>dureeMaxPrets ))
		{
			System.out.println("Vous ne pouvez emprunter de nouveau, car un de vos emprunt est en retard");
			return false; 
		}
		return true;
	}

	public int getNbRetards()
	{	if( getNbEmpruntsEnCours()>0 ) {
		for(int i=0 ;  i<getEmpruntenCours().size() ; i++) {
		long dif = ChronoUnit.DAYS.between(LocalDate.parse(getEmpruntenCours().get(i).getDateEmprunt().toString()), LocalDate.now());		
		if( (int) dif > 15 && getEmpruntenCours().get(i).getUtilisateur().getidUtilisateur()==this.getidUtilisateur()) return (int) dif;
		}
	}
		return 0;
		
	}
	
	@Override
	public void addEmpruntEnCours (EmpruntEnCours ep) throws Exception
	{
		if(isConditionsPretAcceptees()==true)
		{
			emprunt.add(ep);
			System.out.println("emprunt autoris?");
		}
		else System.out.println("REFUSE");
		
	}
	
	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	@Override
	public Integer getIdUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPwd() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPseudonyme() {
		// TODO Auto-generated method stub
		return null;
	}


	
}