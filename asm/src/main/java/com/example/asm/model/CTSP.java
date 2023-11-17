package com.example.asm.model;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="ChiTietSP")
public class CTSP {
    @Id
    @Column(name="Id")
    private  String id;

    @Column(name="NamBH")
    private Integer namBH;

    @Column(name="MoTa")
    private String moTa;

    @Column(name="SoLuongTon")
    private Integer soLuongTon;

    @Column(name="GiaNhap")
    private BigDecimal giaNhap;

    @Column(name="GiaBan")
    private BigDecimal giaBan;

    @Column(name="anh")
    private String anh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP")
    private SanPham idSP;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac")
    private MauSac idMS;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx")
    private NSX idNSX;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP")
    private DongSP idDongSP;

    @Override
    public String toString() {
        return "CTSP{" +
                "id='" + id + '\'' +
                ", namBH=" + namBH +
                ", moTa='" + moTa + '\'' +
                ", soLuongTon=" + soLuongTon +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                ", anh='" + anh + '\'' +
                ", idSP=" + idSP +
                ", idMS=" + idMS +
                ", idNSX=" + idNSX +
                ", idDongSP=" + idDongSP +
                '}';
    }
}
