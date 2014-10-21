package dao;


import java.util.ArrayList;

public class NoteDAO {

	private static NoteDAO singleton;
	
	ArrayList<Integer> n = new ArrayList<Integer>();

	public static NoteDAO getInstance()
	{
		if(NoteDAO.singleton==null)
			singleton=new NoteDAO();
		return singleton;
	}
	
	/**
	 * 
	 */
	private NoteDAO() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public  float moyenneNotes(){
		int somme=0;
		if(singleton.n.size()==0){
			return 0;
		}else{
		for(int i=0; i<singleton.n.size();i++){
			somme+= (Integer)singleton.n.get(i);
		}
		return (float)somme/singleton.n.size();
		}
		
	}
	
	public void setNote(int a){
		n.add(a);
	}
	
}
