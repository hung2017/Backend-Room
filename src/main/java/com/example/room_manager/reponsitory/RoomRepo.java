package com.example.room_manager.reponsitory;

import com.example.room_manager.model.Role;
import com.example.room_manager.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepo extends JpaRepository<Room,Integer> {
    Optional<Role> findByName(String name);

}
