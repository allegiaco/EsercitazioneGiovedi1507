package it.alessandro.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FornitoreDAO implements AbstractFornitoreDAO {


	public FornitoreDAO() {
	}

	public static final String QUERY_ONE = "SELECT nome, indirizzo, citta FROM negozio.fornitore WHERE codice_fornitore = ?";
	public static final String QUERY_ALL = "SELECT codice_fornitore as id, nome, indirizzo, citta FROM negozio.fornitore";
	public static final String INSERT_FORNITORE = "INSERT INTO negozio.fornitore (codice_fornitore, nome, indirizzo, citta) values (?, ?, ?, ?)";
	public static final String UPDATE_FORNITORE = "UPDATE negozio.fornitore SET nome = ?, indirizzo = ?, citta = ? WHERE codice_fornitore = ?";
	public static final String DELETE_FORNITORE_1 = "DELETE FROM negozio.prodotto WHERE fk_fornitore = ?";
	public static final String DELETE_FORNITORE_2 = "DELETE FROM negozio.fornitore WHERE codice_fornitore = ?";
	public static final String QUERY_CITY = "SELECT codice_fornitore, nome, indirizzo, FROM negozio.fornitore WHERE citta = ?";
	public static final String QUERY_PRODOTTO_PER_FORNITORE = "SELECT f.nome, codice_prodotto, p.nome as prodNome, p.descrizione, p.marca, p.prezzo "
			+ "FROM negozio.prodotto p "
			+ "INNER JOIN negozio.fornitore f on p.fk_fornitore = f.codice_fornitore WHERE f.codice_fornitore = ?";

	public Optional<Fornitore> get(long id) throws SQLException {
		try (Connection con = ConnectionHandler.getConnection(); PreparedStatement ps = con.prepareStatement(QUERY_ONE)) {
			ps.setLong(1, id);
			try(ResultSet rs = ps.executeQuery();) {
				Fornitore f;
			if(rs.next()) {
				f = new Fornitore(id, rs.getString("nome"), rs.getString("indirizzo"), rs.getString("citta"));
				return Optional.of(f);
			}
			return Optional.empty();
			}
			}
		}

	public List<Fornitore> getAll() throws SQLException {
		List<Fornitore> all = new ArrayList<Fornitore>();
		try (Connection con = ConnectionHandler.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(QUERY_ALL)) {
			while (rs.next()) {
				all.add(new Fornitore(rs.getLong("id"), rs.getString("nome"), rs.getString("indirizzo"),
						rs.getString("citta")));
			}
			return all;
		}
	}

	public void save(Fornitore forn) throws SQLException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_FORNITORE)) {
			ps.setLong(1, forn.getCodiceFornitore());
			ps.setString(2, forn.getNome());
			ps.setString(3, forn.getIndirizzo());
			ps.setString(4, forn.getCitta());

			ps.executeUpdate();
		}
	}

	public void update(Fornitore forn) throws SQLException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_FORNITORE)) {

			ps.setString(1, forn.getNome());
			ps.setString(2, forn.getIndirizzo());
			ps.setString(3, forn.getCitta());
			ps.setLong(4, forn.getCodiceFornitore());

			ps.executeUpdate();
		}
	}

	public void delete(Fornitore forn) throws SQLException {
		try (Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps1 = con.prepareStatement(DELETE_FORNITORE_1);
				PreparedStatement ps2 = con.prepareStatement(DELETE_FORNITORE_2);) {
			ps1.setLong(1, forn.getCodiceFornitore());
			ps2.setLong(1, forn.getCodiceFornitore());
			ps1.executeUpdate();
			ps2.executeUpdate();
		}
	}
	
	public List<Fornitore> getFornitoriPerCitta(String citta) throws SQLException {
		List<Fornitore> all = new ArrayList<Fornitore>();
		try(Connection con = ConnectionHandler.getConnection();
				PreparedStatement ps = con.prepareStatement(QUERY_CITY)) {
			ps.setString(1, citta);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				all.add(new Fornitore(rs.getLong("codice_fornitore"), rs.getString("nome"), rs.getString("indirizzo"), citta));
			}
			return all;
		}
		
	}
	
	
}
