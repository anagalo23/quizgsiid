package dao;

import java.util.ArrayList;

import dto.Reponse;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bdd.Bdd;

public class ReponseDAO {

	
	private SQLiteDatabase sqlite;
	private Bdd bdd;

	private static final int VERSION_BDD=2;
	private static final String NOM_BDD= "quiz.db";
	private static final String TABLE_NAME="reponses";
	
	public ReponseDAO( Context context) {
		
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

	
	public ArrayList<Reponse> getReponseParIdQuestion(int id_quest){
		
		ArrayList<Reponse> reponseList =new ArrayList<Reponse>();
		
		String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE id_th= " + id_quest;

		Cursor cursor = sqlite.rawQuery(selectQuery, null);
		

		if (cursor.moveToFirst()) {
			do {
				Reponse reponse = new Reponse(cursor.getString(2),cursor.getInt(3),cursor.getInt(4));

				// Adding contact to list
				reponseList.add(reponse);
			} while (cursor.moveToNext());
		}

		cursor.close();
		return reponseList;
		
	}

}
