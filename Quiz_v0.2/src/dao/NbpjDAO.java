package dao;

import java.util.ArrayList;


import dto.Nbpj;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bdd.Bdd;

public class NbpjDAO {

	private SQLiteDatabase sqlite;
	private Bdd bdd;

	private static final int VERSION_BDD=3;
	private static final String NOM_BDD= "quiz.db";
	private static final String TABLE_NAME="nombrePartieJouee";

	public NbpjDAO(Context context) {
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
	
	public long ajouterPartieJouee(Nbpj nbpj){

		ContentValues values = new ContentValues();
		values.put("noteAppli", nbpj.getNote());

		return sqlite.insert(TABLE_NAME, null, values);

	}
	
	public ArrayList<Nbpj> getEvaluation(){

		ArrayList<Nbpj> nbpjList = new ArrayList<Nbpj>();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME;
		Cursor cursor = sqlite.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Nbpj nbpj = new Nbpj(cursor.getInt(1));

				// Adding contact to list
				nbpjList.add(nbpj);
			} while (cursor.moveToNext());
		}

		cursor.close();
		return nbpjList;

	}

}
