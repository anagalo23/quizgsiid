package dto;


public class Evaluation {

	
	int id_eval;
	float noteAppli;
	/**
	 * @param id_eval
	 * @param note
	 */
	public Evaluation(int id_eval, float note) {
		super();
		this.id_eval = id_eval;
		this.noteAppli = note;
	}
	/**
	 * @return the id_eval
	 */
	public int getId_eval() {
		return id_eval;
	}
	/**
	 * @param id_eval the id_eval to set
	 */
	public void setId_eval(int id_eval) {
		this.id_eval = id_eval;
	}
	/**
	 * @return the note
	 */
	public float getNote() {
		return noteAppli;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(float note) {
		this.noteAppli = note;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Evaluation [id_eval=" + id_eval + ", note=" + noteAppli + "]";
	}	
	
}
