package com.lepus.rentalequipment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class SmallItem extends Item {
    @Column(name = "quantity", nullable = false)
    private int quantity;
}
