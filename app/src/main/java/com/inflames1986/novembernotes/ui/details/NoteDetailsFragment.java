package com.inflames1986.novembernotes.ui.details;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.inflames1986.novembernotes.R;
import com.inflames1986.novembernotes.domain.Note;

public class NoteDetailsFragment extends Fragment {

    /***
     * Единственным способом передать фрагменту данные, чтобы они сохранялись при его пересоздании это передать их через arguments
     * Обычно при создании фрагмента, которому передаются какие-то данные, создается статический хелпер - метод, который возвращает
     * экземпляр фрагмента и называется newInstance или Instance
     * Ему отдается то, что мы хотим в этот arguments записать и возвращается, разумеется fragment
     * Таким образом данные сохраняются при пересоздании фрагмента
     */

    private static final String ARG_NOTE = "ARG_NOTE"; //выносим в переменную в константу для передачи в Parcelable

    public static NoteDetailsFragment newInstance(Note note) {

        NoteDetailsFragment fragment = new NoteDetailsFragment(); //создаем фрагмент
        Bundle arguments = new Bundle(); //при этом все аргументы необходимо положить в Bundle

        arguments.putParcelable(ARG_NOTE, note); //запихиваем в аргументы(бандл) заметку по ключу

        fragment.setArguments(arguments); //сеттим аргументы во фрагмент
        return fragment; //возвращаем фрагмент

    }

    public NoteDetailsFragment () {
        super (R.layout.fragment_note_details);

    }

    /*** ЭКВИВАЛЕНТНО
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    } ЭКВИВАЛЕНТНО
     ***/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Note note = getArguments().getParcelable(ARG_NOTE); //получаем аргументы в заметку

        TextView noteName = view.findViewById(R.id.note_name);
        noteName.setText(note.getNoteName());

        ImageView noteImage = view.findViewById(R.id.note_image);
        noteImage.setImageResource(note.getNoteImage());

        TextView noteDescription = view.findViewById(R.id.note_description);
        noteDescription.setText(note.getNoteDescription());

    }
}

