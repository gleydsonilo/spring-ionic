package com.nelioalves.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatePayment {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String description;

    public static StatePayment toEnum(Integer cod){

        if (cod == null){
            return null;
        }

        for (StatePayment x : StatePayment.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("ID inválid: " + cod);
    }
}
