package com.example.praktikum7;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class StudentAdapter implements Parcelable {
    private final String nana;
    private final String nim;

    public String getNim() {
        return nim;
    }

    public String getNana() {
        return nana;
    }

    protected StudentAdapter(Parcel in) {
        nana = in.readString();
        nim = in.readString();
    }

    public static final Creator<StudentAdapter> CREATOR = new Creator<StudentAdapter>() {
        @Override
        public StudentAdapter createFromParcel(Parcel in) {
            return new StudentAdapter(in);
        }

        @Override
        public StudentAdapter[] newArray(int size) {
            return new StudentAdapter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nana);
        dest.writeString(nim);
    }
}
