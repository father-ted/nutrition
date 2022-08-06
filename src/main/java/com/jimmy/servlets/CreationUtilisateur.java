package com.jimmy.servlets;

import java.io.IOException;

import com.jimmy.forms.actions.CreationUtilisateurForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreationUtilisateur() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CreationUtilisateurForm creationUtilisateurForm = new CreationUtilisateurForm(request);

		request.getRequestDispatcher("/WEB-INF/creationUtilisateur.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CreationUtilisateurForm creationUtilisateurForm = new CreationUtilisateurForm(request);
		boolean utilisateurCree = creationUtilisateurForm.creerUtilisateur();

		if (utilisateurCree) {

			request.getRequestDispatcher("/WEB-INF/nutrition.jsp").forward(request, response);

		} else {

			request.getRequestDispatcher("/WEB-INF/creationUtilisateur.jsp").forward(request, response);

		}
	}

}
