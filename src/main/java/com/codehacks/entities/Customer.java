package com.codehacks.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "customer")
public final class Customer implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dateCreated;

    public Customer() {
        this.dateCreated = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
