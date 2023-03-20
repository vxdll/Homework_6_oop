package HomeWork;

public class ReportUser implements UserReportable{

    private User user;

    public ReportUser(User user) {
        this.user = user;
    }

    @Override
    public void report() {
        System.out.println("Отчет для пользователя: " + user.getName());
    }
}