package lt.pasakinskas.homeworkexample.persistence;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DatasourceConfig {

  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder
      .create()
      .driverClassName("com.mysql.cj.jdbc.Driver")
      .url("jdbc:mysql://localhost:3307/todolist-test")
      .username("tester")
      .password("password")
      .build();
  }
}