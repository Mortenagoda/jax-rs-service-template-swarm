package works.softwarethat.service.persistence.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

import java.util.ArrayList;
import java.util.List;

/**
 * A user.
 *
 * @author Morten Andersen (mortena@gmail.com)
 */
@Entity("Users")
@Indexes(
        @Index(value = "emailIndex", fields = @Field("email"))
)
public class User {
    @Id
    private ObjectId id;
    private String email;
    private String password;
    private List<Role> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList<Role>();
        }
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }
}
