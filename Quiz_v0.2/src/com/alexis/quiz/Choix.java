package com.alexis.quiz;

import com.alexi.quiz.R;

import dao.ThematiqueDAO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Choix extends Activity implements OnClickListener {

	Button jouerNow =null;
	RadioGroup choix;
	ThematiqueDAO themeDAO =new ThematiqueDAO(this);

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choix);

		jouerNow=(Button) findViewById(R.id.bouttonchoix);
		jouerNow.setOnClickListener(this);

		choix =(RadioGroup) findViewById(R.id.radioChoix);

		choix.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub

				TextView tv = (TextView) findViewById(R.id.textViewChoix);

				switch(checkedId){

				case R.id.jee:
					tv.setText("Vous avez choisi JEE");					


					break;
				case R.id.android:
					tv.setText("Vous avez choisi Android");			
					break;
				}

			}

		});

	}

	@Override
	public void onClick(View v) {

		// TODO Auto-generated method stub
		if(v==jouerNow & (choix.getCheckedRadioButtonId()==R.id.jee | choix.getCheckedRadioButtonId()==R.id.android)){
			Intent theIntent = new Intent(this, Jeu.class);

			if(choix.getCheckedRadioButtonId()==R.id.jee){

				theIntent.putExtra("check", themeDAO.getThematiqueParId(1).getId_th());
			}
			else if(choix.getCheckedRadioButtonId()==R.id.android){
				theIntent.putExtra("check", themeDAO.getThematiqueParId(2).getId_th());
			}
			startActivity(theIntent);
		}else {
			Toast.makeText(this, "Vous devez faire un choix", Toast.LENGTH_LONG).show();
		}
	}



}
