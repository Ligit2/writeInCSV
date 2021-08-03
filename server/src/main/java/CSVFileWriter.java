import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVFileWriter {
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final Object[] FILE_HEADER = {"firstName", "surName", "age", "address"};

    public static void writeCsvFile(String fileName, List<Person> people) {
        FileWriter fileWriter = null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        CSVPrinter csvFilePrinter = null;
        try {
            fileWriter = new FileWriter(fileName);
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
            csvFilePrinter.printRecord(FILE_HEADER);
            for (int i = 0; i < people.size(); i++) {
                List<String> strings = new ArrayList<>();
                strings.add(people.get(i).getName());
                strings.add(people.get(i).getSurname());
                strings.add(people.get(i).getAge());
                strings.add(people.get(i).getAddress());
                csvFilePrinter.printRecord(strings);
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void writeOnDiffFiles(Map<Character, List<Person>> mapOfPeople) {
        mapOfPeople.keySet().stream().forEach(key -> {
            writeCsvFile(key.toString() + ".csv", mapOfPeople.get(key));
        });
    }
}
