package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private Long id;

    private String accountName;
    private double moneyAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    // Custom getter returns primitive long to allow casts like (int) getId() in tests
    public long getId() {
        return id != null ? id.longValue() : 0L;
    }

    public int getIdAsInt() {
        return id != null ? id.intValue() : 0;
    }

}
