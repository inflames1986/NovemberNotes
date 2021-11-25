package com.inflames1986.novembernotes.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.inflames1986.novembernotes.R;

public class NotesListFragment extends Fragment {


    /*** Предоставляем View для фрагмента, на котором хотим что то отобразить методом onCreateView
     * LayoutInflater - перемалымает xml выдает view
     * ViewGroup container - к которому прикрепляем фрагмент
     * Bundle savedInstanceState - бандл по аналогии с активити - сохраненное состояние
     * ***/

    @Nullable // View может быть, а может и не быть
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
        //заготовленный Layout замеряет свои габариты относительно контейнера //
        //по умолчанию ни к чему присабачиваться не надо //
    }

    /*** Чтобы получить готовую View
     *
     *
     * Bundle savedInstanceState - бандл по аналогии с активити - сохраненное состояние
     * ***/


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout container = view.findViewById(R.id.root);

    }
}
