package springaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

//1.Define the class as Configuration
//2.Define the class as Aspect

@Configuration
@Aspect
@Slf4j
public class LoggingAspect {

    //Pointcut - When this should be called ?
    @Before("springaop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()") // configuring the Pointcut so we dont have to change it on every method if the package is changed
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        //Logic - What to do ?
        log.info("Before Aspect {} - is called with arguments - {}", joinPoint, joinPoint.getArgs());
    }

    @Before("springaop.aspects.CommonPointcutConfig.businessTestPointcutMethod()") // configuring the Pointcut so we dont have to change it on every method if the package is changed
    public void logMethodBusinessPointcutTest(JoinPoint joinPoint) {
        log.info("Before Aspect for pointCutTest {} - is called", joinPoint);
    }

    @After("springaop.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        //This method will be executed even when exception is thrown in the package class methods
        log.info("After Aspect {} - has executed only business methods", joinPoint);
    }

    @AfterThrowing(
            pointcut = "execution(*  springaop.*.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        //throwing = "exception" will be mapped to Exception exception
        log.error("After Throwing Aspect {} - has thrown an exception", joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "execution(*  springaop.*.*.*(..))",
            returning = "result"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object result) {
        //this is executed ONLY if the method is executed successfully (returns a result)
        log.info("After Returning Aspect {} - has returned {}", joinPoint, result);
    }
}
