package com.mycompany.propertymanagement1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="property_table")//for set name to our table
public class PropertyEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="property_title",nullable = false)
    private String title;
    private String description;
   
    private Double price;
    private String address;
}
