package com.example.asm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HoaDonChiTietID implements Serializable {
    private String IdHoaDon;

    private String IdChiTietSP;
}
