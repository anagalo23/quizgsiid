package dto;

import java.util.ArrayList;

public class Notes {
	
	ArrayList<Integer> note = new ArrayList<Integer>();

	/**
	 * @param note
	 */
	public Notes(ArrayList<Integer> note) {
		super();
		setNote(note);
	}

	/**
	 * @return the note
	 */
	public  ArrayList<Integer> getNote() {
		return this.note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(ArrayList<Integer> n) {
		this.note.addAll(n);
	}
	

}
