package com.alex788.pets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_id_gen")
    @SequenceGenerator(name = "card_id_gen", sequenceName = "card_id_seq", allocationSize = 1)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_group_id", nullable = false)
    private CardGroupEntity cardGroup;

    private String title;

    private String description;
}
