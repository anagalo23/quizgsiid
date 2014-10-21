package dto;

import java.util.ArrayList;

public class Evaluation {

	
	ArrayList<Float> evaluation = new ArrayList<Float>();

	/**
	 * @param evaluation
	 */
	public Evaluation(ArrayList<Float> evaluation) {
		super();
		setEvaluation(evaluation);

	}

	/**
	 * @return the evaluation
	 */
	public ArrayList<Float> getEvaluation() {
		return evaluation;
	}

	/**
	 * @param evaluation the evaluation to set
	 */
	public void setEvaluation(ArrayList<Float> evaluation2) {
		this.evaluation.addAll(evaluation);
	}
	
	
	
	
}
