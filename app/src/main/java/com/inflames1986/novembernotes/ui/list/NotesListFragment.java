package com.inflames1986.novembernotes.ui.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.inflames1986.novembernotes.R;
import com.inflames1986.novembernotes.domain.DeviceNotesRepository;
import com.inflames1986.novembernotes.domain.Note;
import com.inflames1986.novembernotes.ui.details.NoteDetailsActivity;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView { // будет выступать как view

    public interface OnNoteClicked {     // определяем интерфейс наподобии noteItem.setOnClickListener(new View.OnClickListener()
        void onNoteClicked(Note note);   // который будет оповещать активити с той стороны, что событие случилось, в качестве аргумента заметка
    }

    private NotesListPresenter presenter; //создаем здесь презентер

    private LinearLayout container; //вытсакиваем в переменную контейнер

    private OnNoteClicked onNoteClicked; //сохраняем ссылку на интерфейс OnNoteClicked


    @Override
    public void onAttach(@NonNull Context context) { // фрагмент присоединяется к активити
        super.onAttach(context);

        if (context instanceof OnNoteClicked) { //проверяем реализует ли активити OnNoteClicked или нет
            onNoteClicked = (OnNoteClicked)context; //если да, то сохраняем на нее ссылку
        }
    }

    @Override
    public void onDetach() { //когда от активити отцепились,
        onNoteClicked = null; //про нее забываем
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {//создаем меттод онКриэйт
        super.onCreate(savedInstanceState);

        /***
         *Presenter осуществляет взаимодействие между view и model, реакцию на пользовательский ввод и обращается к модели за решением каких-то задач
         */

        presenter = new NotesListPresenter(this, new DeviceNotesRepository()); //создаем новый презентер, которому передаем текущую вью и репозиторий
    }                                                                               //вместо девайс нотс репозитори можем выбрать любой другой, например нетворк
                                                                                    //и больше ничего не менять, все будет работать

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


        container = view.findViewById(R.id.root);//контейнеру присваиваем вьюху фрэгментНотесЛист

        presenter.requestNotes(); //говорим презентеру, что хотим полуить список городов


    }

    @Override
    public void showNotes(List<Note> notes) { // формируем список

        for (Note note: notes) {

            View noteItem = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, container, false); //создалли view для заметки

            noteItem.setOnClickListener(new View.OnClickListener() { //навешиваем онКликЛисенер на элемент списка
                @Override
                public void onClick(View v) {
                    if (onNoteClicked != null) {
                        onNoteClicked.onNoteClicked(note);
                    }


                    /* А то, что ниже убираем в MainActivity*/


//                    Toast.makeText(getContext(), note.getNoteDescription(), Toast.LENGTH_SHORT).show(); показываем сообщение при клике на заметку
//
//                    Intent intent = new Intent(requireContext(), NoteDetailsActivity.class); //во фрагменте в качестве контекста требуем контекст методом requireContext(),
//
//                                                                                             //будем по клику запускать NoteDetailsActivity.class
//                    intent.putExtra(NoteDetailsActivity.ARG_NOTE, note); //кладем в интент данные по ключу - заметку передаем
//                    startActivity(intent); //стартуем активити по интенту
                }
            });

            ImageView noteImage = noteItem.findViewById(R.id.note_image); //устанавливаем перемменную noteImage

            noteImage.setImageResource(note.getNoteImage()); //сеттим значение в noteImage

            container.addView(noteItem);// сразу же добавили вью в контейнер
        }
    }
}
