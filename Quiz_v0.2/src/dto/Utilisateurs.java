package dto;



public class Utilisateurs {

	String nom;
	String prenom;
	String photo;
	/**
	 * /**
	 * Cette partie n'est pas utilisée dans ce tp
	 * @param nom
	 * @param prenom
	 * @param photo
	 */
	public Utilisateurs(String nom, String prenom, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}


}
