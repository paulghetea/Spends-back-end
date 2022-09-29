package com.autentia.repositoryImpl;

import com.autentia.entities.User;
import com.autentia.repository.UserRepository;
import io.micronaut.data.annotation.Repository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
@Singleton
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @TransactionalAdvice(noRollbackFor = Exception.class)
    public User save(@NotBlank User user) {
        this.entityManager.persist(user);
        return user;
    }

    @ReadOnly
    public List<User> findAll() {
        String qlString = "from User";
        TypedQuery<User> query = entityManager.createQuery(qlString, User.class);
        return query.getResultList();
    }

    @Override
    @ReadOnly
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @ReadOnly
    public BigInteger countUsers() {
        return (BigInteger) entityManager.createNativeQuery("SELECT count(*) FROM Users").getSingleResult();
        //return null;
    }
    @Override
    @TransactionalAdvice(noRollbackFor = Exception.class)
    public void setDebt(Integer id, BigDecimal newDebt) {
        String qlString = "update User u set u.debt = u.debt + " + newDebt + " where u.idUser = " + id;
        entityManager.createQuery(qlString).executeUpdate();
    }
}

