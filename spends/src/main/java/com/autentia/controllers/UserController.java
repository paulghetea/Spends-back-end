package com.autentia.controllers;

import com.autentia.dtos.SpendSaveCommand;
import com.autentia.dtos.UserSaveCommand;
import com.autentia.entities.Spend;
import com.autentia.entities.User;
import com.autentia.repository.SpendRepository;
import com.autentia.repository.UserRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/users")
class UserController {
    @Inject
    private UserRepository userRepository;

    @Get(value = "/list", produces = MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userRepository.findAll();
    }

    @Post(consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> save(@Body @Valid UserSaveCommand cmd) {
        try {
            User user = userRepository.save(new User(cmd.getName(), cmd.getPassword()));
            return HttpResponse.created(user);
        }catch(Exception e){
            e.printStackTrace();
            return HttpResponse.serverError();
        }

    }

}
