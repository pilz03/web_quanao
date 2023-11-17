package com.example.asm.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="HoaDonChiTiet")
@IdClass(HoaDonChiTietID.class)
public class HoaDonChiTiet {
    @Id
    @ManyToOne
    @JoinColumn(name="IdHoaDon")
    private HoaDon IdHoaDon;
    @Id
    @ManyToOne
    @JoinColumn(name="IdChiTietSP")
    private CTSP IdChiTietSP;

    @Column(name="SoLuong")
    private Integer soLuong;
    @Column(name="DonGia")
    private BigDecimal donGia;

}
