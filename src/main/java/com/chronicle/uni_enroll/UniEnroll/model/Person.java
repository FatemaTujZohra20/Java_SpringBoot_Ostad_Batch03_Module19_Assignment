package com.chronicle.uni_enroll.UniEnroll.model;

import java.io.Serial;
import java.io.Serializable;

/**
 * <h1>Person (Abstract Base Entity)</h1>
 * The {@code Person} class serves as the foundational abstract model for all
 * participants in the University Enrollment System.
 * <p>
 * This class implements {@link Serializable} to allow for object state
 * persistence and network transmission. By being abstract, it enforces
 * a structured inheritance hierarchy for specific roles like Students or Faculty.
 * </p>
 * @version 1.0
 */
public abstract class Person implements Serializable {
    
    /**
     * Unique identifier for the serialization runtime to verify that the
     * sender and receiver of a serialized object have loaded classes for
     * that object that are compatible with respect to serialization.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    
    /**
     * The full legal name of the person.
     * This field is used for identification across university records.
     */
    private String name;
    
    /**
     * The official university email address.
     * Must follow the institutional format (e.g., user@university.edu)
     * and serves as the primary unique contact identifier.
     */
    private String email;
    
    /**
     * Default constructor.
     * Required for various Java frameworks (JPA, Jackson, etc.)
     * to instantiate the object via reflection.
     */
    public Person () {
    }
    
    /**
     * Parameterized constructor for initializing a Person with core attributes.
     * @param name  The full name of the individual.
     * @param email The university-affiliated email address.
     */
    public Person (String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // --- Accessor and Mutator Methods (Encapsulation) ---
    
    /**
     * Retrieves the person's full name.
     * @return a {@code String} representing the name.
     */
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the university email address.
     * @return a {@code String} representing the email.
     */
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
}
