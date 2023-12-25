package com.example.room_manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity//đánh dấu 1 lớp là 1 thực thể của csdl
@Table(name = "roles")// Đánh dấu một lớp để chỉ định tên bảng trong cơ sở dữ liệu mà thực thể sẽ được ánh xạ vào.
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
