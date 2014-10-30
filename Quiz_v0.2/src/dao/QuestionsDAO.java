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

	private static final int VERSION_BDD=3;
	private static final String NOM_BDD= "quiz.db";
	private static final String TABLE_NAME="questions";



	public QuestionsDAO(Context context) {
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

	
	//Selection des questions selon leur theme 

	public ArrayList<Questions> getQuestionParTheme(int id_th){


		ArrayList<Questions> questionList=new ArrayList<Questions>();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE id_the= " + id_th;

		Cursor cursor = sqlite.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Questions question = new Questions(cursor.getString(1),cursor.getInt(2));

				// Adding contact to list
				questionList.add(question);
			} while (cursor.moveToNext());
		}

		cursor.close();
		return questionList;



	}

}
