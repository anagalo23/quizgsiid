package com.alexis.quiz;



import com.alexi.quiz.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import dao.*;


public class Statistique extends Activity {
TextView moyenneNotes;
TextView moyenneEvaluations;
TextView nombreConnexion;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistique);
		
	
		nombreConnexion= (TextView) findViewById(R.id.nombreConnexion);
		moyenneNotes =(TextView) findViewById(R.id.moyenneJeu);
		moyenneEvaluations =(TextView) findViewById(R.id.moyenneEvaluation);
		
		nombreConnexion.setText("le nombre de parties jouées est :" + getIntent().getIntExtra("nombreJoue".toString(), 0));
		//moyenneNotes.setText("La moyenne notes : " + NoteDAO.getInstance().moyenneNotes());
		//moyenneEvaluations.setText("La moyenne évaluations : " + EvaluationDAO.getInstance().moyenneEvaluation());
		
			
	}

	
	
}
