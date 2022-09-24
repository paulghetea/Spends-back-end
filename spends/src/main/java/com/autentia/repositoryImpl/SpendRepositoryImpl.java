package com.autentia.repositoryImpl;

import com.autentia.entities.Spend;
import com.autentia.repository.SpendRepository;
import io.micronaut.data.annotation.Repository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.util.List;

    @Repository
    @Singleton
    public class SpendRepositoryImpl implements SpendRepository {
        @PersistenceContext
        private EntityManager entityManager;

        public SpendRepositoryImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        @Override
        @TransactionalAdvice
        public Spend save(@NotBlank Spend spend) {
            this.entityManager.persist(spend);
            return spend;
        }

        @ReadOnly
        public List<Spend> findAll() {
            String qlString = "from Spend";
            TypedQuery<Spend> query = entityManager.createQuery(qlString, Spend.class);
            return query.getResultList();
        }

    }

