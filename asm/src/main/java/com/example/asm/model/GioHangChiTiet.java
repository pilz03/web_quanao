package com.example.asm.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="GioHangChiTiet")
@IdClass(GioHangChiTietID.class)
public class GioHangChiTiet {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang")
    private GioHang IdGioHang;
    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private CTSP IdChiTietSP;

    @Column(name="SoLuong")
    private Integer soLuong;

    @Column(name="DonGia")
    private BigDecimal donGia;

    @Column(name="DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

}
