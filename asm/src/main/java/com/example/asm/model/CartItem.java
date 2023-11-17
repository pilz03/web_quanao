package com.example.asm.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartItem {
    private String idSp;

    private BigDecimal giaBan;

    private String tenSp;

    private Integer soLuong;

    private String anh;

    @Override
    public String toString() {
        return "CartItem{" +
                "idSp='" + idSp + '\'' +
                ", giaBan=" + giaBan +
                ", tenSp='" + tenSp + '\'' +
                ", soLuong=" + soLuong +
                ", anh='" + anh + '\'' +
                '}';
    }
}
