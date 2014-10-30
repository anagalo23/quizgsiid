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

	private static final int VERSION_BDD=3;
	private static final String NOM_BDD= "quiz.db";
	private static final String TABLE_NAME="evaluation";
	private static final String COL_EVA= "noteAppli";


	public EvaluationDAO(Context context){
		bdd= new Bdd(context,NOM_BDD,null, VERSION_BDD);

	}

	public void open(){
		sqlite =bdd.getWritableDatabase();
	}


	public void close() {
		sqlite.close();
	}

	public SQLiteDatabase getBDD(){
		return sqlite;
	}

	public long ajouterNoteEvaluation( Evaluation eval){

		ContentValues values = new ContentValues();
		values.put(COL_EVA, eval.getNoteAppli());

		return sqlite.insert(TABLE_NAME, null, values);
	}


	public ArrayList<Evaluation> getEvaluation(){

		ArrayList<Evaluation> noteList = new ArrayList<Evaluation>();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME;
		Cursor cursor = sqlite.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Evaluation evaluation = new Evaluation(cursor.getFloat(1));

				// Adding contact to list
				noteList.add(evaluation);
			} while (cursor.moveToNext());
		}

		cursor.close();
		return noteList;

	}
}
