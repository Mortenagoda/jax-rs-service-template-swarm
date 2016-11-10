# jax-rs-service-template-swarm
Simple Service Temlate

# Build
You build the executable jar:
~~~
mvn package
~~~

# Running localhost

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
java -jar target/service-subscription-service-1.0-SNAPSHOT-swarm.jar
~~~

You can set the port manually by:
~~~
java -jar target/service-subscription-service-1.0-SNAPSHOT-swarm.jar -Dswarm.http.port=9090
~~~
