package Notes.model;

import java.util.regex.Pattern;

public class ValidateUser {

    private Pattern patternName = Pattern.compile("^\\S*$");
    private Pattern patternPhone = Pattern.compile("^\\d*$");


    public void check(Note note) throws Exception {
        if (!patternName.matcher(note.getNoteHead()).find()){
            throw new Exception("неверно указано имя");
        }

        if (!patternName.matcher(note.getNoteText()).find()){
            throw new Exception("неверно указана фамилия");
        }

        if (!patternPhone.matcher(note.getNoteDate()).find()){
            throw new Exception("неверный номер телефона");
        }
    }

}
