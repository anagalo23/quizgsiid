package com.alexis.quiz;

import com.alexi.quiz.R;

import dao.EvaluationDAO;
import dto.Evaluation;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Evaluer extends Activity implements OnRatingBarChangeListener, OnClickListener  {
	TextView tv=null;
	Button evalu=null;
	RatingBar r;
	EvaluationDAO evalDAO =new EvaluationDAO(this);


	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluer);

		evalu=(Button) findViewById(R.id.validerEvaluation);
		evalu.setOnClickListener(this);

		r=(RatingBar) findViewById(R.id.evaluerAppli);
		r.setRating((float) 3.5);

		tv= (TextView) findViewById(R.id.textViewNote);
		tv.setText("La note est :" + r.getRating() +"/"+ r.getNumStars());
		r.setOnRatingBarChangeListener(this);
	}
	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		// TODO Auto-generated method stub

		tv.setText("La note est :" + rating +"/"+ ratingBar.getNumStars());


	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		if(v==evalu){
			evalDAO.open();
			evalDAO.ajouterNoteEvaluation(new Evaluation(r.getRating()));
			evalDAO.close();

			Intent theIntent = new Intent(this, MainActivity.class);
			Toast.makeText(this, "Valeur enregistrée", Toast.LENGTH_LONG).show();
			startActivity(theIntent);
		}
	}



}
