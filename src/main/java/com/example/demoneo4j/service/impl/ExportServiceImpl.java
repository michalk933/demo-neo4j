package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.exception.ExportException;
import com.example.demoneo4j.model.*;
import com.example.demoneo4j.properties.ExportProperties;
import com.example.demoneo4j.service.*;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.example.demoneo4j.model.FileName.BOOK_FIEL_NAME;
import static com.example.demoneo4j.model.FileName.CATEGORY_FILE_NAME;
import static com.example.demoneo4j.model.FileName.USER_FILE_NAME;

@Service
@RequiredArgsConstructor
class ExportServiceImpl implements ExportService {

    private final ExportProperties exportProperties;

    private final UserService userService;

    private final BookService bookService;

    private final CategoriesService categoriesService;

    @Override
    public void exportDataBase() {
        exportUser();
        exportBook();
        exportCategories();

    }

    private void exportCategories(){
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(exportProperties.getFullPath(CATEGORY_FILE_NAME.name())));

            StatefulBeanToCsv<Categories> write = new StatefulBeanToCsvBuilder<Categories>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withOrderedResults(false)
                    .build();

            write.write(categoriesService.getCategoriesWithBooks());
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
            throw new ExportException("Something wrong during export categories db: ", e);
        }
    }

    private void exportBook(){
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(exportProperties.getFullPath(BOOK_FIEL_NAME.name())));

            StatefulBeanToCsv<Book> write = new StatefulBeanToCsvBuilder<Book>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withOrderedResults(false)
                    .build();

            write.write(bookService.getBooks());
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
            throw new ExportException("Something wrong during export book db: ", e);
        }
    }

    private void exportUser() {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(exportProperties.getFullPath(USER_FILE_NAME.name())));

            StatefulBeanToCsv<User> write = new StatefulBeanToCsvBuilder<User>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withOrderedResults(false)
                    .build();

            write.write(userService.getUsersWithBook());
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
            throw new ExportException("Something wrong during export user db: ", e);
        }
    }

}
