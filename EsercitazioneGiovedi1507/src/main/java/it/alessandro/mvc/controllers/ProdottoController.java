package it.alessandro.mvc.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.alessandro.mvc.model.AbstractProdottoDAO;
import it.alessandro.mvc.model.Prodotto;

public class ProdottoController {
	private AbstractProdottoDAO dao;

	public ProdottoController(AbstractProdottoDAO dao) {
		this.dao = dao;
	}

//	public Destination inserisciProdotto(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//
//		String idString = request.getParameter("id");
//		long id = Long.parseLong(idString);
//		String nome = request.getParameter("nome");
//		String indirizzo = request.getParameter("indirizzo");
//		String citta = request.getParameter("citta");
//
//		Prodotto prod = new Prodotto(id, nome, indirizzo, citta);
//		dao.
//		return new Destination("archivioFornitori.doi", true);
//	}

public Destination listaProdotti(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	List<Prodotto> all = dao.getAll();
	request.setAttribute("ALL_PRODOTTI", all);
	return new Destination("listaProdotti.jsp", false);
}
}
