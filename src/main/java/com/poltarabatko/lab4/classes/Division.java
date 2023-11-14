package com.poltarabatko.lab4.classes;

/**
 * @author r.poltarabatko
 */
public class Division {
    /** Counter to track the unique identifier for each division. */
    private static int idCounter = 1;

    /** The unique identifier of the division. */
    private final int id;

    /** The name of the division. */
    private final String name;

    /**
     * Constructs a new {@code Division} instance with the specified name.
     *
     * @param name The name of the division.
     */
    public Division(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    /**
     * Gets the unique identifier of the division.
     *
     * @return The unique identifier of the division.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the division.
     *
     * @return The name of the division.
     */
    public String getName() {
        return name;
    }
}
