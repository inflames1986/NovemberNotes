package com.inflames1986.novembernotes.domain;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class Note {

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

    public int getNoteName() {
        return noteName;
    }

    public int getNoteImage() {
        return noteImage;
    }

    public int getNoteDescription() {
        return noteDescription;
    }
}
