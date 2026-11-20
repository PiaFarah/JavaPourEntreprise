package org.formation.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.formation.aop.model.Performance;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
    private final Performance performance;

    public Audience(Performance performance) {
        this.performance = performance;
    }

    @Pointcut("execution(* org.formation.aop.model.Performance.perform(..))")
    void performance(){
    }
//    @Before("performance()")
//    void silenceCellPhones()
//    {
//        System.out.println("Silence cell phones");
//    }
//
//    @AfterReturning("performance()")
//    void applause()
//    {
//        System.out.println("==Applause==");
//    }
//
//
//    @AfterThrowing("performance()")
//    void getAngry(){
//        System.out.println("Arrrrrg");
//    }
//
//    @After("performance()")
//    void leave(){
//        System.out.println("Leave");
//    }

    //methodes utilisees que par spring devraient etre en package private


    @Around("performance()") //remplace les before afterreturning,
    void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            System.out.println("Silence cell phones");
            ///method call
        joinPoint.proceed();
            System.out.println("==Applause==");

        }catch (Throwable e){ //la on ne voit pas lexception, c catch
            //e.printStackTree() ppour montrer lexception
            System.out.println("Arrrrrg");
        }
        finally {
            System.out.println("Leave");
        }
    }
}
