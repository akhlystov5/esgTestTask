package info.fa.console.service;

import com.opencsv.CSVReader;
import info.fa.util.Converter;
import info.fa.model.dto.CustomerDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Slf4j
public class CustomerFileReaderService {

    private RestClient restClient = RestClient.create();

    private String uri;

    private Converter converter;

    public CustomerFileReaderService(@Value("${uri}") String uri, Converter converter) {
        this.uri = uri;
        this.converter =converter;
    }
    public List<CustomerDto> readFile(String fileName) {
        try {
            Path path = Paths.get(getClass().getClassLoader()
                    .getResource(fileName).toURI());

            List<CustomerDto> records = new ArrayList<>();
            try (CSVReader csvReader = new CSVReader(new FileReader(path.toString()));) {
                csvReader.readNext();//skip header
                String[] values;
                while ((values = csvReader.readNext()) != null) {
                    //TODO validation can be done
                    records.add(converter.convertArray(values));
                }
            }
            return records;
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException("can't read a file");// Exception can be standardised
        }
    }

    public void processFile(String fileName) {
        List<CustomerDto> list = this.readFile(fileName);

        list.forEach(request -> {
            restClient.post().uri(uri + "/v1/customer")
                    .body(request)
                    .retrieve()
                    .toBodilessEntity();
        });
    }
}
