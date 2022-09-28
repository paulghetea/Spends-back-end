package com.autentia.dtos;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Introspected
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserSaveCommand {

    @NonNull
    private String username;

}