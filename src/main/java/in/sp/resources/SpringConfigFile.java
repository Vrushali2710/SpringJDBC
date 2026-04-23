package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
public class SpringConfigFile {

//    EmbeddedDatabaseBuilder:

//This is a fluent API provided by Spring specifically to create embedded (in-memory) databases like H2, HSQL, or Derby.
//
//   It initializes a database instance within the JVM of your application. When the application stops, the database (and all its data) vanishes.
//
//  It allows you to chain methods to execute SQL scripts (like schema.sql and data.sql) automatically upon startup.
//
// Extremely fast because it resides in RAM and requires no network overhead.


    @Bean
    public DataSource myDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
    }
//   DriverManagerDataSource creates a new connection every time getConnection() is called.
// It connects to external databases that persist data after the application shuts down.
// Because it doesn't pool connections, it is relatively slow for production use. In a real-world app, you’d usually wrap this in a connection pool like HikariCP.

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/mydb");
//        ds.setUsername("user");
//        ds.setPassword("pass");
//        return ds;
//    }
//JdbcTemplate is the tool you use to actually talk to the database.
//    It is a central class in the Spring JDBC hierarchy that cleans up all the "boilerplate" code associated with traditional JDBC (opening connections, handling exceptions, closing statements).
//It automatically opens and closes connections and statements.
//   It converts checked SQLExceptions into Spring's consistent, unchecked DataAccessException hierarchy.
//     It uses PreparedStatement under the hood, helping you avoid SQL injection.
//     It maps database rows directly to Java objects or maps with just a few lines of code.
    @Bean
    public JdbcTemplate myJdbcTemplate() {
        JdbcTemplate myJdbcTemplate = new JdbcTemplate();
        myJdbcTemplate.setDataSource(myDataSource());
        return myJdbcTemplate;
    }
}
