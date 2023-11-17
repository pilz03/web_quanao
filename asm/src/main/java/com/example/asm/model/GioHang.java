package com.example.asm.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="GioHang")
public class GioHang {
    @Id
    @Column(name="Id")
    private String id;

    @Column(name="Ma")
    private String ma;

    @Column(name="NgayTao")
    private Date ngayTao;

    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name="TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="Sdt")
    private String sdt;

    @Column(name="TinhTrang")
    private Integer tinhTrang;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="IdKH")
    private KhachHang idKH;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="IdNV")
    private NhanVien idNV;


}
