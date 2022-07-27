package com.jimmy.vues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jimmy.classes.Activite;
import com.jimmy.classes.Aliment;
import com.jimmy.db.ActiviteDaoImpl;

public class Journee {
	private String nomUtilisateur;
	private LocalDate dateJournee;
	private List<Activite> listeActivite;
	private List<Aliment> listeAliment;

	public Journee(String nomUtilisateur, LocalDate dateJournee) {
		this.nomUtilisateur = nomUtilisateur;
		this.dateJournee = dateJournee;
		ActiviteDaoImpl activiteDaoImpl = new ActiviteDaoImpl();
		listeActivite = activiteDaoImpl.getByNomAndBetweenDateFromAndDateTo(nomUtilisateur, dateJournee, dateJournee);
	}

	public LocalDate getDateJournee() {
		return dateJournee;
	}

	public List<String> vueLigne() {
		List<String> listeLigne = new ArrayList<String>();
		String ligne = null;
		ligne = String.valueOf(dateJournee.getDayOfMonth());
		listeLigne.add(ligne);

		for (Activite activite : listeActivite) {
			ligne = activite.getTypeActivite() + " Kcal = " + activite.getNbCaloriesBrulees();
			listeLigne.add(ligne);
		}

		return listeLigne;

	}

}
