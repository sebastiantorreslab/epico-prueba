package com.epico_software.appepico.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="epico_items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Size(message = "Max 255", max = 255)
    @Column(name = "name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "sku_code", nullable = false,unique = true ,length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String sku;

    @Positive(message = "Only positive numbers")
    @JdbcTypeCode(SqlTypes.DECIMAL)
    @Digits(integer = 15, fraction = 2)
    private BigDecimal costPrice;

    @Positive(message = "Only positive numbers")
    @JdbcTypeCode(SqlTypes.DECIMAL)
    @Digits(integer = 15, fraction = 2)
    private BigDecimal unitPrice;

    @Size(message = "Max 255", max = 255)
    @Column(name = "pic_filename", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String picFilename;


    @Column(name = "item_available", nullable = false)
    @JdbcTypeCode(SqlTypes.TINYINT)
    private Boolean available;

}
