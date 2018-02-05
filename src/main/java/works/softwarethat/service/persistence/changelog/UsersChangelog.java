package works.softwarethat.service.persistence.changelog;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.mongodb.morphia.Datastore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import works.softwarethat.service.persistence.model.Role;
import works.softwarethat.service.persistence.model.User;

import javax.enterprise.inject.spi.CDI;

/**
 * Users changelog.
 *
 * @author Morten Andersen (mortena@gmail.com)
 */
@ChangeLog
public class UsersChangelog {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersChangelog.class);

    /**
     * Adds the first user to the system. This will be the only user in the system from the very beginning.
     */
    @ChangeSet(
            order = "001", author = "mortena@gmail.com", id = "addUsersCollection"
    )
    public void addSuperUser() {
        // Lets just use morphia for persisting the user
        Datastore datastore = CDI.current().select(Datastore.class).get();

        User user = new User();
        user.setEmail("mortena@gmail.com");
        user.setPassword("passw0rd");
        user.addRole(Role.SUPER_ADMIN);

        datastore.save(user);

        LOGGER.info("Added super user: " + user.toString());
    }
}
