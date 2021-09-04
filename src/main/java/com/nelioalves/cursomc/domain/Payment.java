package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelioalves.cursomc.domain.enums.StatePayment;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private Integer id;

    private Integer state;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "demand_id")
    @MapsId
    private Demand demand;

    public Payment(Integer id, StatePayment state, Demand demand) {
        this.id = id;
        this.state = state.getCod();
        this.demand = demand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatePayment getState() {
        return StatePayment.toEnum(state);
    }

    public void setState(StatePayment state) {
        this.state = state.getCod();
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }
}
