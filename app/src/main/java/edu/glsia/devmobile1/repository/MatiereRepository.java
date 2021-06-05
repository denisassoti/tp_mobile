package edu.glsia.devmobile1.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.glsia.devmobile1.models.Matiere;

public class MatiereRepository {

    public boolean save(SQLiteDatabase database, Matiere matiere) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", matiere.getId());
        contentValues.put("libelle", matiere.getLibelle());
        contentValues.put("type", matiere.isType());
        contentValues.put("enseignant", matiere.getEnseignant());
        contentValues.put("image_name", matiere.getImage());
        long nbLignes = database.insert("matiere", null, contentValues);
        return (nbLignes > 0);
    }

    public List<Matiere> findAll(SQLiteDatabase database) {
        Cursor cursor = database.rawQuery("SELECT * FROM matiere", null);
        List<Matiere> maListe = new ArrayList<>();
        Matiere matiere;
        while (cursor.moveToNext()) {
            matiere = new Matiere();
            matiere.setId(cursor.getInt(0));
            matiere.setLibelle(cursor.getString(1));
            matiere.setType(cursor.getInt(2) == 1);
            matiere.setEnseignant(cursor.getString(3));
            matiere.setImage(cursor.getInt(4));

            maListe.add(matiere);
        }
        return maListe;
    }
}
