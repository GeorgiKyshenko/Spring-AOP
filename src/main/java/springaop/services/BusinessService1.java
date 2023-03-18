package springaop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springaop.annotations.TrackTime;
import springaop.data.Repository1;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusinessService1 {

    private final Repository1 repository1;

    @TrackTime
    public int calculateMax() throws InterruptedException {
        Thread.sleep(3000);
        return Arrays.stream(repository1.getData()).max().orElse(0);
    }

    public void throwExc() {
        repository1.testExc();
    }

    public String pointCutTest() {
        return "Test Specific Method Pointcut";
    }
}
