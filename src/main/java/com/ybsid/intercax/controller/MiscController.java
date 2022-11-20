package com.ybsid.intercax.controller;

import com.ybsid.intercax.entity.Robots;
import com.ybsid.intercax.repository.RobotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/all")
public class MiscController {

    @Autowired
    private RobotsRepository repository;

    @GetMapping("/getAllAtOnce")
    public List<Robots> getAllRobots(){

        return repository.getAllRobots();

    }

    @GetMapping("/getAllInEachState")
    public Map<String,List<Robots>> getAllInEachState(){
        Map<String,List<Robots>> result = new HashMap<>();

        List<Robots> totalList = repository.getAllRobots();

        result.put("designed", totalList.stream()
                .filter(e -> e.getState().equalsIgnoreCase("designed")
                        ).collect(Collectors.toList()));
        result.put("tested",totalList.stream().filter(e->e.getState().equalsIgnoreCase("tested"))
                        .collect(Collectors.toList()));
        result.put("deployed",totalList.stream().filter(e->e.getState().equalsIgnoreCase("deployed"))
                .collect(Collectors.toList()));

        return result;
    }
}
