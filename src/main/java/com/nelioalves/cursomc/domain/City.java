package com.nelioalves.cursomc.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class City implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

}
