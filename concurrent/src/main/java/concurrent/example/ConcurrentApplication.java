package concurrent.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "concurrent.example")
public class ConcurrentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrentApplication.class, args);
    }

}
