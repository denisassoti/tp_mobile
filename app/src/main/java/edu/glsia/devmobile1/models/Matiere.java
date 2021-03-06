package edu.glsia.devmobile1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Matiere implements Parcelable {
    private int id;
    private String libelle, enseignant;
    private int image;
    private boolean type;

    public Matiere(){

    }

    public Matiere(int id, String libelle, String enseignant, int image, boolean type) {
        this.id = id;
        this.libelle = libelle;
        this.enseignant = enseignant;
        this.image = image;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.getId());
        dest.writeString(this.getLibelle());
        dest.writeString(this.getEnseignant());
        dest.writeInt(this.getImage());
        dest.writeBoolean(this.isType());
    }

    public Matiere(Parcel parcel){
        this.setId(parcel.readInt());
        this.setLibelle(parcel.readString());
        this.setEnseignant(parcel.readString());
        this.setImage(parcel.readInt());
        this.setType(parcel.readBoolean());
    }

    public static  final Creator<Matiere> CREATOR = new Creator<Matiere>() {
        @Override
        public Matiere createFromParcel(Parcel source) {
            return new Matiere(source);
        }

        @Override
        public Matiere[] newArray(int size) {
            return new Matiere[size];
        }
    };
}
