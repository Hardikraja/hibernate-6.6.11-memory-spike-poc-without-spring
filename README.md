# Hibernate Memory Usage Reproducer

This POC reproduces a memory spike issue in Hibernate as reported in [Hibernate Issue HHH-19292](https://hibernate.atlassian.net/browse/HHH-19292).  
It is a pure Hibernate POC that does **not** use Spring or JPA.

## Steps to Reproduce

### 1. Clone the Project
```sh
git clone https://github.com/Hardikraja/hibernate-6.6.11-memory-spike-poc-without-spring
```

### 2. Create Database in PostgreSQL
This project requires PostgreSQL. Create a database before running the test.

```sql
CREATE DATABASE test_database_one;
```

### 3. Update Database Configurations
Edit `src/main/resources/hibernate.cfg.xml` and update your database credentials:

```xml
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/{DATABASE_NAME}</property>
<property name="hibernate.connection.username">{USERNAME}</property>
<property name="hibernate.connection.password">{PASSWORD}</property>
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
```

### 4. Run the Test with Hibernate 6.6.11.Final (Expected Memory Spike)

By default, pom.xml is configured with Hibernate 6.6.11.Final, which causes a memory spike.
Run the Main method, and the runtime will print memory usage details in the console.

#### HQL Query in `Main` Method
The `Main` method contains an **HQL query** that is causing the memory spike when calling `createQuery` from HQL.  
To analyze the issue, memory usage is printed **before** and **after** executing `createQuery`


#### Something like below :
```
Memory Usage Before Create Query:
----------------------------
Total Memory: 98304 KB
Used Memory : 19642 KB

Memory Usage After Create Query:
----------------------------
Total Memory: 1351680 KB
Used Memory : 574257 KB
```

### 5. Test with Hibernate 6.5.3.Final (Expected Lower Memory Usage)

- Edit `pom.xml`
- Comment out `6.6.11.Final` and uncomment `6.5.3.Final`:

```xml
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <!--<version>6.6.11.Final</version>--> 
    <version>6.5.3.Final</version> <!--working fine-->
</dependency>
```

- Reload Maven and run `Main` again.

### Conclusion
Using **Hibernate 6.5.3.Final** results in significantly lower memory consumption compared to **6.6.11.Final**.