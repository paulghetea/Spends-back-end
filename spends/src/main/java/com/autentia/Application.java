package com.autentia;

import com.autentia.services.RecalculateDebtService;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        final ApplicationContext context = Micronaut.run(Application.class);
        RecalculateDebtService service = context.getBean(RecalculateDebtService.class);
        System.out.println(service.newSpend());
        //context.close();
    }
}
