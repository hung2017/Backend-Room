package com.example.room.reponsitory;

import com.example.room.model.Role;
import com.example.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepo extends JpaRepository<Room,Integer> {
    Optional<Role> findByName(String name);

}
