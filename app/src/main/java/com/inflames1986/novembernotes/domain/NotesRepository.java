package com.inflames1986.novembernotes.domain;

import java.util.List;

public interface NotesRepository { //интерфейс репозиторий заметок

    List<Note> getNotes(); //абстрактная функция получения списка заметок
}
