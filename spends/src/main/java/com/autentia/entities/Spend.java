package com.autentia.entities;

import lombok.*;

import static javax.persistence.GenerationType.AUTO;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "spends")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Spend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "users", referencedColumnName = "idUser")
    private User user;

    @NonNull
    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @NonNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

}

