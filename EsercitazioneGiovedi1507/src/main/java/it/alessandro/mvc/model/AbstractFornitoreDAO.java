package it.alessandro.mvc.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AbstractFornitoreDAO {

	Optional<Fornitore> get(long id) throws SQLException;
	List<Fornitore> getAll() throws SQLException;
	void save(Fornitore forn) throws SQLException;
	void update(Fornitore forn) throws SQLException;
	void delete(Fornitore forn) throws SQLException;
}
