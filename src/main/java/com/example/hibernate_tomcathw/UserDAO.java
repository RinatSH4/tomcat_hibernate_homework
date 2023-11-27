package com.example.hibernate_tomcathw;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserDAO {

    private static EntityManagerFactory MANAGER_FACT = Persistence.createEntityManagerFactory("hibernate");
    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager = MANAGER_FACT.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(user);
        entityTransaction.commit();
    }

    public void edit(User user, int id) {
        entityManager = MANAGER_FACT.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User newUser = entityManager.find(User.class, id);
        newUser.setUsername(user.getUsername());
        newUser.setAge(user.getAge());

        entityManager.persist(newUser);
        entityTransaction.commit();
    }

    public User find(String name) {
        entityManager = MANAGER_FACT.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        String query = "SELECT u FROM User u WHERE u.username = :user";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("user", name);
        User user = typedQuery.getSingleResult();

        return user;
    }

    public List<User> getAll() {
        entityManager = MANAGER_FACT.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        String query = "SELECT u FROM User u WHERE u.age >= :age1 AND u.age < :age2";

        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("age1", 10);
        typedQuery.setParameter("age2", 35);

        return typedQuery.getResultList();
    }

    public void delete(String username) {
        entityManager = MANAGER_FACT.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, find(username).getId());

        entityManager.remove(user);
        entityTransaction.commit();
    }
}
