import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alina", "Password2", Role.USER));
        userList.add(new User("Dima", "Password2", Role.ADMIN));
        userList.add(new User("Lena", "Password", Role.USER));
        userList.add(new User("Kolya", "Password2", Role.USER));
        userList.add(new User("Sasha", "Password2", Role.USER));
        userList.add(new User("Ivan", "Password", Role.BANNED));
        userList.add(new User("Andrey", "Password2", Role.USER));
        userList.add(new User("Alex", "Password2", Role.USER));
        userList.add(new User("Nikita", "Password", Role.BANNED));
        userList.add(new User("Aidar", "Password2", Role.ADMIN));
        Map<Integer, User > userMap = Validations.toValidate(userList);
        System.out.println(userMap);
        List<User> adminList = new ArrayList<>();
        userMap.entrySet().stream()
                .filter(x -> x.getValue().getRole() == Role.ADMIN)
                .map(Map.Entry::getValue);
        ;

    }
}