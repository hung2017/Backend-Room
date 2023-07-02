package com.example.pokemon_teddy.reponsitory;

import com.example.pokemon_teddy.model.Role;
import com.example.pokemon_teddy.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepo extends JpaRepository<Room,Integer> {
    Optional<Role> findByName(String name);

}
