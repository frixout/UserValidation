import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws BannedUser {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alina", "Password2", Role.USER));
        userList.add(new User("Dima", "Password2", Role.ADMIN));
        userList.add(new User("Lena", "Password", Role.USER));
        userList.add(new User("Kolya", "Password", Role.USER));
        userList.add(new User("Sasha", "Password2", Role.USER));
        userList.add(new User("Ivan", "Password2", Role.BANNED));
        userList.add(new User("Andrey", "Password2", Role.USER));
        userList.add(new User("1Alex", "Password2", Role.USER));
        userList.add(new User("Nikita", "Password2", Role.BANNED));
        userList.add(new User("Aidar", "Password2", Role.ADMIN));
        Map<Integer, User > userMap = Validations.toValidate(userList);
        //System.out.println(userMap);

        List<User> adminList = userMap.entrySet().stream()
                .filter(x -> x.getValue().getRole() == Role.ADMIN)
                .collect(ArrayList::new, (list, element) -> list.add(element.getValue()), ArrayList::addAll);
        ;
        //System.out.println(adminList);

        Iterator<Map.Entry<Integer, User>> userMapIterator = userMap.entrySet().iterator();
        while(userMapIterator.hasNext()){
            Map.Entry<Integer, User> userEntry =  userMapIterator.next();
            if (userEntry.getValue().getRole() == Role.ADMIN){
                userMapIterator.remove();
            } else if (userEntry.getValue().getRole() == Role.BANNED) {
                try {
                    throw new BannedUser();
                }catch (BannedUser e) {
                    System.out.println("Остался забаненный пользователь: ID: " + userEntry.getValue().getID() +  ", Name: " + userEntry.getValue().getName());
                    userMapIterator.remove();
                }
            }

        }
        System.out.println(userMap);

        adminList.get(0).actionSetName(userMap.get(1), "NeAlina");
        adminList.get(0).actionSetName(adminList.get(1),"NeAidar");
        adminList.get(0).actionSetName(adminList.get(0),"MyDima");

        adminList.get(0).actionSetPassword(userMap.get(1), "NePassword");
        adminList.get(0).actionSetPassword(adminList.get(1),"NePassword");
        adminList.get(0).actionSetPassword(adminList.get(0),"MyPassword");

        adminList.get(0).actionSetRole(userMap.get(1), Role.BANNED);
        adminList.get(0).actionSetRole(adminList.get(1),Role.USER);
        adminList.get(0).actionSetRole(adminList.get(0),Role.USER);

        userMap.get(5).actionSetName(userMap.get(7), "NeAndrey");
        userMap.get(5).actionSetName(userMap.get(5), "MySasha");

        userMap.get(5).actionSetPassword(userMap.get(7), "NePassword");
        userMap.get(5).actionSetPassword(userMap.get(5), "MyPassword");

        userMap.get(5).actionSetRole(userMap.get(7), Role.BANNED);
        userMap.get(5).actionSetRole(userMap.get(5), Role.BANNED);

        System.out.println(userMap);
        System.out.println(adminList);

        //неудачная попытка выкинуть исключение в стриме, можно ли как то?
        /*userMap.entrySet().stream()
                .filter(x -> x.getValue().getRole() == Role.BANNED)
                .map(x -> {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Остался забаненный пользователь");
                    }
                    return null;
                })
        ;*/

    }
}