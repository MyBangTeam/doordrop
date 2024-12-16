package com.mybang.doordrop.entity;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String mobile;
    @Column(nullable = false)
    private String email;
    @Column
    private String password;
    @Column
    private String dob;
    @Column
    private String gender;
    @Column
    private boolean adult ;
    @Column
    private String type;
    @Column
    private String profile_completion;
    @CreationTimestamp
    private LocalDateTime  created_date;
    @UpdateTimestamp
    private LocalDateTime  updated_date;
}
