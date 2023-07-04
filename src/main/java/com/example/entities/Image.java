package com.example.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@JsonSerialize
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_name")
    private String name;

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    @Column(name = "image_tag")
    private List<Tag> tags;

    public Image() {
        this.tags = new ArrayList<>();
    }

    public Image(String name, List<Tag> tagsAdded) {
        this.name = name;
        this.tags = new ArrayList<>();
        tagsAdded.stream().forEach(tag -> tags.add(tag));
    }
}
