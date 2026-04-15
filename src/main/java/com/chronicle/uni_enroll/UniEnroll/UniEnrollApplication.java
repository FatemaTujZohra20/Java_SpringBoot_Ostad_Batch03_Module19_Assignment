package com.chronicle.uni_enroll.UniEnroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>UniEnrollApplication</h1>
 * The {@code UniEnrollApplication} class serves as the <b>Primary Entry Point</b>
 * and configuration hub for the University Enrollment System.
 * <p>
 * <b>Spring Boot Bootstrap:</b>
 * Annotated with {@link SpringBootApplication}, this class triggers the
 * <b>Auto-Configuration</b>, <b>Component Scanning</b>, and <b>Property Support</b>
 * mechanisms. It effectively initializes the Spring Application Context,
 * discovering all {@code @Service}, {@code @RestController}, and other managed
 * beans defined within the project sub-packages.
 * </p>
 *
 * @version 1.0 (v1)
 */
@SpringBootApplication
public class UniEnrollApplication {
    
    /**
     * The main method that launches the Spring Boot application.
     * <p>
     * <b>Execution Logic:</b>
     * This method delegates to {@link SpringApplication#run}, which performs the
     * following startup steps:
     * </p>
     * <ul>
     * <li>Starts the embedded Servlet Container (default: Apache Tomcat).</li>
     * <li>Performs a classpath scan to wire dependencies.</li>
     * <li>Activates relevant Spring Profiles.</li>
     * <li>Exposes the REST API endpoints defined in the Controller layer.</li>
     * </ul>
     *
     * @param args Command-line arguments passed to the application during startup.
     */
    public static void main (String[] args) {
        SpringApplication.run(UniEnrollApplication.class, args);
    }
    
}
