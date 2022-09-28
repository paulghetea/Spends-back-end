package com.autentia.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String username;

    @NonNull
    @Column(name = "debt", nullable = false)
    private BigDecimal debt;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @JsonIgnore
    private Set<Spend> spends = new HashSet<>();

}