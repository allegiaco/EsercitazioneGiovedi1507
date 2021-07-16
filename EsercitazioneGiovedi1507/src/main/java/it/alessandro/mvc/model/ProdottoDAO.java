package it.alessandro.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO implements AbstractProdottoDAO {

	public ProdottoDAO() {
	}

	public static final String QUERY_ALL_PRODUCTS = "SELECT p.codice_prodotto, p.nome as nome_prod, p.descrizione as prod_desc, p.marca as prod_marca, p.prezzo as prod_prezzo, p.fk_fornitore, f.codice_fornitore as id_forn, f.nome as nome_forn, f.indirizzo as indirizzo_forn, f.citta as citta_forn FROM negozio.prodotto p INNER JOIN negozio.fornitore f on p.fk_fornitore = f.codice_fornitore";
	
	public static final String QUERY_PRODOTTO_PER_FORNITORE = "SELECT f.nome, codice_prodotto, p.nome as prodNome, p.descrizione, p.marca, p.prezzo FROM negozio.prodotto p "
			+ "INNER JOIN negozio.fornitore f on p.fk_fornitore = f.codice_fornitore WHERE f.codice_fornitore = ?";

	public static final String INSERT_PRODOTTO = "INSERT INTO negozio.prodotto (codice_prodotto, nome, descrizione, marca, prezzo, fk_fornitore) values (?, ?, ?, ?, ?, ?)";
	
	public static final String DELETE_PRODOTTO = "DELETE FROM negozio.prodotto WHERE codice_prodotto = ?";
	
	public static final String UPDATE_PRODOTTO = "UPDATE negozio.prodotto SET nome = ?, descrizione = ?, marca = ?, prezzo = ?, fk_fornitore = ? WHERE codice_prodotto = ?";
	
	public List<Prodotto> getProdottoPerFornitore(Fornitore forn) throws SQLException {
		List<Prodotto> results = new ArrayList<Prodotto>();
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(QUERY_PRODOTTO_PER_FORNITORE)) {
			ps.setLong(1, forn.getCodiceFornitore());
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					results.add(new Prodotto(rs.getLong("codice_prodotto"), rs.getString("prodNome"),
							rs.getString("descrizione"), rs.getString("marca"), rs.getDouble("prezzo"), forn));
				}
				return results;
			}
		}
	}
	
	public void inserisciProdotto(Prodotto prod) throws SQLException {
		try (Connection con = ConnectionHandler.getConnection();
		PreparedStatement ps = con.prepareStatement(INSERT_PRODOTTO)) {
			ps.setLong(1, prod.getCodiceProdotto());
			ps.setString(2, prod.getNome());
			ps.setString(3, prod.getDescrizione());
			ps.setString(4, prod.getMarca());
			ps.setDouble(5, prod.getPrezzo());
			ps.setLong(6, prod.getForn().getCodiceFornitore());
			
			ps.executeUpdate();
			
		}
	}
	
	public void cancellaProdotto(Prodotto prod) throws SQLException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps1 = con.prepareStatement(DELETE_PRODOTTO)) {
			ps1.setLong(1, prod.getCodiceProdotto());
			ps1.executeUpdate();
		}
	}
	
public void updateProdotto(Prodotto prod) throws SQLException {
	try (Connection con = ConnectionHandler.getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_PRODOTTO)) {

		ps.setString(1, prod.getNome());
		ps.setString(2, prod.getDescrizione());
		ps.setString(3, prod.getMarca());
		ps.setDouble(4, prod.getPrezzo());
		ps.setLong(5, prod.getForn().getCodiceFornitore());
		ps.setLong(6, prod.getCodiceProdotto());
		ps.executeUpdate();
	}
	}

public List<Prodotto> getAll() throws SQLException {
	List<Prodotto> all = new ArrayList<Prodotto>();
	try (Connection con = ConnectionHandler.getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_ALL_PRODUCTS);
			ResultSet rs = ps.executeQuery())
	{
		while (rs.next()) {
			all.add(new Prodotto(rs.getLong("codice_prodotto"), rs.getString("nome_prod"), rs.getString("prod_desc"),
					rs.getString("prod_marca"), rs.getDouble("prod_prezzo"), new Fornitore(rs.getLong("id_forn"), rs.getString("nome_forn"),
					rs.getString("indirizzo_forn"), rs.getString("citta_forn"))));
		}
//		while (rs.next()) {
//			all.add(new Prodotto(rs.getLong(1), rs.getString(2), rs.getString(3),
//					rs.getString(4), rs.getDouble(5), new Fornitore(rs.getLong(7), rs.getString(8),
//					rs.getString(9), rs.getString(10))));
//		}
		return all;
	}
}
}
