package org.formation.aop;

import org.formation.aop.model.BadConcert;
import org.formation.aop.model.Concert;
import org.formation.aop.model.Performance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
        Performance performance = context.getBean("concert",Performance.class);
        performance.perform();
    }

//    @Bean //explicit methode a creer
//     Performance concert() {
//        return new BadConcert();
//    }
}
