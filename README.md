# jax-rs-service-template-swarm
Simple Service Template

# Build
You build the executable jar:
~~~
mvn package
~~~

# Running localhost

##
Start Mongodb using docker:
~~~
docker run -it -d --name mongoTest -p 27017:27017 mongo
~~~

Then run application:

## Using maven
Starting using the wildfly-swarm plugin:
~~~
mvn wildfly-swarm:run
~~~

If you have port issues, you can manually override it:
~~~
mvn wildfly-swarm:run -Dswarm.http.port=9090
~~~

## Using java
The target jar is executable:
~~~
java -jar target/service-1.0-SNAPSHOT-swarm.jar
~~~

You can set the port manually by:
~~~
java -jar target/service-1.0-SNAPSHOT-swarm.jar -Dswarm.http.port=9090
~~~
