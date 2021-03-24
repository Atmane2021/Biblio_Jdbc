package testsDeBaseJoptionPane;


import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import biblio.dao.ExemplaireDao;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import biblio.dao.*;
import biblio.domain.*;

public class TestDeBase {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		
		
	

		String[] choix = {"Consulter le livre", "Consulter un utilisateur", "Emprunter un livre", "Disponibilité d'un exemplaire","Rendre un livre", "Emprunts en cours","Archives"};
		int option = JOptionPane.showOptionDialog(null, "Faites votre choix", "Bibliothèque", 0, JOptionPane.QUESTION_MESSAGE, null, choix, "Consulter un livre");
		
		
		if(option == 0 ) {
			ExemplaireDao exemplaireJOption = new ExemplaireDao(PingJdbc.getConnectionByProperties());
			String c = JOptionPane.showInputDialog(null, "Entrez l'ID de l'exemplaire (un nombre entre 1 et 8) : ","Consultation d'un livre", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(exemplaireJOption.findByKey(Integer.parseInt(c)));
		} else if(option == 1) {
			UtilisateursDao utilisateurJOption = new UtilisateursDao(PingJdbc.getConnectionByProperties());
			String d = JOptionPane.showInputDialog(null, "Entrez l'ID d'un utilisateur ( Employé = 2,3,6 et Adhérent = 1,4,5,7,8) : ","Consultation d'un utilisateur", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(utilisateurJOption.findByKey(Integer.parseInt(d)));
		} else if (option == 2) {
			UtilisateursDao utilisateurJOption = new UtilisateursDao(PingJdbc.getConnectionByProperties());
			ExemplaireDao exemplaireJOption = new ExemplaireDao(PingJdbc.getConnectionByProperties());
			String x = JOptionPane.showInputDialog(null, "Entrez l'ID de l'emprunteur ( Employé = 2,3,6 et  Adhérent = 1,4,5,7,8) : ","Réalisation d'un emprunt", JOptionPane.INFORMATION_MESSAGE);
			String y = JOptionPane.showInputDialog(null, "Entrez l'ID de l'exemplaire emprunté : ","Réalisation d'un emprunt", JOptionPane.INFORMATION_MESSAGE);
			EmpruntEnCoursDao empruntEnCoursDao = new EmpruntEnCoursDao(PingJdbc.getConnectionByProperties());
			System.out.println(empruntEnCoursDao.insertEmpruntEnCours(new EmpruntEnCours(utilisateurJOption.findByKey(Integer.parseInt(x)), exemplaireJOption.findByKey(Integer.parseInt(y)))));
		} else if (option == 3) {
			EmpruntEnCoursDao empruntEnCours = new EmpruntEnCoursDao(PingJdbc.getConnectionByProperties());
			String e = JOptionPane.showInputDialog(null, "Entrez l'ID de l'exemplaire à rendre ( de 1 à 8 ): ","Retour d'un emprunt", JOptionPane.INFORMATION_MESSAGE);
			empruntEnCours.removeEmpruntEnCours(Integer.parseInt(e));
			//EmpruntArchiveDao empruntArchive = new EmpruntArchiveDao(PingJdbc.getConnectionByProperties());
		} else if (option == 4) {
			ExemplaireDao exemplaireDispoJOption = new ExemplaireDao(PingJdbc.getConnectionByProperties());
			for(Exemplaire e : exemplaireDispoJOption.findAll())
			System.out.println(e);
		} else if (option == 5) {
			EmpruntArchiveDao empruntArchive = new EmpruntArchiveDao(PingJdbc.getConnectionByProperties());
			for(EmpruntArchive emp : empruntArchive.findAll())
			System.out.println(emp);
		} else if (option == 6) {
			EmpruntArchiveDao empruntArchive = new EmpruntArchiveDao(PingJdbc.getConnectionByProperties());
			String f = JOptionPane.showInputDialog(null, "Entrez l'ID de l'emprunteur (Employé = 2,3,6 ou Adhérent = 1,4,5,7,8) : ","Visualisation des archives", JOptionPane.INFORMATION_MESSAGE);
			for(EmpruntArchive emp1 : empruntArchive.findByKey(Integer.parseInt(f)))
			System.out.println(emp1);
		} else if (option == 7) {
			String g = JOptionPane.showInputDialog(null, "Entrez l'ID de l'emprunteur (Employé = 2,3,6 ou Adhérent = 1,4,5,7,8) : ","Visualisation des emprunts en cours", JOptionPane.INFORMATION_MESSAGE);
			EmpruntEnCoursDao eEc = new EmpruntEnCoursDao(PingJdbc.getConnectionByProperties());
			for(EmpruntEnCoursDb empCours: eEc.findByUtilisateur(Integer.parseInt(g)))
			System.out.println(empCours);
		} else if (option == 8) {
			String h = JOptionPane.showInputDialog(null, "Entrez l'ID de l'emprunteur (Employé = 2,3,6 ou Adhérent = 1,4,5,7,8) : ","Retards", JOptionPane.INFORMATION_MESSAGE);
			EmpruntEnCoursDao eEc1 = new EmpruntEnCoursDao(PingJdbc.getConnectionByProperties());
			

		}
		
		
	}

}