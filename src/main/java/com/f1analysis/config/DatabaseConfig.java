package com.f1analysis.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Database configuration and connection verification.
 */
@Configuration
public class DatabaseConfig {

    /**
     * Verify database connection on startup.
     * 
     * This runs when the app starts and logs whether the database
     * connection was successful.
     */
    @Bean
    CommandLineRunner verifyDatabaseConnection(DataSource dataSource) {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                String dbUrl = connection.getMetaData().getURL();
                System.out.println("============================================");
                System.out.println("✅ DATABASE CONNECTION SUCCESSFUL!");
                System.out.println("   Connected to: " + dbUrl);
                System.out.println("============================================");
            } catch (Exception e) {
                System.out.println("============================================");
                System.out.println("❌ DATABASE CONNECTION FAILED!");
                System.out.println("   Error: " + e.getMessage());
                System.out.println("");
                System.out.println("   Make sure you've set these environment variables:");
                System.out.println("   - SUPABASE_DB_URL");
                System.out.println("   - SUPABASE_DB_USER");
                System.out.println("   - SUPABASE_DB_PASSWORD");
                System.out.println("");
                System.out.println("   Get these from: Supabase Dashboard → Project Settings → Database");
                System.out.println("============================================");
            }
        };
    }
}

