package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderedItem implements Serializable {
    private static final long SerialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    @EqualsAndHashCode.Include
    private OrderedItemPK id = new OrderedItemPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public OrderedItem(Demand demand, Product product, Double discount, Integer quantity, Double price) {
        id.setProduct(product);
        id.setDemand(demand);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Demand getDemand(){
        return id.getDemand();
    }

    public Product getProduct(){
        return id.getProduct();
    }
}
