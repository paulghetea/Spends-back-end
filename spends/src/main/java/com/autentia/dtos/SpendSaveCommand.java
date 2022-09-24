package com.autentia.dtos;

import com.autentia.entities.User;
import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Introspected
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class SpendSaveCommand {

    @NonNull
    private String name;

    @NonNull
    private Long userId;

    @NonNull
    private BigDecimal cost;

    @NonNull
    private Date date;

}