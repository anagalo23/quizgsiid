package dto;

public class Thematique {

	int id_th;
	String theme;
	
	
	
	/**
	 * @param id_th
	 * @param theme
	 */
	public Thematique(int id_th, String theme) {
		super();
		this.id_th = id_th;
		this.theme = theme;
	}
	/**
	 * @return the id_th
	 */
	public int getId_th() {
		return id_th;
	}
	/**
	 * @param id_th the id_th to set
	 */
	public void setId_th(int id_th) {
		this.id_th = id_th;
	}
	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Thematique [id_th=" + id_th + ", theme=" + theme + "]";
	}
	
	
	
}
