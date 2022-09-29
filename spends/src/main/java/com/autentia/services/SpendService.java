package com.autentia.services;

import java.math.BigDecimal;

public interface SpendService {
    void calculateDebt(Long id, BigDecimal totalDebt);
}
