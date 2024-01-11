import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    private int ID;
    private String name;
    private String password;
    private final Role role;
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole(){
        return role;
    }
    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", ID='" + role + '\'' +
                '}';
    }
}
