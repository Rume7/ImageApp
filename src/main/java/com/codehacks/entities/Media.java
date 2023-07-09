package com.codehacks.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(name = "img_uploaded")
    private byte[] image;

    @Column
    @OneToMany(mappedBy = "media_id", cascade = CascadeType.ALL)
    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
