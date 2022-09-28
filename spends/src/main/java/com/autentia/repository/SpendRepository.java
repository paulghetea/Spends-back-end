package com.autentia.repository;

import com.autentia.entities.Spend;
import io.micronaut.data.annotation.Query;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public interface SpendRepository {
    List<Spend> findAll();
    Spend save(@NotNull Spend spend);


}
