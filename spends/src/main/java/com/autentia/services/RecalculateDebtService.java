package com.autentia.services;

import com.autentia.entities.User;
import com.autentia.repository.SpendRepository;
import com.autentia.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Singleton
public class RecalculateDebtService {
    @Inject
    private SpendRepository spendRepository;
    @Inject
    private UserRepository userRepository;
    public String newSpend(){
        return "Hello Autentia";
    }
    public void calculateDebt(Long id, BigDecimal totalDebt){
       Integer idSpender = id.intValue();
       Integer numUsers = userRepository.countUsers().intValue();
       //Dividimos la deuda total entre el número de usuarios para repartir la deuda
       BigDecimal sharedDebt = totalDebt.divide(BigDecimal.valueOf(numUsers), 2, RoundingMode.HALF_UP);
       System.out.println(sharedDebt+"-------------------------------------------");
        for (int i = 1; i < numUsers+1; i++) {
            if(i==idSpender){
                //Añadimos el dinero aportado por el comprador del gasto en la deuda
                userRepository.setDebt(i,totalDebt.subtract(sharedDebt) );
            }
            else{
                //Repartimos la deuda entre el resto de usuarios de forma negativa
                userRepository.setDebt(i, sharedDebt.negate());
            }
        }
    }
}
