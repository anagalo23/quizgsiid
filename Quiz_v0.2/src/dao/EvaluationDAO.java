package dao;


import java.util.ArrayList;

public class EvaluationDAO {

	
	private static EvaluationDAO singleton;
	
	
	ArrayList<Float> eva = new ArrayList<Float> ();

	public static EvaluationDAO getInstance()
	{
		if(EvaluationDAO.singleton==null)
			singleton=new EvaluationDAO();
		return singleton;
	}
	
	private EvaluationDAO() {
	}

	

}
