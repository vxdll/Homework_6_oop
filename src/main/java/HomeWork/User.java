package HomeWork;

public class User implements UserReportable, UserSaveable {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void save(){
        Persister persister = new Persister(this);
        persister.save();
    }

    @Override
    public void report(){
        System.out.println("Отчет для пользователя: " + name);
    }
}