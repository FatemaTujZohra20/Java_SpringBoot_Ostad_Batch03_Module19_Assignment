package com.chronicle.uni_enroll.UniEnroll.service;

import com.chronicle.uni_enroll.UniEnroll.model.Person;
import com.chronicle.uni_enroll.UniEnroll.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>UniversityService</h1>
 * The {@code UniversityService} class acts as the <b>Business Logic Layer</b> for university member operations.
 * <p>
 * <b>Spring Framework Role:</b>
 * Annotated with {@link org.springframework.stereotype.Service}, this class is a Spring-managed
 * <b>Singleton Bean</b> within the Application Context. This enables <b>Inversion of Control (IoC)</b>,
 * allowing Spring to manage its lifecycle and perform <b>Dependency Injection</b> whenever this
 * service is required by other components, such as REST Controllers.
 * </p>
 * <p>
 * It maintains the internal state of university members and provides an abstraction layer over
 * data storage, currently utilizing an in-memory collection for rapid development and testing.
 * </p>
 *
 * @version 1.0
 * @see com.chronicle.uni_enroll.UniEnroll.model.Person
 */
@Service
public class UniversityService {
    
    /**
     * Internal in-memory data store representing the collection of university members.
     * <p>
     * <b>Design Note:</b> This list is marked as {@code final} to prevent reference
     * reassignment after initialization. This ensures the integrity of the data store
     * throughout the application lifecycle, maintaining a consistent state for this
     * phase of the enrollment system development.
     * </p>
     */
    private final List<Person> members = new ArrayList<>();
    
    /**
     * Default constructor for the service.
     * <p>
     * <b>Data Seed Initialization Logic:</b>
     * When the Spring Application Context instantiates this bean, it automatically
     * performs a seeding operation, populating the {@code members} list with
     * hard-coded {@link Student} records. This ensures that the system has
     * immediate, viable data available for testing, demonstration, and
     * rapid development cycles.
     * </p>
     */
    public UniversityService() {
        members.add(new Student("John Doe", "johndoe@gmail.edu", "D101"));
        members.add(new Student("Smith Dakota", "smithdakota@gmail.edu", "D102"));
        members.add(new Student("Gilbert Harish", "gilbertharish@gmail.edu", "D103"));
        members.add(new Student("Missouri Stephani", "missouristephani@gmail.edu", "D104"));
    }
    
    /**
     * Retrieves an immutable, read-only view of all university members currently registered in the system.
     * <p>
     * <b>Implementation Detail:</b>
     * To enforce <b>Defensive Programming</b> and maintain the integrity of the internal state,
     * this method returns a list wrapped via {@link java.util.Collections#unmodifiableList}.
     * This <b>Defensive API Design</b> prevents external components from modifying the
     * underlying collection directly, ensuring that all state changes must go through
     * authorized service methods.
     * </p>
     *
     * @return an unmodifiable {@code List} of {@link Person} objects.
     */
    public List<Person> getAllMembers() {
        return Collections.unmodifiableList(members);
    }
    
    /**
     * Adds a new {@link Person} to the university registry and system records.
     * <p>
     * This method serves as the primary entry point for expanding the university
     * membership collection. It enforces strict null-safety to ensure the
     * integrity of the internal data store.
     * </p>
     *
     * @param person The {@link Person} (member) object to be added to the system;
     * must not be {@code null}.
     * @throws IllegalArgumentException if the provided {@code person} object is {@code null},
     * adhering to the "fail-fast" principle.
     */
    public void addMember(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Cannot add a null person to the system");
        }
        members.add(person);
    }
}
