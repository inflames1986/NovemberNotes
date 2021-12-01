package com.inflames1986.novembernotes.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.inflames1986.novembernotes.R;
import com.inflames1986.novembernotes.domain.Note;
import com.inflames1986.novembernotes.ui.details.NoteDetailsActivity;
import com.inflames1986.novembernotes.ui.details.NoteDetailsFragment;
import com.inflames1986.novembernotes.ui.list.NotesListFragment;

public class MainActivity extends AppCompatActivity implements NotesListFragment.OnNoteClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onNoteClicked(Note note) {

        if (getResources().getBoolean(R.bool.isLandscape)) {// если ландшафтный решим, то открываем деталку во фрагменте рядом

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.details_container, NoteDetailsFragment.newInstance(note), null)
                    .commit();

        } else { //если портретный режим, то стартуем новую активити в портретном режиме с деталкой
            Intent intent = new Intent(this, NoteDetailsActivity.class); //будем по клику запускать NoteDetailsActivity.class
            intent.putExtra(NoteDetailsActivity.ARG_NOTE, note); //кладем в интент данные по ключу - заметку передаем
            startActivity(intent); //стартуем активити по интенту
        }
    }
}