package org.formation.aop.model;

import org.springframework.stereotype.Component;

//@Component
public class BadConcert implements Performance {
    @Override
    public void perform() {
        System.out.println("Je risss ...");
        throw new RuntimeException("Au secours"); //runtimeexception pas besoin de le catch on peut ou pas
    }
}
