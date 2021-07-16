package it.alessandro.mvc.model;

import java.sql.SQLException;
import java.util.List;

public interface AbstractProdottoDAO {

	void inserisciProdotto(Prodotto prod) throws SQLException;
	void cancellaProdotto(Prodotto prod) throws SQLException;
	void updateProdotto(Prodotto prod) throws SQLException;
	List<Prodotto> getProdottoPerFornitore(Fornitore forn) throws SQLException;
	public List<Prodotto> getAll() throws SQLException;
}
