package com.chronicle.uni_enroll.UniEnroll.model;

/**
 * <h1>Student Entity</h1>
 * The {@code Student} class represents a specific type of {@link Person}
 * enrolled in the university.
 * <p>
 * It extends the abstract {@code Person} base class and provides a specific
 * implementation of the {@code describeRole} method to reflect the student's
 * status and identity.
 * </p>
 * @version 1.0
 */
public class Student extends Person {
    
    /**
     * Unique university-issued identification string.
     * Marked as final to ensure immutability of the student's identity record.
     */
    private final String studentId;
    
    /**
     * Constructs a new Student with validated attributes.
     * <p>
     * This constructor leverages the parent {@code Person} constructor for
     * name and email validation while performing its own defensive check
     * on the studentId.
     * </p>
     * @param name      The student's full legal name.
     * @param email     The student's university email address.
     * @param studentId The unique identifier for the student (cannot be null or blank).
     * @throws IllegalArgumentException if studentId is null or blank.
     */
    public Student (String name, String email, String studentId) {
        super(name, email);     // Delegates validation of name/email to Person
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be null or blank");
        }
        this.studentId = studentId;
    }
    
    /**
     * Implements the polymorphic contract from {@link Person}.
     * Returns a formatted string identifying the person as an enrolled student.
     * @return a {@code String} representation of the student's role and ID.
     */
    @Override
    public String describeRole() {
        return "Enrolled Student [ID: " + studentId + "]";
    }
    
    /**
     * Retrieves the student's unique identification string.
     * @return a {@code String} representing the student ID.
     */
    public String getStudentId() {
        return studentId;
    }
}
