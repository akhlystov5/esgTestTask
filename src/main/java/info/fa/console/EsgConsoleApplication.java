package info.fa.console;


import info.fa.console.service.CustomerFileReaderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class EsgConsoleApplication implements CommandLineRunner {

    CustomerFileReaderService customerFileReaderService;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(EsgConsoleApplication.class, args);
        ctx.close();
    }

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            log.info("args[{}]: {}", i, args[i]);
        }

        String fileName = args[0];
        customerFileReaderService.processFile(fileName);
    }
}
