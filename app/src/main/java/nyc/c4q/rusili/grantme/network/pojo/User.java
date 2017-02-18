package nyc.c4q.rusili.grantme.network.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String username;
    public String email;
    public String password;
    public String urlPicture;

    public List<JSONCourses> jsonCourses = new ArrayList<>();

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String password) {
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

    public String getUrlPicture () {
        return urlPicture;
    }

}
