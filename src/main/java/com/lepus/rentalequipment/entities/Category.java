package com.lepus.rentalequipment.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private Set<Category> children = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    public void addChildren(Category child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChildren(Category child) {
        children.remove(child);
        child.setParent(null);
    }

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Product> products = new LinkedHashSet<>();

    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}