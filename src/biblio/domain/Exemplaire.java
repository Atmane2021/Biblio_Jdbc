package biblio.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;

//Source file: D:\\stagiaire\\Java\\generationCodeRationalRose\\biblioAyawo\\Exemplaire.java


/**
 * Un Exemplaire conceptualise la notion de livre au sens pysique du terme. Il 
 * s'agit bien de l'objet que l'adh�rent dans la main lorsqu'il se pr�sente au 
 * biblioth�caire pour l'enregistrement du pr�t.
 */
public class Exemplaire 
{
	private int idExemplaire;
	private LocalDate dateAchat;
	private EnumStatusExemplaire status;
	public DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.FRANCE );
	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	private String isbn;
	
	public Exemplaire(int idExemplaire,String dateAchat,EnumStatusExemplaire status,String isbn) {
		this.setIsbn(isbn);
		this.setIdExemplaire(idExemplaire);
		this.setDateAchat(dateAchat);
		this.setStatus(status);
		
	}
	public Exemplaire() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Exemplaire [idExemplaire = " + idExemplaire + ", dateAchat=" + dateAchat.format(df) + ", status=" + status + ", isbn=" + isbn + "]";
	}

	public String getIsbn() {
		
		return isbn;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(String dateAchat) {
		this.dateAchat = LocalDate.parse(dateAchat);
	}

	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public EnumStatusExemplaire getStatus() {
		return status;
	}

	public void setStatus(EnumStatusExemplaire status) {
		this.status=status;
	}
	

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
