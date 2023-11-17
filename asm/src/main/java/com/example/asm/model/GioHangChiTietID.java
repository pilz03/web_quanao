package com.example.asm.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GioHangChiTietID implements Serializable {
    private String  IdGioHang;
    private String IdChiTietSP;
}
