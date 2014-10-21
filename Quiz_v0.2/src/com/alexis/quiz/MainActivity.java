package com.alexis.quiz;

/*import com.alexis_quiz_gsi.R;
import com.alexis_quiz_gsi.R.id;
import com.alexis_quiz_gsi.R.layout;
import com.alexis_quiz_gsi.R.menu;
 */
import com.alexi.quiz.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener  {

	Button jouer=null;
	Button statistique=null;
	Button apropos=null;
	Button quitter=null;
	Button evaluer=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		jouer= (Button) findViewById(R.id.jouer);
		statistique =(Button) findViewById(R.id.statistiques);
		evaluer =(Button) findViewById(R.id.evaluer);
		apropos =(Button) findViewById(R.id.aPropos);
		quitter=(Button)  findViewById(R.id.quitter);

		jouer.setOnClickListener(this);
		statistique.setOnClickListener(this);
		evaluer.setOnClickListener(this);
		apropos.setOnClickListener(this);
		quitter.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.



	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreatePanelMenu(int, android.view.Menu)
	 */
	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		menu.add("Menu");
		// TODO Auto-generated method stub
		return super.onCreatePanelMenu(featureId, menu);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==jouer){
			Intent theIntent = new Intent(this, Choix.class);
			startActivity(theIntent);

		}else if(v==evaluer){

			Intent theIntent = new Intent(this, Evaluer.class);
			startActivity(theIntent);

		}else if(v==statistique){

			Intent theIntent = new Intent(this, Statistique.class);
			startActivity(theIntent);

		}else if(v==apropos){
			Intent theIntent = new Intent(this, Apropos.class);
			startActivity(theIntent);

		}else if(v==quitter){
			Toast.makeText(this, "Quitter", Toast.LENGTH_SHORT).show();
			finish();
			System.exit(0);

		}
	}


}
