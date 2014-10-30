package com.alexis.quiz;



import com.alexi.quiz.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import dao.*;


public class Statistique extends Activity implements OnClickListener {
	TextView moyenneNotes;
	TextView moyenneEvaluations;
	TextView nombreConnexion;
	Button statToAccueil;
	//Instanciation des classes NbpjDAO et EvaluationDAO
	NbpjDAO nbpj= new NbpjDAO(this);
	EvaluationDAO eval =new EvaluationDAO(this);
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
		statToAccueil=(Button) findViewById(R.id.statToAccueil);




		// Affichage nombre de parties jouées depuis le debut de l'aplications
		nbpj.open();
		if(nbpj.getEvaluation().size()==0)
			nombreConnexion.setText("Le nombre de parties jouées est : " + 0);
		else
			nombreConnexion.setText("Le nombre de parties jouées est : " + nbpj.getEvaluation().size());

		
		//affichage moyenne des notes


		if(nbpj.getEvaluation().size()==0)
			moyenneNotes.setText("La moyenne des notes est : " + 0);
		else {
			float sommeNotes=0;
			for(int i=0; i<nbpj.getEvaluation().size(); i++){

				sommeNotes+= (float)nbpj.getEvaluation().get(i).getNote();
			}
			moyenneNotes.setText("La moyenne des notes est : " + sommeNotes);
		}
		nbpj.close();

		//Affichage moyenne des evaluations
		eval.open();
		if(eval.getEvaluation().size()==0)
			moyenneEvaluations.setText("La moyenne des évaluations est : " + 0);
		else{
			float sommeEva=0;
			for(int i=0; i<eval.getEvaluation().size();i++){
				sommeEva+= eval.getEvaluation().get(i).getNoteAppli();
			}

			moyenneEvaluations.setText("La moyenne des évaluations est : " + sommeEva);

		}
		eval.close();


	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if(v==statToAccueil){

			Intent theIntent = new Intent(this, MainActivity.class);
			startActivity(theIntent);
		}
	}


}
