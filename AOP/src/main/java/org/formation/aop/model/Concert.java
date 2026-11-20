package org.formation.aop.model;

import org.springframework.stereotype.Component;

@Component //implicite pour recuperer le bean
public class Concert implements Performance {
    @Override
    public void perform() {
        System.out.println("Concert que jaime ...");

    }
}
