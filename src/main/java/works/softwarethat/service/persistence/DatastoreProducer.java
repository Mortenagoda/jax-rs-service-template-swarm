package works.softwarethat.service.persistence;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 * Produces the datastore object.
 *
 * @author Morten Andersen (mortena@gmail.com)
 */
public class DatastoreProducer {

    @Produces
    @Singleton
    public Datastore getDatastore() {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("works.softwarethat.service.persistence.model");

        final Datastore datastore = morphia.createDatastore(new MongoClient(), "sampleDatabase");
        datastore.ensureIndexes();
        return datastore;
    }
}
