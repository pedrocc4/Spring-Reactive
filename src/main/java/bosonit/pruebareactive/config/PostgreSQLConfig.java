package bosonit.pruebareactive.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class PostgreSQLConfig {
    @Value("${db.host}")
    private String host;

    @Value("${db.database}")
    private String database;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.port}")
    private int port;

    @Bean
    PostgresqlConnectionFactory connectionFactory() {
      log.info(host + database + username + password + port);
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(host)
                        .database(database)
                        .username(username)
                        .password(password)
                        .port(port)
                        .build());
    }
}
