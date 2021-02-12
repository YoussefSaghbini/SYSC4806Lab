package Lab4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab4ServerBootup {
    private static final Logger log = LoggerFactory.getLogger(Lab4ServerBootup.class);
    public static void main(String[] args) {
        SpringApplication.run(Lab4ServerBootup.class, args);
    }


}
