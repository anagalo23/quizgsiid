package com.alexis.quiz;

import com.alexi.quiz.R;

import dao.NoteDAO;
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

	TextView r1=null,r2=null,r3=null,r4=null,r5=null,r6=null;
	TextView t1, t2,t3;
	Button validerqcm;
	RadioGroup choix1, choix2,choix3;
	int nbj=0;
	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jouer);

		Intent intent = getIntent();
		String check= intent.getStringExtra("check").toString();

		TextView tv = (TextView) findViewById(R.id.qcm);

		tv.setText("QCM  " + check.toUpperCase());


		r1= (TextView) findViewById(R.id.radio0);
		r2= (TextView) findViewById(R.id.radio1);
		r3= (TextView) findViewById(R.id.radio2);
		r4= (TextView) findViewById(R.id.radio3);
		r5= (TextView) findViewById(R.id.radio4);
		r6= (TextView) findViewById(R.id.radio5);

		t1= (TextView) findViewById(R.id.qestion1qcm);
		t2= (TextView) findViewById(R.id.question2qcm);
		t3= (TextView) findViewById(R.id.question3qcm);

		if(check.startsWith("j")){
			t1.setText("C'est quoi JEE?".toString());
			r1.setText("Une entreprise".toString());
			r2.setText("Un langage ".toString());

			t2.setText("année de création?".toString());
			r3.setText(" 1999".toString());
			r4.setText(" 2003 ".toString());

			t3.setText("c'est quoi JRE".toString());
			r5.setText("Java revolution environment".toString());
			r6.setText("Java Runtime environment".toString());

		}else if(check.startsWith("a")){

			t1.setText("Qui a créé Android?".toString());
			r1.setText("Android".toString());
			r2.setText("Google".toString());

			t2.setText("Qui a racheté android ".toString());
			r3.setText("Microsoft ".toString());
			r4.setText("Google".toString());

			t3.setText("quel noyau".toString());
			r5.setText("Windows".toString());
			r6.setText("Linux".toString());

		}

		validerqcm=(Button) findViewById(R.id.validerqcm);
		validerqcm.setOnClickListener(this);

		choix1 =(RadioGroup) findViewById(R.id.rgq1);
		choix2 =(RadioGroup) findViewById(R.id.rgq2);
		choix3 =(RadioGroup) findViewById(R.id.rgq3);

		choix1.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub


			}

		});

		choix2.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub

			}

		});

		choix3.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub

			}

		});



	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub


		if(v==validerqcm &(choix1.getCheckedRadioButtonId()==R.id.radio0 | choix1.getCheckedRadioButtonId()==R.id.radio1 )  &(choix2.getCheckedRadioButtonId()==R.id.radio2 | choix2.getCheckedRadioButtonId()==R.id.radio3) & (choix3.getCheckedRadioButtonId()==R.id.radio4 | choix3.getCheckedRadioButtonId()==R.id.radio5 ) ){
			int note=0;
			nbj++;
			
			if(getIntent().getStringExtra("check").startsWith("j")){
				if(choix1.getCheckedRadioButtonId()==R.id.radio1) note+=5;
				else note+=0;

				if(choix2.getCheckedRadioButtonId()==R.id.radio2) note+=5;
				else note+=0;
				if(choix3.getCheckedRadioButtonId()==R.id.radio5) note+=10;
				else note+=0;
			}
			if(getIntent().getStringExtra("check").startsWith("a")){
				if(choix1.getCheckedRadioButtonId()==R.id.radio0) note+=5;
				else note+=0;

				if(choix2.getCheckedRadioButtonId()==R.id.radio3) note+=5;
				else note+=0;
				if(choix3.getCheckedRadioButtonId()==R.id.radio5) note+=10;
				else note+=0;
			}
			Toast.makeText(this, "Votre note est: "+note,Toast.LENGTH_LONG).show();	
			NoteDAO.getInstance().setNote(note);
			
			Intent intent = new Intent();
			intent.putExtra("nombreJoue", nbj);

		}else {
			Toast.makeText(this, "cochez toutes les parties", Toast.LENGTH_LONG).show();
		}
	}




}