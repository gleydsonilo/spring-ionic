package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nelioalves.cursomc.domain.enums.ClientType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Getter @Setter private Integer id;

    @Getter @Setter private String name;

    @Getter @Setter private String email;

    @Getter @Setter private String cpfOrCnpj;

    private Integer clientType;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    @Getter @Setter private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "PHONE")
    @Getter @Setter private Set<String> phones = new HashSet<>();

    public Client(Integer id, String name, String email, String cpfOrCnpj, ClientType clientType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.clientType = clientType.getCod();
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType.getCod();
    }

    public ClientType getClientType() {
        return ClientType.toEnum(clientType);


    }
}
