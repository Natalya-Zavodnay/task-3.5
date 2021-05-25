package ru.netology.domain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String phoneManufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String phoneManufacturer) {
        super(id, name, price);
        this.phoneManufacturer = phoneManufacturer;
    }
}

