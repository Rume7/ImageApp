package com.codehacks.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(name = "img_uploaded")
    private byte[] image;

    @OneToMany
    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Media() {
        this.date = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return id.equals(media.id) && type.equals(media.type) && Arrays.equals(image, media.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, type);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
