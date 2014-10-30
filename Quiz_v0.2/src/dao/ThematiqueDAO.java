package dao;

import dto.Thematique;
import bdd.Bdd;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ThematiqueDAO {


	private SQLiteDatabase sqlite;
	private Bdd bdd;

	private static final int VERSION_BDD=3;
	private static final String NOM_BDD= "quiz.db";
	private static final String TABLE_NAME="thematique";


	public ThematiqueDAO(Context context) {
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


	public Thematique getThematiqueParId(int id_th){

		String selectQuery = "SELECT * FROM  thematique WHERE id_th = " + id_th +"";

		Cursor cursor = sqlite.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		Thematique theme = new Thematique(cursor.getString(1));
		cursor.close();

		return theme;

	}
}
