import java.util.Objects;

public class UserService {

//    private User[] users = new User[]{
//            new User(1L, "Ahmet Gültekin", "ahmet", "ahmet123"),
//            new User(2L, "Asım Kılıç", "asim", "asim123")
//    };

    private User[] users = new User[DomainConstants.ARRAY_OPENING_COUNT];
    private User currentUser = null;

    private int userCount = 0;

    // add user
    public void addUser(User user) throws Exception {
        boolean isUserAlreadyExist = isUserAlreadyExist(user.getUsername());
        if (isUserAlreadyExist) {
            System.out.println("Kullanıcı zaten kayıtlı, " + user);
            return;
        }
        if (userCount == users.length) {
            reInitializeArray();
        }
        users[userCount] = user;
        userCount++;
        System.out.println("Kullanıcı başarıyla eklendi.");

    }

    // remove user ( yetkili kişilerin çağırabilmesi gerekiyor)

    public void removeUser(String username) {
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equalsIgnoreCase(username)) {
                index = i;
                break;
            }
        }
        /*
        0 1 2 3 4    null null null
        0 1 3 3 4    null null null
        0 1 3 4 4    null null null
        0 1 3 4 null null null null
         */
        if (index != -1) {
            for (int i = index; i < userCount; i++) {
                users[i] = users[i + 1];
            }
            users[userCount - 1] = null;
            userCount--;
            System.out.println(username + " başarıyla silindi.");
            return;
        }
        System.out.println(username + " bulunamadı.");
    }

    // user search

    public User searchUser(String username) {
        User searchedUser = null;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equalsIgnoreCase(username)) {
                searchedUser = users[i];
            }
        }
        return searchedUser;
    }

    // login
    public void login(String username, String password) {
        User user = searchUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println(username + " başarıyla giriş yapıldı.");
                return;
            }
        }
        System.out.println("Kullanıcı adı veya şifre hatalı.");

    }

    // logout
    public void logout() {
        currentUser = null;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean isUserAlreadyExist(String username) throws Exception {
        if (Objects.isNull(username)
            || username.isBlank()
            || username.isEmpty()) {
            throw new Exception("Kullanıcı boş olamaz");
        }
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    private void reInitializeArray() {
        User[] tempUsers = new User[users.length + DomainConstants.ARRAY_INCREASE_COUNT];
        System.arraycopy(users, 0, tempUsers, 0, users.length);
        users = tempUsers;

    }

}
