package ru.haise.bootmvc.services;

import org.springframework.stereotype.Service;
import ru.haise.bootmvc.entities.Users;
import ru.haise.bootmvc.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;
    public static final Logger logger = Logger.getLogger("ru.haise.service.UserServiceImpl");


    @Override
    public List<Users> getAllUsers() {
        logger.info("This is simpli log");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> usersCriteriaQuery  = cb.createQuery(Users.class);
        Root<Users> usersRoot = usersCriteriaQuery.from(Users.class);
        usersCriteriaQuery.select(usersRoot);
        em.createQuery(usersCriteriaQuery)
                .getResultList()
                .forEach(System.out::println);
        return em.createQuery(usersCriteriaQuery).getResultList();
    }

    @Override
    public List<Users> getDescUsers() {

        return null;
    }
}
