package dto;

public class Nbpj {

	// Nombre de parties jouées
	int id_nbpj; 
	int note;
	/**
	 * @param id_nbpj
	 * @param note
	 */
	public Nbpj(int note) {
		super();
		this.note = note;
	}
	/**
	 * @return the id_nbpj
	 */
	public int getId_nbpj() {
		return id_nbpj;
	}
	/**
	 * @param id_nbpj the id_nbpj to set
	 */
	public void setId_nbpj(int id_nbpj) {
		this.id_nbpj = id_nbpj;
	}
	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nbpj [id_nbpj=" + id_nbpj + ", note=" + note + "]";
	}
	
	
	
}
