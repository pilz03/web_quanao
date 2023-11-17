package com.example.asm.model;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="MauSac")
public class MauSac {
    @Id
    @Column(name="Id")
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
}
