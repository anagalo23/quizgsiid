package dao;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bdd.*;
import dto.Questions;
public class QuestionsDAO {

	private SQLiteDatabase sqlite;
	private Bdd bdd;

	private static final int VERSION_BDD=2;
	private static final String NOM_BDD= "quiz.db";
	private static final String TABLE_NAME="questions";



	public QuestionsDAO(Context context) {
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

	
	//Selection des questions selon leur theme 

	public ArrayList<Questions> getQuestionParTheme(int id_th){


		ArrayList<Questions> questionList=new ArrayList<Questions>();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE id_th= " + id_th;

		Cursor cursor = sqlite.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Questions question = new Questions(cursor.getString(2),cursor.getInt(3));

				// Adding contact to list
				questionList.add(question);
			} while (cursor.moveToNext());
		}

		cursor.close();
		return questionList;



	}

}
