package com.example.midTest;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "players")
public class Player {
    @Id
    @SequenceGenerator(
            name = "player",
            sequenceName = "player_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "team")
    private String team;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;
}
