package com.chronicle.uni_enroll.UniEnroll.controller;

import com.chronicle.uni_enroll.UniEnroll.model.Person;
import com.chronicle.uni_enroll.UniEnroll.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>PersonController</h1>
 * The {@code PersonController} serves as the primary <b>REST API Endpoint</b> for
 * university member resources, strictly adhering to <b>RESTful Architectural Styles</b>.
 * <p>
 * <b>Spring MVC Role:</b>
 * Annotated with {@link org.springframework.web.bind.annotation.RestController}, this class manages
 * the mapping between incoming HTTP requests and the underlying {@link UniversityService}.
 * Following the <b>Controller-Service-Repository</b> architectural pattern, it acts as a
 * "Traffic Controller" for the application, orchestrating data flow while ensuring the
 * web layer remains effectively decoupled from the core business logic.
 * </p>
 *
 * @version 1.0 (v1)
 * @see com.chronicle.uni_enroll.UniEnroll.service.UniversityService
 */
@RestController
@RequestMapping("/api/v1/members")   // Convention: Versioning and plural nouns
public class PersonController {
    
    /**
     * The business logic service dependency required for member operations.
     * Marked as {@code final} to ensure <b>Immutability</b> and to support
     * <b>Constructor-based Dependency Injection</b>.
     */
    private final UniversityService universityService;
    
    /**
     * Constructs the controller with <b>Constructor-based Dependency Injection</b>.
     * <p>
     * <b>Architectural Benefit & Spring 6+ Best Practices:</b>
     * Spring automatically injects the {@link UniversityService} bean at runtime.
     * Constructor injection is the industry-standard preference over field injection
     * for three critical reasons:
     * </p>
     * <ul>
     * <li><b>Immutability:</b> It allows the service dependency to be marked as {@code final}.</li>
     * <li><b>Initialization Safety:</b> It guarantees the controller is always
     * <b>initialized in a valid state</b>, preventing {@code NullPointerExceptions}.</li>
     * <li><b>Testability:</b> It simplifies Unit Testing by allowing the service to be
     * easily mocked without requiring a heavy Spring Context reflection.</li>
     * </ul>
     *
     * @param universityService The Spring-managed service bean providing the core
     * business logic for university member management.
     */
    @Autowired
    public PersonController (UniversityService universityService) {
        this.universityService = universityService;
    }
    
    /**
     * Handles HTTP GET requests to retrieve the full list of university members.
     * <p>
     * <b>Process Flow:</b>
     * When a client accesses {@code GET /api/v1/members}, Spring invokes this method
     * and utilizes the <b>Jackson Library</b> to automatically serialize the polymorphic
     * {@link List} of {@link Person} objects into a standard JSON array.
     * </p>
     *
     * @return A {@link List} of all {@link Person} members currently in the system registry.
     */
    @GetMapping
    public List<Person> getAllMembers(){
        return universityService.getAllMembers();
    }
}
