package br.com.tadeu.javabank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class TimestampConfig {
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
