package com.restaurant.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
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
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<LineItem> lineItems = new HashSet<>();

    public ShoppingCart addLine(LineItem line) {
        lineItems.add(line);
        line.setShoppingCart(this);
        subTotal += line.getTotalPrice();
        return this;
    }

    public ShoppingCart removeLine(LineItem line) {
        lineItems.remove(line);
        line.setShoppingCart(null);
        return this;
    }
    public ShoppingCart removeAllLines(){
        lineItems.clear();
        setSubTotal(0);
        return this;
    }

}










