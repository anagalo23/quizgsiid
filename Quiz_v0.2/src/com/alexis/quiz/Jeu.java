package com.alexis.quiz;

import com.alexi.quiz.R;





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
	int id_th;



	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jouer);

		Intent intent = getIntent();
		id_th= Integer.parseInt(intent.getStringExtra("check"));

		TextView tv = (TextView) findViewById(R.id.qcm);

		tv.setText("QCM  " + theme.getThematiqueParId(id_th).getTheme().toUpperCase());


		r1= (TextView) findViewById(R.id.radio0);
		r2= (TextView) findViewById(R.id.radio1);


		t1= (TextView) findViewById(R.id.qestion1qcm);

		if(id_th==1){
			t1.setText(question.getQuestionParTheme(1).get(1).getQuestion());
			r1.setText(reponse.getReponseParIdQuestion(1).get(1).getReponse());
			r2.setText(reponse.getReponseParIdQuestion(1).get(2).getReponse());


		}else if(id_th==2){

			t1.setText(question.getQuestionParTheme(2).get(1).getQuestion());
			r1.setText(reponse.getReponseParIdQuestion(5).get(1).getReponse());
			r2.setText(reponse.getReponseParIdQuestion(5).get(2).getReponse());


		}

		validerqcm=(Button) findViewById(R.id.validerqcm);
		validerqcm.setOnClickListener(this);

		choix1 =(RadioGroup) findViewById(R.id.rgq1);


		choix1.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {	} });

	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		/// cette partie n'est pas encore faite. Je vais m arreter là pour ce soir.
		if(v==validerqcm &(choix1.getCheckedRadioButtonId()==R.id.radio0 | choix1.getCheckedRadioButtonId()==R.id.radio1)){

			for(int i =1; i<question.getQuestionParTheme(id_th).size();i++){

			}

			if(getIntent().getStringExtra("check").startsWith("j")){
			}
			if(getIntent().getStringExtra("check").startsWith("a"))
				if(choix1.getCheckedRadioButtonId()==R.id.radio0);


			//			Toast.makeText(this, "Votre note est: "+note,Toast.LENGTH_LONG).show();	


		}else {
			Toast.makeText(this, "cochez toutes les parties", Toast.LENGTH_LONG).show();
		}
	}




}