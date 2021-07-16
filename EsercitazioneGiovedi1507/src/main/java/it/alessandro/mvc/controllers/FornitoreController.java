package it.alessandro.mvc.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.el.stream.Optional;

import it.alessandro.mvc.model.AbstractFornitoreDAO;
import it.alessandro.mvc.model.Fornitore;




public class FornitoreController {
	private AbstractFornitoreDAO dao;
	
	public FornitoreController(AbstractFornitoreDAO dao) {
		this.dao = dao;
	}
	
	public Destination inserisciFornitore(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String idString = request.getParameter("id");
		long id = Long.parseLong(idString);
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		
		Fornitore forn = new Fornitore(id, nome, indirizzo, citta);
		dao.save(forn);
		return new Destination("archivioFornitori.doi", true);
	}
	
	public Destination listaFornitori(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<Fornitore> result = dao.getAll();
		request.setAttribute("ALL_FORNITORI", result);
		return new Destination("listaFornitori.jsp", false);
	}
	
	public Destination uploadFornitore(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		long id = Long.parseLong(request.getParameter("id"));
		Fornitore forn = dao.get(id).orElseThrow(() -> new SQLException("Fornitore inesistente"));
		request.setAttribute("fornToUpdate", forn);
		return new Destination("updateFornitore.jsp", false);
	}
	
	public Destination updateFornitore(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String idString = request.getParameter("id");
		long id = Long.parseLong(idString);
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		
		Fornitore forn = new Fornitore(id, nome, indirizzo, citta);
		dao.update(forn);
		return new Destination("archivioFornitori.doi", true);
	}
	
public Destination deleteFornitore(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String idString = request.getParameter("id");
		long id = Long.parseLong(idString);
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		
		Fornitore forn = new Fornitore(id, nome, indirizzo, citta);
		dao.delete(forn);
		return new Destination("archivioFornitori.doi", true);
	}
}
