package an.compuerv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("an/compuerv2/model")
public class Compuerv2Application {

    public static void main(String[] args) {
        SpringApplication.run(Compuerv2Application.class, args);
    }

}
