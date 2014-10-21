package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import bdd.*;
import dto.Questions;
public class QuestionsDAO {

	private SQLiteDatabase sqlite;
	private Bdd bdd;
	
	private static final int VERSION_BDD=1;
	private static final String NOM_BDD= "quiz.db";
	
	private static final String TABLE_QUESTIONS="questions";
	private static final String COL_ID="id_quest";
	private static final int NUM_COL_ID=1;
	private static final String QUESTIONS="question";

	


	
	public QuestionsDAO(Context context) {
		// TODO Auto-generated constructor stub
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

	
	
}
