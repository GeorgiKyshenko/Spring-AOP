package springaop.data;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import springaop.annotations.TrackTime;

@Repository
public class Repository1 {

    @TrackTime
    public int[] getData() throws InterruptedException {
        Thread.sleep(2000);
        return new int[]{3, 5, 8, 17, 7, 24, 25, 32};
    }

    public void testExc() {
        throw new RuntimeException("Testing @AfterThrowing annotation");
    }
}
