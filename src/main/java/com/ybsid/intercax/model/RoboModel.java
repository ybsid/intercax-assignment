package com.ybsid.intercax.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoboModel {
    private int id;
    private String name;
    private String yearBuilt;
    private int mass;
    private String state;
    private List<String> listOfFunctions;
}
