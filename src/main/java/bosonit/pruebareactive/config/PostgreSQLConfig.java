package bosonit.pruebareactive.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PostgreSQLConfig {
    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host("localhost")
                        .database("postgres")
                        .username("postgres")
                        .password("postgres")
                        .port(5432)
                        .build());
    }
}
