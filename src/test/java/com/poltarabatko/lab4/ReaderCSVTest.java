package com.poltarabatko.lab4;

import com.opencsv.exceptions.CsvValidationException;
import com.poltarabatko.lab4.classes.Person;
import com.poltarabatko.lab4.classes.ReaderCSV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author r.poltarabatko
 */
class ReaderCSVTest {

    /**
     * The instance of {@link ReaderCSV} used for testing.
     */
    private ReaderCSV readerCSV;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    void setUp() {
        readerCSV = new ReaderCSV();
    }

    /**
     * Tests the {@link ReaderCSV#parseCsv()} method to ensure that it correctly parses CSV data.
     *
     * @throws IOException           if an I/O error occurs.
     * @throws CsvValidationException if a CSV validation error occurs.
     */
    @Test
    void parseCsv_shouldParseAllData() throws IOException, CsvValidationException {
        // Parse CSV
        readerCSV.parseCsv();

        // Get the list of people
        LinkedList<Person> personList = readerCSV.getPersonList();

        // Ensure that personList is not empty
        assertFalse(personList.isEmpty(), "The list of people should not be empty.");

        // Check that the data matches the expected format
        for (Person person : personList) {
            assertNotNull(person.getId(), "Person ID should not be null.");
            assertNotNull(person.getName(), "Person name should not be null.");
            assertNotNull(person.getGender(), "Person gender should not be null.");
            assertNotNull(person.getSalary(), "Person salary should not be null.");
        }
    }
}
