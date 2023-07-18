package com.epico_software.appepico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="epico_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true, length = 45)
    private String categoryName;

    @Size(message = "Max 255", max = 255)
    @Column(name = "category_description", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String categoryDescription;

    @URL
    @Column(name = "category_pic", nullable = false)
    @Size(message = "Max 45", max = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String categoryPic;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="item_id", referencedColumnName = "id")
    private List<Item> items;

}
