package com.poltarabatko.lab4;

import com.opencsv.exceptions.CsvValidationException;
import com.poltarabatko.lab4.classes.ReaderCSV;

import java.io.IOException;


/**
 * @author r.poltarabatko
 */
public class Main {
    public static void main(String[] args) {
        ReaderCSV reader = new ReaderCSV();
        try {
            reader.parseCsv();
            reader.printParsedCsv();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}