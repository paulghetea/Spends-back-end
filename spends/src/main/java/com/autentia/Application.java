package com.autentia;

import com.autentia.entities.Spend;
import com.autentia.entities.User;
import com.autentia.services.SpendService;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import java.math.BigDecimal;
import java.util.Date;

public class Application {

    public static void main(String[] args) {
        final ApplicationContext context = Micronaut.run(Application.class);
        SpendService service = context.getBean(SpendService.class);
        System.out.println(service.newSpend());
        //context.close();
    }
}
