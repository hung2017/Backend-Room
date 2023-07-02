package com.example.pokemon_teddy.service;

import com.example.pokemon_teddy.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto createRoom(RoomDto roomDto);
    List<RoomDto> getAllRoom();
    RoomDto getRoomById(int id);
    RoomDto updateRoom(RoomDto productDto, int id);

    void deleteRoom(int id);

}
