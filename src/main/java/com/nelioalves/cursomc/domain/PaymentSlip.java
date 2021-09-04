package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.StatePayment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class PaymentSlip extends Payment{
    private static final long serialVersionUID = 1L;

    private Date maturityDate;
    private Date paymentDate;

    public PaymentSlip(Integer id, StatePayment state, Demand demand, Date maturityDate, Date paymentDate) {
        super(id, state, demand);
        this.maturityDate = maturityDate;
        this.paymentDate = paymentDate;
    }
}

