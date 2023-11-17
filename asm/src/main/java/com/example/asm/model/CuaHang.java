package com.example.asm.model;

import lombok.*;

import jakarta.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="CuaHang")
public class CuaHang {
    @Id
    @Column(name="Id")
    private String id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="ThanhPho")
    private String thanhPho;

    @Column(name="QuocGia")
    private String quocGia;
}
