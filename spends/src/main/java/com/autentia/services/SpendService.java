package com.autentia.services;

import com.autentia.repository.SpendRepository;

import javax.inject.Singleton;

@Singleton
public class SpendService {

    private SpendRepository spendRepository;
    public String newSpend(){

        return "new Service";
    }
}
