package com.ybsid.intercax.entity;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(schema = "test",name = "robot")
@Data
@TypeDef(name = "list-array",typeClass = ListArrayType.class)
public class Robots {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name ="year_built")
    private LocalDate yearBuilt;

    @Column(name = "mass")
    private int mass;

    @Column(name = "state")
    private String state;

    @Type(type = "list-array")
    @Column(name = "list_of_functions",columnDefinition = "String[]")
    private List<String> listOfFunctions;

}
