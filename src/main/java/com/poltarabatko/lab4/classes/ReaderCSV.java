package com.poltarabatko.lab4.classes;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author r.poltarabatko
 */
public class ReaderCSV {

    /**
     * Flag indicating whether the CSV file has been parsed.
     */
    private boolean fileParsed;

    /**
     * The path to the CSV file.
     */
    private String filePath = "src/main/resources/foreign_names.csv";

    /**
     * The field separator used in the CSV file.
     */
    private char fieldSeparator = ';';

    /**
     * A list to store Person objects parsed from the CSV file.
     */
    private LinkedList<Person> personList = new LinkedList<>();

    /**
     * A set to store unique Division objects parsed from the CSV file.
     */
    private HashSet<Division> divisionHashSet = new HashSet<>();

    /**
     * The CSV parser with the specified field separator.
     */
    private CSVParser csvParser = new CSVParserBuilder().withSeparator(fieldSeparator).build();

    /**
     * Parses the CSV file, extracts information, and creates Person and Division objects.
     *
     * @throws IOException              If an I/O error occurs.
     * @throws CsvValidationException    If there is an issue with CSV validation.
     */
    public void parseCsv() throws IOException, CsvValidationException {
        if (fileParsed) {
            System.out.println("The file was already parsed");
            return;
        }

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {

            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }

            String[] line;
            while ((line = reader.readNext()) != null) {
                String name = line[4];
                Division division = null;

                for (Division department : divisionHashSet) {
                    if (department.getName().equals(name)) {
                        division = department;
                        break;
                    }
                }

                if (division == null) {
                    division = new Division(name);
                    divisionHashSet.add(division);
                }

                String gender = parseGender(line[2]);

                Person person = new Person(
                        Integer.parseInt(line[0]),
                        line[1],
                        gender,
                        division,
                        Double.parseDouble(line[5]),
                        line[3]
                );
                personList.add(person);
            }
        }
        fileParsed = true;
    }

    /**
     * Parses the gender string and returns a standardized representation.
     *
     * @param genderString The gender string to be parsed.
     * @return A standardized gender representation ("Male" or "Female").
     */
    private String parseGender(String genderString) {
        return "Male".equalsIgnoreCase(genderString) ? "Male" : "Female";
    }

    /**
     * Prints the details of parsed persons to the console.
     */
    public void printParsedCsv() {
        if (fileParsed) {
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.toString());
            }
        } else {
            System.out.println("The file was not parsed yet");
        }
    }

    /**
     * Gets a copy of the list of parsed persons.
     *
     * @return A new LinkedList containing the parsed Person objects.
     */
    public LinkedList<Person> getPersonList() {
        return new LinkedList<>(personList);
    }
}
