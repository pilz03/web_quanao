package com.example.asm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Cart {
    private List<CartItem> list;

    @Override
    public String toString() {
        return "Cart{" +
                "list=" + list +
                '}';
    }
}
