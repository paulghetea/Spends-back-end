package com.autentia;

import com.autentia.servicesImpl.SpendServiceImpl;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        final ApplicationContext context = Micronaut.run(Application.class);
        SpendServiceImpl service = context.getBean(SpendServiceImpl.class);
        System.out.println(service.helloAutentia());
        //context.close();
    }
}
