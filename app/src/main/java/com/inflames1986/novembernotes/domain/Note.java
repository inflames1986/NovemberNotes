package com.inflames1986.novembernotes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class Note implements Parcelable { //должен реализовать Parcelable, дабы была возможность передавать данные класса во фрагменте

    @StringRes
    private int noteName;

    @DrawableRes
    private int noteImage;

    @StringRes
    private int noteDescription;

    public Note(int noteName, int noteImage, int noteDescription) {
        this.noteName = noteName;
        this.noteImage = noteImage;
        this.noteDescription = noteDescription;
    }

    protected Note(Parcel in) {
        noteName = in.readInt();
        noteImage = in.readInt();
        noteDescription = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getNoteName() {
        return noteName;
    }

    public int getNoteImage() {
        return noteImage;
    }

    public int getNoteDescription() {
        return noteDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(noteName);
        dest.writeInt(noteImage);
        dest.writeInt(noteDescription);
    }
}
