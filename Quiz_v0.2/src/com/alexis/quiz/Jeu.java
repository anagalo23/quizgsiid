package com.alexis.quiz;

import com.alexi.quiz.R;






import dao.NbpjDAO;
import dao.QuestionsDAO;
import dao.ReponseDAO;
import dao.ThematiqueDAO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Jeu extends Activity implements OnClickListener  {

	TextView r1=null,r2=null;
	TextView t1;
	Button validerqcm;
	RadioGroup choix1;
	int nbj=0;
	ThematiqueDAO theme =new ThematiqueDAO(this);
	QuestionsDAO question =new QuestionsDAO(this);
	ReponseDAO reponse = new ReponseDAO(this);
	NbpjDAO nbpj= new NbpjDAO(this);
	String check;
	int id_th, note=0, indexQuestion=1;



	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jouer);

		Intent intent = getIntent();
		theme.open();
		question.open();
		reponse.open();

		check=intent.getStringExtra("check");

		TextView tv = (TextView) findViewById(R.id.qcm);

		tv.setText("QCM  " + check.toUpperCase());


		r1= (TextView) findViewById(R.id.radio0);
		r2= (TextView) findViewById(R.id.radio1);


		t1= (TextView) findViewById(R.id.qestion1qcm);

		if(check.startsWith("j")){
			id_th=1;
			t1.setText(question.getQuestionParTheme(1).get(0).getQuestion());
			r1.setText(reponse.getReponseParIdQuestion(1).get(0).getReponse());
			r2.setText(reponse.getReponseParIdQuestion(1).get(1).getReponse());


		}else if(check.startsWith("a")){
			id_th=2;
			t1.setText(question.getQuestionParTheme(2).get(0).getQuestion());
			r1.setText(reponse.getReponseParIdQuestion(5).get(0).getReponse());
			r2.setText(reponse.getReponseParIdQuestion(5).get(1).getReponse());


		}

		validerqcm=(Button) findViewById(R.id.validerqcm);
		validerqcm.setOnClickListener(this);

		choix1 =(RadioGroup) findViewById(R.id.rgq1);


		choix1.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {	} });

		reponse.close();
		question.close();
		theme.close();
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		/// cette partie n'est pas encore faite. Je vais m arreter là pour ce soir.
		if(v==validerqcm &&(choix1.getCheckedRadioButtonId()==R.id.radio0 | choix1.getCheckedRadioButtonId()==R.id.radio1) && indexQuestion<3){

			theme.open();
			question.open();
			reponse.open();
			t1.setText(question.getQuestionParTheme(id_th).get(indexQuestion).getQuestion());

			int id_quest= question.getQuestionParTheme(id_th).get(indexQuestion).getId_quest();
			r1.setText(reponse.getReponseParIdQuestion(id_quest).get(0).getReponse());
			note+=reponse.getReponseParIdQuestion(id_quest).get(0).getValeur_rep();
			r2.setText(reponse.getReponseParIdQuestion(id_quest).get(1).getReponse());
			note+=reponse.getReponseParIdQuestion(id_quest).get(1).getValeur_rep();

			indexQuestion++;

			/*if(indexQuestion ==3){

				t1.setText(question.getQuestionParTheme(id_th).get(indexQuestion).getQuestion());
				r1.setText(reponse.getReponseParIdQuestion(question.getQuestionParTheme(id_th).get(indexQuestion).getId_quest()).get(0).getReponse());
				note+=reponse.getReponseParIdQuestion(question.getQuestionParTheme(id_th).get(indexQuestion).getId_quest()).get(0).getValeur_rep();
				r2.setText(reponse.getReponseParIdQuestion(question.getQuestionParTheme(id_th).get(indexQuestion).getId_quest()).get(1).getReponse());
				note+=reponse.getReponseParIdQuestion(question.getQuestionParTheme(id_th).get(indexQuestion).getId_quest()).get(1).getValeur_rep();

			}

			 */

			//	nbpj.ajouterPartieJouee(new Nbpj(s));

			//Toast.makeText(this, "Votre note est: "+note,Toast.LENGTH_LONG).show();	

			reponse.close();
			question.close();
			theme.close();

		}else {
			Toast.makeText(this, "cochez toutes les parties", Toast.LENGTH_LONG).show();
		}
	}




}