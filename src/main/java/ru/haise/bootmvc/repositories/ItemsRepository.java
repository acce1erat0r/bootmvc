package ru.haise.bootmvc.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.haise.bootmvc.entities.Item;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long>, PagingAndSortingRepository<Item, Long> {
    Item findByTitle(String title);
    List<Item> findByCostBetween(int min, int max);
}
