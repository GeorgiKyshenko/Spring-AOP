package springaop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springaop.services.BusinessService1;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class AspectOrientedProgrammingApplication implements CommandLineRunner {

    private final BusinessService1 businessService1;

    public static void main(String[] args) {
        SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Returned value is {}", businessService1.calculateMax());
        businessService1.pointCutTest();
//        businessService1.throwExc();
    }
}
