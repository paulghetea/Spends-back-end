package com.autentia;

import com.autentia.dtos.SpendSaveCommand;
import com.autentia.dtos.UserSaveCommand;
import com.autentia.entities.Spend;
import com.autentia.entities.User;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SpendsControllerTest {
    private BlockingHttpClient blockingClient;
    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/") RxHttpClient client;

    @BeforeEach
    void setup() {
        blockingClient = client.toBlocking();
    }

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testPostGet(){
        final String result = client.toBlocking().retrieve("/spends");
        List<Spend> spends = new ArrayList<>();
        User mockUser = new User("test", new BigDecimal(10));
        mockUser.setIdUser(1L);
        HttpRequest<?> requestUser = HttpRequest.POST("/users",mockUser);
        HttpResponse<?> responseUser = blockingClient.exchange(requestUser);

        assertEquals(HttpStatus.CREATED, responseUser.getStatus());


        SpendSaveCommand mockSpend = new SpendSaveCommand("Test1",1L , new BigDecimal(10), new Date());
        HttpRequest<?> requestSpend = HttpRequest.POST("/spends",mockSpend);
        HttpResponse<?> responseSpend = blockingClient.exchange(requestSpend);

        assertEquals(HttpStatus.CREATED, responseSpend.getStatus());
    }

}
