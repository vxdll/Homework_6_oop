package Notes.views;

import Notes.controllers.NoteController;
import Notes.model.Fields;
import Notes.model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private NoteController noteController;

    public ViewUser(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        caseCreate();
                        break;
                    case READ:
                        caseRead();
                        break;
                    case LIST:
                        caseList();
                        break;
                    case DELETE:
                        caseDeleted();
                        break;
                    case UPDATE:
                        caseUpdate();
                        break;
                }
            }
            catch  (Exception ee){
                System.out.printf("%s something wrong \n ", ee.getMessage());
            }
        }
    }

    private void caseDeleted() {
        String id = prompt("Id записи: ");
        noteController.deleteUser(id);
        System.out.println("пользователь удалён");
    }

    private void caseCreate() throws Exception {
        String firstName = prompt("Заголовок записи: ");
        String lastName = prompt("Текст: ");
        noteController.saveUser(new Note(firstName, lastName));
    }

    private void caseRead() {
        String id = prompt("Id записи: ");
        try {
            Note note = noteController.getNoteById(id);
            System.out.println(note);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void caseList() {
        List<Note> usersList = noteController.getNotes();
        for (Note note : usersList) {
            System.out.println(note);
        }
    }

    private void caseUpdate() throws Exception {
        String noteId = prompt("Идентификатор записи: ");
        String fieldName = prompt("Какое поле (HEAD, TEXT): ");
        String param = prompt("Введите на то что хотите изменить: ");


        Note note = noteController.getNoteById(noteId);
        noteController.updateNote(note, fieldName.toUpperCase(), param);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
