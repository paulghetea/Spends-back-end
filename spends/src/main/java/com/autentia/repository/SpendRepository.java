package com.autentia.repository;

import com.autentia.entities.Spend;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SpendRepository {
    List<Spend> findAll();

    Spend save(@NotNull Spend spend);


}
