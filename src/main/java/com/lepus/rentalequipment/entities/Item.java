package com.lepus.rentalequipment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "title_id")
    private Text title;

     @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "description_id")
    private Text description;

 }