import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Validations {
    public static Map<Integer, User > toValidate(List<User> userList) {
        return userList.stream()
                .filter(x -> x.getPassword().length() > 8 && Character.isLetter(x.getName().charAt(0)))
                .collect(Collectors.toMap(User::getID, user -> user));
    }
}
