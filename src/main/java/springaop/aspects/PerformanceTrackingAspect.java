package springaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j(topic = "performance-logger")
public class PerformanceTrackingAspect {

//    @Around("execution(*  springaop.*.*.*(..))")
    @Around("springaop.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceeding) throws Throwable {
        long startTimer = System.currentTimeMillis();

        Object returnedValue = proceeding.proceed();

        long stopTimer = System.currentTimeMillis();

        long executionDuration = stopTimer - startTimer;
        log.info("Around Aspect - {} Method executed in {} ms", proceeding, executionDuration);

        return returnedValue;
    }
}
