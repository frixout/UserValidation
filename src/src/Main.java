import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //String string = "Aidar";
        //System.out.println(Character.isLetter(string.charAt(0)));
        /*Stream.of("1Aidar", "Айдар", "Aidar")
                .filter(x -> Character.isLetter(x.charAt(0)))
                .map(x -> x)
                ;*/
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alina", "Password2"));
        userList.add(new User("Dima", "Password2"));
        userList.add(new User("Lena", "Password"));
        userList.add(new User("Kolya", "Password2"));
        userList.add(new User("Sasha", "Password2"));
        userList.add(new User("Ivan", "Password"));
        userList.add(new User("Andrey", "Password2"));
        userList.add(new User("Alex", "Password2"));
        userList.add(new User("Nikita", "Password"));
        userList.add(new User("Aidar", "Password"));
        System.out.println(Validations.toValidate(userList));
    }
}