package com.autentia.controllers;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.autentia.dtos.SpendSaveCommand;
import com.autentia.entities.Spend;
import com.autentia.entities.User;
import com.autentia.repository.SpendRepository;

import com.autentia.repository.UserRepository;
import com.autentia.services.SpendService;
import com.autentia.servicesImpl.SpendServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ExecuteOn(TaskExecutors.IO)
@Controller("/spends")
class SpendController {
    @Inject
    private SpendRepository spendRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private SpendService recalculateDebtService;


    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Spend> list() {
        return spendRepository.findAll();
    }

    @Post(consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> save(@Body @Valid SpendSaveCommand cmd) {
        try {
            User user = userRepository.findById(cmd.getUserId());
            Spend spend = spendRepository.save(new Spend(cmd.getDescription(), user, cmd.getCost(), cmd.getDate()));
            recalculateDebtService.calculateDebt(cmd.getUserId(), cmd.getCost());
            return HttpResponse.created(spend);
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.serverError();
        }
    }
}
