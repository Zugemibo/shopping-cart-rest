package com.restaurant.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class ShoppingCart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false, unique = true)
    private Long cartId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private double subTotal;
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LineItem> lineItems = new HashSet<>();


    public void addItem(LineItem lineItem) {
        if (lineItems == null)
            lineItems = new HashSet<>();
        lineItems.add(lineItem);
    }


    public void removeItem(LineItem removeItem) {
        if (lineItems == null)
            lineItems.removeIf(lineItem -> Objects.equals(lineItem.getId(), removeItem.getId()));
    }

    public void updateItem(LineItem lineItem) {
        removeItem(lineItem);
        addItem(lineItem);
    }
}










