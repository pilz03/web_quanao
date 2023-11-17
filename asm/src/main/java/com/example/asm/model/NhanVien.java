package com.example.asm.model;

import lombok.*;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter

@Table(name="NhanVien")
public class NhanVien {
    @Id
    @Column(name="Id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // neu id la int tu tang
    //    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    private String id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    @Column(name="TenDem")
    private String tenDem;

    @Column(name="Ho")
    private String ho;

    @Column(name="GioiTinh")
    private String gioiTinh;

    @Column(name="NgaySinh")
    private Date ngaySinh;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="Sdt")
    private String sdt;

    @Column(name="MatKhau")
    private String matKhau;

    @Column(name="TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCV")
    private ChucVu idCV;

    @Override
    public String toString() {
        return "NhanVien{" +
                "id='" + id + '\'' +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", tenDem='" + tenDem + '\'' +
                ", ho='" + ho + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", trangThai=" + trangThai +
                ", idCV=" + idCV +
                '}';
    }
}
