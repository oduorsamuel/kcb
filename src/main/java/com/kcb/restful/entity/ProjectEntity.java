package com.kcb.restful.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The name must not be null and must contain at least one non-whitespace character")
    @Size(min = 1, max = 255, message = "name must be at most 255 characters, and has at least one character")
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
