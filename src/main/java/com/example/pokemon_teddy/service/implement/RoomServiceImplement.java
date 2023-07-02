package com.example.pokemon_teddy.service.implement;

import com.example.pokemon_teddy.dto.RoomDto;
import com.example.pokemon_teddy.exception.RoomNotFoundExcep;
import com.example.pokemon_teddy.model.Room;
import com.example.pokemon_teddy.reponsitory.RoomRepo;
import com.example.pokemon_teddy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImplement implements RoomService {
    RoomRepo roomRepo;
    @Autowired
    public RoomServiceImplement(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setPrice(roomDto.getPrice());

        Room newRoom  = roomRepo.save(room);

        RoomDto roomResponse = new RoomDto();
        roomResponse.setId(newRoom.getId());
        roomResponse.setName(newRoom.getName());
        roomResponse.setPrice(newRoom.getPrice());

        return roomResponse;
    }

    @Override
    public List<RoomDto> getAllRoom() {
        List<Room> products = roomRepo.findAll();
        return products.stream().map(r -> mapToDto(r)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(int id) {
        Room products = roomRepo.findById(id).orElseThrow(() ->new RoomNotFoundExcep("Khong the tim thay phong!"));
        return mapToDto(products);
    }

    @Override
    public RoomDto updateRoom(RoomDto roomDto, int id) {
        Room room = roomRepo.findById(id).orElseThrow(() ->new RoomNotFoundExcep("Khong the cap nhat phong!"));

        room.setName(roomDto.getName());
        room.setPrice(roomDto.getPrice());

        Room updateRoom = roomRepo.save(room);

        return mapToDto(updateRoom);
    }

    @Override
    public void deleteRoom(int id) {
        Room product = roomRepo.findById(id).orElseThrow(() ->new RoomNotFoundExcep("Khong th xoa phong!"));
        roomRepo.delete(product);
    }

    private RoomDto mapToDto(Room room){
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setName(room.getName());
        roomDto.setPrice(room.getPrice());

        return roomDto;
    }

    private Room mapToEntity(RoomDto roomDto){
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setPrice(roomDto.getPrice());
        return room;
    }
}