package nyc.c4q.rusili.grantme.network.pojo;

import java.util.HashMap;

public class User {

    public String email;
    public HashMap<String, JSONCourses> favorites = new HashMap <>();
    public String password;
    public String username;


    public User () {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User (String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername () {
        return username;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }

    public HashMap <String, JSONCourses> getJsonCourses () { return favorites; }
}
