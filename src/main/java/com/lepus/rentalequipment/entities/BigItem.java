package com.lepus.rentalequipment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class BigItem extends Item {
    @Column(name = "barcode")
    private String barcode;

}
