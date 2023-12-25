package com.example.room_manager.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data//tự động tạo ra các phương thức Getter, Setter
@AllArgsConstructor //  tự động tạo constructor có tham số
@NoArgsConstructor// tạo constructor k tham số
@Builder// tạo ra một Builder pattern cho lớp
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
}
