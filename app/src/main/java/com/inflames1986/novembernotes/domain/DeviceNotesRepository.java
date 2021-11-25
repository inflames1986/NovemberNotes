package com.inflames1986.novembernotes.domain;

import com.inflames1986.novembernotes.R;

import java.util.ArrayList;
import java.util.List;

public class DeviceNotesRepository implements NotesRepository { //конкретная реализация репозитория с данных на устройстве
    @Override
    public List<Note> getNotes() {

        ArrayList<Note> notes = new ArrayList<>(); // эррэй лист заметок = новый эррэйлист

        notes.add(new Note(R.string.michael, R.drawable.michael, R.string.michael_desc));
        notes.add(new Note(R.string.gericium, R.drawable.gericium, R.string.gericium_desc));
        notes.add(new Note(R.string.olgamichael, R.drawable.olgamichael, R.string.olgamichael_desc));
        notes.add(new Note(R.string.mazda, R.drawable.mazda, R.string.mazda_desc));
        notes.add(new Note(R.string.yalos, R.drawable.yalos, R.string.yalos_desc));

        return notes;

    }
}
