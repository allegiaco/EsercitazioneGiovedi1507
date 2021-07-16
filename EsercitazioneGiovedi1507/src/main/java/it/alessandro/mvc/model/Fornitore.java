package it.alessandro.mvc.model;

public class Fornitore {
	private long codiceFornitore;
	private String nome;
	private String indirizzo;
	private String citta;

	public Fornitore(long codiceFornitore, String nome, String indirizzo, String citta) {
		this.codiceFornitore = codiceFornitore;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
	
	public Fornitore() {
		
	}

	public long getCodiceFornitore() {
		return codiceFornitore;
	}

	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	
	public void setCodiceFornitore(long codiceFornitore) {
		this.codiceFornitore = codiceFornitore;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return " [codiceFornitore=" + codiceFornitore + ", nome=" + nome + ", indirizzo=" + indirizzo
				+ ", citta=" + citta + "]";
	}
	
	
}
