package HomeWork;

public class Main{
    public static void main(String[] args){

        User user = new User("Гриша");


        UserReportable UR = new ReportUser(user);
        UR.report();

        UserSaveable US = new Persister(user);
        US.save();

    }
}