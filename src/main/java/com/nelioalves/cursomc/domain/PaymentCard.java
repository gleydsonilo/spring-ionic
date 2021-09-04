package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.StatePayment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class PaymentCard extends Payment {
    private static final long serialVersionUID = 1L;

    private Integer numInstallments;

    public PaymentCard(Integer id, StatePayment state, Demand demand, Integer numInstallments) {
        super(id, state, demand);
        this.numInstallments = numInstallments;
    }
}
