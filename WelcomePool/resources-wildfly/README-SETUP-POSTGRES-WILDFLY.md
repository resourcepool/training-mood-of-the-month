Source: 

https://marco.dev/use-postgresql-with-wildfly

___

Use your current postgresql driver.=(.jar)
____
Add PostgreSQL driver to WildFly
In [WILDFLY_HOME]/modules

create the directory:

/org/postgresql/main

and copy the jdbc file.

___
In /org/postgresql/main

create the module.xml file

```xml
<?xml version='1.0' encoding='UTF-8'?> 

<module xmlns="urn:jboss:module:1.1" name="org.postgresql"> 
    <resources> 
        <!--the name of your driver --> 
        <resource-root path="postgresql-42.3.1.jar"/> 
    </resources> 
 
    <dependencies> 
        <module name="javax.api"/> 
        <module name="javax.transaction.api"/> 
    </dependencies> 
</module> 
```

change the filename according to your jdbc driver

___

Add the datasource
In our case we use the standalone instance of WildFly.

Open [WILDFLY_HOME]/standalone/configuration/standalone.xml
Locate the existing datasources, probably you have an instance of H2 already configured:

Add the postgresql datasource, update according to your configuration:

This datasource references a driver names ‘postgresql’ that we have to add, in the section <datasources><drivers> :

```xml
        <subsystem xmlns="urn:jboss:domain:datasources:7.0">
            <datasources>
                <!-- 1. Select Postgres -->
                <datasource jndi-name="java:jboss/datasources/PostgresDS" pool-name="PostgresDS">
                    <connection-url>jdbc:postgresql://localhost:5432/welcomepool</connection-url>
                    <driver>postgresql</driver>
                    <security>
                        <!-- 2. PWD and USERNAME -->
                        <user-name>postgres</user-name>
                        <password>postgres</password>
                    </security>
                </datasource>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="postgresql" module="org.postgresql">
                        <!-- 3. Driver -->
                        <driver-class>org.postgresql.Driver</driver-class>
                    </driver>
                </drivers>
            </datasources>
        </subsystem>
```


Restart the server and check that the connection worked correctly.

You should see in the log a similar message that confirm the connection to your database.

``` 
22:28:20,210 INFO  [org.jboss.as.connector.subsystems.datasources] (ServerService Thread Pool -- 44) WFLYJCA0005: Deploying non-JDBC-compliant driver class org.postgresql.Driver (version 42.3)
22:28:20,221 INFO  [org.jboss.as.connector.deployers.jdbc] (MSC service thread 1-3) WFLYJCA0018: Started Driver service with driver-name = postgresql
```
Deploying non-JDBC-compliant driver?! Is it an error?
No, it’s not an error, the official JDBC driver is not compliant JDBC. You can find the false return value in the GitHub code here. In the code is clarified that: For PostgreSQL, this is not yet possible, as we are not SQL92 compliant (yet).

