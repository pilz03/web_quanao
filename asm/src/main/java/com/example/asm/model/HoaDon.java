package com.example.asm.model;


import lombok.*;

import jakarta.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="HoaDon")
public class HoaDon {
    @Id
    @Column(name="Id")
    private String id;

    @Column(name="Ma")
    private String ma;

    @Column(name="NgayTao")
    private Date ngayTao;

    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name="NgayShip")
    private Date ngayShip;

    @Column(name="NgayNhan")
    private Date ngayNhan;

    @Column(name="TinhTrang")
    private  Integer tinhTrang;

    @Column(name="TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="Sdt")
    private String sdt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH")
    private KhachHang idKH;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNV")
    private NhanVien idNV;

}
