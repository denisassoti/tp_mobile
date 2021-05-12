package edu.glsia.devmobile1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Matiere implements Parcelable {
    private int id;
    private String libelle;

    public Matiere(){

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.getId());
        dest.writeString(this.getLibelle());
    }

    public Matiere(Parcel parcel){
        this.setId(parcel.readInt());
        this.setLibelle(parcel.readString());
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
