package com.codehacks.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonSerialize
public final class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer tagId;

    @Column(name = "tag_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

    public void setName(String name) {
        this.name = name;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return tagId.equals(tag.tagId) && name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, name);
    }

    @Override
    public String toString() {
        return "tagId= " + tagId + ", name= " + name;
    }
}
