package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @OneToMany
    @JoinColumn(name = "parent_id")
    private List<Category> parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getParent() {
        return parent;
    }

    public void setParent(List<Category> parent) {
        this.parent = parent;
    }
}
