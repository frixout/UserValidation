import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    private int ID;
    private String name;
    private String password;
    private Role role;
    private static int count = 1;

    public User(String name, String password, Role role) {
        this.ID = count++;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    private void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    private void setRole(Role role) {
        this.role = role;
    }

    public void actionSetName(User user, String name) {
        if (role == Role.ADMIN && user.getRole() != Role.ADMIN) {
            user.setName(name);
        } else if (this.equals(user)) {
            user.setName(name);
        } else {
            System.out.println("У вас, " + this.name + ", нет прав изменить имя у пользователя " + user.getName());
        }
    }

    public void actionSetPassword(User user, String password) {
        if (role == Role.ADMIN && user.getRole() != Role.ADMIN) {
            user.setPassword(password);
        } else if (this.equals(user)) {
            user.setPassword(password);
        } else {
            System.out.println("У вас, " + this.name + ", нет прав изменить пароль у пользователя " + user.getName());
        }
    }

    public void actionSetRole(User user, Role role1) {
        if (role == Role.ADMIN && user.getRole() != Role.ADMIN) {
            user.setRole(role1);
        } else if (role == Role.ADMIN && this.equals(user)) {
            user.setRole(role1);
        } else {
            System.out.println("У вас, " + this.name + ", нет прав изменить роль у пользователя " + user.getName());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + name + '\'' +
                ", Password='" + password + '\'' +
                ", Role='" + role + '\'' +
                '}';
    }

    public static class Validations {
        public static Map<Integer, User> toValidate(List<User> userList) {
            return userList.stream()
                    .filter(x -> x.getPassword().length() > 8 && Character.isLetter(x.getName().charAt(0)))
                    .collect(Collectors.toMap(User::getID, user -> user));
        }
    }
}
