package com.klxsolutions.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String  title;
    private String  description;
    private String  price;
    private String  address;
    @ManyToOne//(fetch = FetchType.LAZY) //It will not fetch the user data while fetching property, by default it is set to EAGER
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity  userEntity;
}
