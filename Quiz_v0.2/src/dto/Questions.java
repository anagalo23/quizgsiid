package dto;

public class Questions {

	int id_quest;
	String question;
	int id_the;
	/**
	 * @param id_quest
	 * @param question
	 * @param id_rep
	 */
	public Questions(int id_quest, String question, int id_rep) {

		this.id_quest = id_quest;
		this.question = question;
		this.id_the = id_rep;
	}
	/**
	 * @return the id_quest
	 */
	public int getId_quest() {
		return id_quest;
	}
	/**
	 * @param id_quest the id_quest to set
	 */
	public void setId_quest(int id_quest) {
		this.id_quest = id_quest;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the id_rep
	 */
	public int getId_rep() {
		return id_the;
	}
	/**
	 * @param id_rep the id_rep to set
	 */
	public void setId_rep(int id_rep) {
		this.id_the = id_rep;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Questions [id_quest=" + id_quest + ", question=" + question
				+ ", id_rep=" + id_the + "]";
	}
	
	
}
