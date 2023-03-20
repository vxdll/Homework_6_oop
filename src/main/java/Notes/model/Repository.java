package Notes.model;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    String CreateNote(Note note);

    void saveRepository(List<Note> notes);

    void updateNote(Note note, String fields, String param) throws Exception;

    void saveOneNote(Note note) throws Exception;
    void deleteUser(String userId);
}
