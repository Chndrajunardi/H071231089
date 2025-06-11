package com.example.tp2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
//    ini atribut2nya, atribut2 ini sesuai dengan inputan yg diperlukan dalam edit profile
    private String name; //untuk nama
    private String username; //untuk username
    private String pronouns; //untuk pronouns
    private String bio; // untuk bio
    private String imageUri;// untuk gambar

//    ini constructor untuk buat objeknya
    public User(String name, String username, String pronouns, String bio, String imageUri) {
        this.name = name;
        this.username = username;
        this.pronouns = pronouns;
        this.bio = bio;
        this.imageUri = imageUri;
    }

//    method setter dan getter. method getter untuk mengambil data dan method setter untuk mengubah data
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    protected User(Parcel in) {
        name = in.readString();
        username = in.readString();
        pronouns = in.readString();
        bio = in.readString();
        imageUri = in.readString();
    }

//    write to parcel untuk menyimpan data ke parcel, supaya data bisa dipindahkan ke activity lainnya
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(pronouns);
        dest.writeString(bio);
        dest.writeString(imageUri);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}