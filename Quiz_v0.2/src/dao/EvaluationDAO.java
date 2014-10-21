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

	
	public float moyenneEvaluation(){
		float somme=0;
		if(singleton.eva.size()==0){
			return 2/5;
		}else{
		for(int i=0; i<singleton.eva.size();i++){
			somme+= singleton.eva.get(i);
		}
		return somme/singleton.eva.size();
		}
		
	}
	
	
	public void setEvalution(float a){
		eva.add(a);
	}

}
