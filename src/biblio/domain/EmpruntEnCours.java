package biblio.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//Source file: D:\\stagiaire\\Java\\generationCodeRationalRose\\biblioAyawo\\EmpruntEnCours.java


/**
 * Un EmpruntEnCours conceptualise l'emprunt pour ce qui concerne l'opération de 
 * gestion de la sortie du livre du fonds de la bibliothèque.
 */
public class EmpruntEnCours 
{
	/** Date d'emprunt d'un exemplaire*/
	private LocalDate dateEmprunt;
	/** format de la date d'emprunt*/
	@SuppressWarnings("nonUtilise")
	/**formatteur de la date*/
	public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	/** Utilisateur qui emprunte*/
	Utilisateur utilisateur;
	/**Exemplaire emprunt�*/
	Exemplaire exemplaire;
	/** Disponibilite du livre*/
	private EnumStatusExemplaire EnumStatusExemplaire;
	

	   public EmpruntEnCours(Utilisateur ut,Exemplaire exemp) 
	   {
		   setEmprunteur(ut);
		   setExemplaire(exemp);
		   setDateEmprunt(LocalDate.now().format(dtf));
	   }
	   
	   @Override
	public String toString() {
		return "Emprunt En Cours : nom = " + utilisateur.getNom() + ", date Emprunt=" + dateEmprunt + ", exemplaire=" + exemplaire + ".";
	}

	private void setEmprunteur(Utilisateur ut) {
		   this.utilisateur=ut;
	   }
	   
	   private void setExemplaire(Exemplaire ex) {
		    ex.setStatus(EnumStatusExemplaire.PRETE);
		    this.exemplaire=ex;
		  
	   }
	   
	   public Exemplaire getExemplaire() {
		return exemplaire;
	}

	private void setDateEmprunt(String d) {
		   
		   this.dateEmprunt=LocalDate.parse(d,dtf);
	   }

	   public Utilisateur getUtilisateur() {
			return utilisateur;
		}

		public void setUtilisateur(Utilisateur utilisateur) {
			this.utilisateur = utilisateur;
		}
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	   
	public boolean insertEmpruntEnCours(EmpruntEnCours emprunt) {
		return true;
	}
	
	   
	}