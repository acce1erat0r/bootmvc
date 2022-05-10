package ru.haise.bootmvc.repositories;

import ru.haise.bootmvc.entities.Users;

import java.util.List;

public interface UserRepository {
    List<Users> getAllUsers();
    List<Users> getDescUsers();
}
