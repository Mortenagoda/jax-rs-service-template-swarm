package works.softwarethat.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import works.softwarethat.service.filters.AlwaysAcceptApplicationJsonFilter;
import works.softwarethat.service.resources.ExampleResource;

/**
 * Service application.
 *
 * @author mortena@gmail.com
 */
@ApplicationPath("/")
public class ServiceApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ExampleResource.class);
        classes.add(AlwaysAcceptApplicationJsonFilter.class);
        classes.add(ObjectMapperProvider.class);
        return classes;
    }

    @Provider
    public static class ObjectMapperProvider implements ContextResolver<ObjectMapper> {
        public ObjectMapper getContext(Class<?> aClass) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return mapper;
        }
    }
}