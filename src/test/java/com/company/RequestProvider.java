package com.company;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import org.testng.annotations.DataProvider;

public class RequestProvider {

  @DataProvider(name = "requestProvider")
  private Iterator<Object[]> fileReader() throws Exception {
    Collection<Object[]> records = new ArrayList<Object[]>();

    try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/requests.csv")); ) {
      String[] values;

      while ((values = csvReader.readNext()) != null) {
        String request = values[0];
        Long id = Long.parseLong(values[1]);

        Object[] row = {request, id};
        records.add(row);
      }

      return records.iterator();
    }
  }
}
