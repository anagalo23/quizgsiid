package dto;

public class Reponse {

	
		int id_rep;
		String reponse;
		int valeur_rep;
		int id_question;
		
		
		
		/**
		 * @param id_rep
		 * @param reponse
		 * @param valeur_rep
		 * @param id_question
		 */
		public Reponse(String reponse, int valeur_rep, int id_question) {
			this.reponse = reponse;
			this.valeur_rep = valeur_rep;
			this.id_question = id_question;
		}
		/**
		 * @return the id_rep
		 */
		public int getId_rep() {
			return id_rep;
		}
		/**
		 * @param id_rep the id_rep to set
		 */
		public void setId_rep(int id_rep) {
			this.id_rep = id_rep;
		}
		/**
		 * @return the reponse
		 */
		public String getReponse() {
			return reponse;
		}
		/**
		 * @param reponse the reponse to set
		 */
		public void setReponse(String reponse) {
			this.reponse = reponse;
		}
		/**
		 * @return the valeur_rep
		 */
		public int getValeur_rep() {
			return valeur_rep;
		}
		/**
		 * @param valeur_rep the valeur_rep to set
		 */
		public void setValeur_rep(int valeur_rep) {
			this.valeur_rep = valeur_rep;
		}
		
		/**
		 * @return the id_question
		 */
		public int getId_question() {
			return id_question;
		}
		/**
		 * @param id_question the id_question to set
		 */
		public void setId_question(int id_question) {
			this.id_question = id_question;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Reponse [id_rep=" + id_rep + ", reponse=" + reponse
					+ ", valeur_rep=" + valeur_rep + ", id_question="
					+ id_question + "]";
		}
		
		
		
	

}
