package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Demand implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "demand")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    @OneToMany(mappedBy = "id.demand")
    private Set<OrderedItem> itens = new HashSet<>();

    public Demand(Integer id, Date instant, Client client, Address deliveryAddress) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        this.deliveryAddress = deliveryAddress;
    }
}
