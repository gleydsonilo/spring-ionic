package com.nelioalves.cursomc.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NonNull private String area;

    @NonNull private String number;

    @NonNull private String complement;

    @NonNull private String district;

    @NonNull private String cep;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NonNull private Client client;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @NonNull private City city;
}
