package demo.employee;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @Before("execution(* demo.employee.EmployeeService.*(..))")
    public void beforeServiceCall(JoinPoint jp) {
        System.out.println("[AUDIT] Calling "
                + jp.getSignature().getName());
    }

    @AfterReturning(
        "execution(* demo.employee.EmployeeService.*(..))")
    public void afterServiceCall(JoinPoint jp) {
        System.out.println("[AUDIT] Completed "
                + jp.getSignature().getName());
    }

    @AfterThrowing(
        pointcut = "execution(* demo.employee.EmployeeService.*(..))",
        throwing = "ex")
    public void serviceFailed(JoinPoint jp, Throwable ex) {
        System.out.println("[AUDIT] Failed "
                + jp.getSignature().getName()
                + ": " + ex.getMessage());
    }
}