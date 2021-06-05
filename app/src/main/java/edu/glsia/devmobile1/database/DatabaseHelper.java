package edu.glsia.devmobile1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    private final String MATIERE_CREATE = "CREATE TABLE matiere ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "libelle VARCHAR(30),"+
                "type INTEGER(1),"+
                "enseignant VARCHAR(30),"+
                "image_name VARCHAR(50));";

    public DatabaseHelper(Context context){
        super(context, "matiereDB",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.database = db;
        db.execSQL(MATIERE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase getDatabase() {
        return this.getWritableDatabase();
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }
}
