package com.nelioalves.cursomc.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @EqualsAndHashCode.Exclude
    private String name;
}
