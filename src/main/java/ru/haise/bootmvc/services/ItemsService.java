package ru.haise.bootmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.haise.bootmvc.entities.Item;
import ru.haise.bootmvc.repositories.ItemsRepository;

import java.util.List;

@Service
public class ItemsService  {

    private ItemsRepository itemsRepository;

    @Autowired
    public void setItemsRepository(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Page<Item> getAll(){
        return  itemsRepository.findAll(PageRequest.of(2,3));
    }
    public Item findByTitle(String title){

       return itemsRepository.findByTitle(title);
    }

    public List<Item> findByCostBetween(int min, int max){

        return itemsRepository.findByCostBetween(min,max);
    }
}
