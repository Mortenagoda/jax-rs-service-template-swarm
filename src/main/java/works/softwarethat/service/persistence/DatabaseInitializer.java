package works.softwarethat.service.persistence;

import com.github.mongobee.Mongobee;
import com.github.mongobee.exception.MongobeeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Initializer for database.
 *
 * @author Morten Andersen (mortena@gmail.com)
 */
@Singleton
@Startup
public class DatabaseInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInitializer.class);

    @PostConstruct
    public void initMongoDatabase() {
        Mongobee runner = new Mongobee();
        runner.setDbName("sampleDatabase");
        runner.setChangeLogsScanPackage(
                "works.softwarethat.service.persistence.changelog");

        try {
            runner.execute();
        } catch (MongobeeException e) {
            throw new RuntimeException("Unable to run changelogs.", e);
        }
        LOGGER.info("DatabaseInitializer done!");
    }
}
