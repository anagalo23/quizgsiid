package dao;

import java.util.ArrayList;

import dto.Evaluation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bdd.Bdd;


public class EvaluationDAO {


	private SQLiteDatabase sqlite;
	private Bdd bdd;

	private static final int VERSION_BDD=1;
	private static final String NOM_BDD= "quiz.db";
	private static final String TABLE_NAME="evaluation";


	public EvaluationDAO(Context context){
		bdd= new Bdd(context,NOM_BDD,null, VERSION_BDD);

	}

	public void open(){
		sqlite =bdd.getWritableDatabase();
	}


	protected void close() {
		sqlite.close();
	}

	public SQLiteDatabase getBDD(){
		return sqlite;
	}

	public long ajouterNoteEvaluation( Evaluation eval){

		ContentValues values = new ContentValues();
		values.put("noteAppli", eval.getNoteAppli());

		return sqlite.insert(TABLE_NAME, null, values);

	}


	public ArrayList<Evaluation> getEvaluation(){

		ArrayList<Evaluation> noteList = new ArrayList<Evaluation>();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME;
		Cursor cursor = sqlite.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Evaluation evaluation = new Evaluation(cursor.getInt(0), cursor.getFloat(1));

				// Adding contact to list
				noteList.add(evaluation);
			} while (cursor.moveToNext());
		}

		cursor.close();
		return noteList;

	}
}
