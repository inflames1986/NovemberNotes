package com.inflames1986.novembernotes.ui.details;

import androidx.fragment.app.Fragment;

import com.inflames1986.novembernotes.R;

public class NoteDetailsFragment extends Fragment {

    public NoteDetailsFragment () {
        super (R.layout.fragment_note_details);

    /*** ЭКВИВАЛЕНТНО
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    } ЭКВИВАЛЕНТНО
     ***/
    }
}

