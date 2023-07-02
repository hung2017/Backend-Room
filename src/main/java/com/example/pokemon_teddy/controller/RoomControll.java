package com.example.pokemon_teddy.controller;

import com.example.pokemon_teddy.dto.RoomDto;
import com.example.pokemon_teddy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RoomControll {
    RoomService roomService;
    @Autowired
    public RoomControll(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto){
        return new ResponseEntity<>(roomService.createRoom(roomDto), HttpStatus.CREATED);
    }

    @GetMapping("/room")
    public ResponseEntity<List<RoomDto>> getAllRoom(){
        return ResponseEntity.ok(roomService.getAllRoom());
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<RoomDto> getRoomDetail(@PathVariable("id") int id){
        return new ResponseEntity<>(roomService.getRoomById(id), HttpStatus.OK);
    }

    @PutMapping("room/{id}/update")
    public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto roomDto, @PathVariable("id") int id){
        return new ResponseEntity<>(roomService.updateRoom(roomDto, id), HttpStatus.OK);
    }

    @DeleteMapping("room/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        roomService.deleteRoom(id);
        return ResponseEntity.ok("Xoá Room thành công! ");
    }
}
