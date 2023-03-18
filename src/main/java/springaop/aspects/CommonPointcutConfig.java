package springaop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(*  springaop.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(*  springaop.services.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(*  springaop.services.BusinessService1.pointCutTest(..))")
    public void businessTestPointcutMethod() {}

    @Pointcut("bean(*Service*)") //all beans who have "Service" in their name
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(springaop.annotations.TrackTime)") //all methods with this annotation (its custom annotation)
    public void trackTimeAnnotation() {}
}
