package works.softwarethat.service;

/**
 * Starts the application delegating to the Swarm main method.
 *
 * @author Morten Andersen (mortena@gmail.com)
 */
public class Main {
    public static void main(String[] args) throws Throwable {
        org.wildfly.swarm.Swarm.main(args);
    }
}
