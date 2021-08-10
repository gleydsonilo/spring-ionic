package com.nelioalves.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientType {

    PESSOAFISICA(1, "PF"),
    PESSOAJURIDICA(2, "PJ");

    private int cod;
    private String description;

    public static ClientType toEnum(Integer cod){

        if (cod == null){
            return null;
        }

        for (ClientType x : ClientType.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("ID inválid: " + cod);
    }
}
