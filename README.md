## Doodleshop Continuous Delivery Demo Application

Features:

* Spring Boot runnable application with embedded Tomcat and deployable war
* Spring Boot Actuator with production grade services
* Automatic versioning in MANIFEST.MF and in resource /appversion read from build pipeline environment variable
* Environment detection using environment variable <code>se.caglabs.doodleshop.environment</code>
* Environment specific configuration and log configuration using Spring profiles (application.yaml)
* Unit tests and integration tests
* Flyway DB setup and migration
* Database H2, embedded if not specified external in application.yaml
 
### Build

<code>$ mvn install</code>

### Run Integration tests

<code>$ mvn -Pint-test verify</code>

### Run

<code>$ java -jar doodleshop.war</code>

For specific environment, specify:

<code>$ java -Dse.caglabs.doodleshop.environment=stage -jar doodleshop.war</code>

where <code>se.caglabs.doodleshop.environment</code> is (local | autosmall | autolarge | stage | prod)

### Test

The application has a few simple endpoints where you can store and read Doodles.

Create a doodle:
<code>$ curl -H "Content-Type: application/json" -X POST -d '{"author":"Hoomer","message":"Ummm..."}' http://localhost:8080/doodles</code>

Read created doodles:
<code>$ curl http://localhost:8080/doodles?author=Homer</code>

### Run with external MySQL

Start a MySQL database:
```
$ docker run --name mysql -e MYSQL_ROOT_PASSWORD=doodlepass -d -p 3306:3306 mysql:5.7
```

Connect a database tool and create a database:
```
create database doodleshop;
```
Run with "stage" environment: -Dse.caglabs.doodleshop.environment=stage


Have fun,
Daniel Marell
