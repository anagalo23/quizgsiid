package bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Bdd extends SQLiteOpenHelper{


	public Bdd(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		//Creation des tables
		db.execSQL("CREATE TABLE thematique (id_th INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "theme TEXT NOT NULL)");
		
		//the est la clé étrangère à la table thematique dans la table questions
		db.execSQL("CREATE TABLE questions (id_quest INTEGER PRIMARY KEY AUTOINCREMENT,"
				+"question TEXT NOT NULL, id_the INTEGER FOREIGN KEY REFERENCES thematique(id_th)");
		
		
		db.execSQL("CREATE TABLE reponses (id_rep INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ "response TEXT NOT NULL , valeur_rep INTEGER NOT NULL" 
				+"id_question INTEGER FOREIGN KEY REFERENCES questions(id_quest)");
		
		
		db.execSQL("CREATE TABLE nombrePartieJouee (id_nbpj INTEGER PRIMARY KEY AUTOINCREMENT"
				+"note INTEGER");
		
		db.execSQL("CREATE TABLE evaluation(id_eval INTEGER PRIMARY KEY AUTOINCREMENT "
				+"noteAppli FLOAT");
		
		//les initialisations
		
		// initialisation thematiques
		
		db.execSQL("INSERT INTO thematiques (\"jee\")");
		db.execSQL("INSERT INTO thematiques (\"android\")");
		
		//initialisation questions
		
		db.execSQL("INSERT INTO questions (\"Que signifie JEE?\", 1");
		db.execSQL("INSERT INTO questions (\"Annee de creation?\", 1");
		db.execSQL("INSERT INTO questions (\"Que signifie JRE?\", 1");
		db.execSQL("INSERT INTO questions (\"Que signifie JSP?\", 1");
		
		db.execSQL("INSERT INTO questions (\"Qui a crée Android?\", 2");
		db.execSQL("INSERT INTO questions (\"Qui a racheté Android?\", 2");
		db.execSQL("INSERT INTO questions (\"Android est-il open source?\", 2");
		db.execSQL("INSERT INTO questions (\"Quel marque de smartphone utilise Android?\", 2");
		
		//initialisation reponses
		
		//reponse pour jee
		db.execSQL("INSERT INTO reponses (\"Java Enterprise Edition\", 5, 1");
		db.execSQL("INSERT INTO reponses (\" Java Entertainment Environment\",0, 1");
		
		db.execSQL("INSERT INTO reponses (\"1999\", 5, 2");
		db.execSQL("INSERT INTO reponses (\"2003\",0, 2");
		
		db.execSQL("INSERT INTO reponses (\"Java Revolution Environment\", 0, 3");
		db.execSQL("INSERT INTO reponses (\"Java Runtime Environment\", 5, 3");
		
		db.execSQL("INSERT INTO reponses (\"Java Servlet Page\", 0, 4");
		db.execSQL("INSERT INTO reponses (\"Java Server Page\",5, 4");
		
		
		//reponse pour android
		db.execSQL("INSERT INTO reponses (\"Android\", 5, 5");
		db.execSQL("INSERT INTO reponses (\"Google\",0, 5 ");
		
		db.execSQL("INSERT INTO reponses (\"Microsoft\", 0, 6");
		db.execSQL("INSERT INTO reponses (\"Google\",5,6 ");
		
		db.execSQL("INSERT INTO reponses (\"Non\", 0, 7");
		db.execSQL("INSERT INTO reponses (\"Oui\",5, 7");
		
		db.execSQL("INSERT INTO reponses (\"Samsung\", 5, 8");
		db.execSQL("INSERT INTO reponses (\"Apple\",0, 8 ");
		
		//diagne NAGALO
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS books");
 
        // create fresh books table
        this.onCreate(db);
	}

}
