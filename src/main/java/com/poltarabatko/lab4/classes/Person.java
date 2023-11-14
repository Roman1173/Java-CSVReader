package com.poltarabatko.lab4.classes;

/**
 * @author r.poltarabatko
 */
public class Person {
    /**
     * The unique identifier for the person.
     */
    private final int id;

    /**
     * The name of the person.
     */
    private final String name;

    /**
     * The gender of the person. Use constants MALE or FEMALE.
     */
    private final String gender;

    /**
     * The division to which the person belongs.
     */
    private final Division division;

    /**
     * The salary of the person.
     */
    private final double salary;

    /**
     * The birth date of the person.
     */
    private final String birthDate;

    /**
     * Constant representing male gender.
     */
    public static final String MALE = "Male";

    /**
     * Constant representing female gender.
     */
    public static final String FEMALE = "Female";

    /**
     * Constructs a new Person object with the specified details.
     *
     * @param id        The unique identifier for the person.
     * @param name      The name of the person.
     * @param gender    The gender of the person. Use constants MALE or FEMALE.
     * @param division  The division to which the person belongs.
     * @param salary    The salary of the person.
     * @param birthDate The birth date of the person.
     */
    public Person(int id, String name, String gender, Division division, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Retrieves the unique identifier of the person.
     *
     * @return The unique identifier of the person.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the gender of the person.
     *
     * @return The gender of the person.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Retrieves the salary of the person.
     *
     * @return The salary of the person.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return id + ";" + name + ";" + gender + ";" + birthDate + ";" + division.getName() + ";" + salary;
    }
}
