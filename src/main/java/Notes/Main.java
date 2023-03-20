package Notes;

import Notes.controllers.NoteController;
import Notes.model.*;
import Notes.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("notes.txt");
        Repository repository = new RepositoryFile(fileOperation, new UserMapper());
        NoteController controller = new NoteController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}