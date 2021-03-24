package biblio.domain;

import java.time.LocalDate;
import java.util.Date;

public class Employe extends Utilisateur
{
	private String codeMatricule;
	private EnumCategorieEmploye categorieEmploye;
	
	
	public Employe(int idUtilisateur,String nom, String prenom,String dateNaissance,String sexe, String pwd, String pseudonyme, String codeMatricule, EnumCategorieEmploye categorieEmploye)
	{
		super(idUtilisateur,nom, prenom, dateNaissance,sexe,pwd, pseudonyme);
		setCodeMatricule(codeMatricule);
		setCategorieEmploye(categorieEmploye);
	}


	@Override
	public String toString() {
		return super.toString()+"  Matricule = " + codeMatricule + ".";
	}


	public String getCodeMatricule() {
		return codeMatricule;
	}


	public void setCodeMatricule(String codeMatricule) {
		this.codeMatricule = codeMatricule;
	}


	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}


	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {
		this.categorieEmploye = categorieEmploye;
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