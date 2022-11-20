package com.ybsid.intercax.controller;

import com.ybsid.intercax.entity.Robots;
import com.ybsid.intercax.model.RoboModel;
import com.ybsid.intercax.repository.RobotsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController()
@RequestMapping("/tested")
public class TestedController {

    @Autowired
    private RobotsRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestedController.class);
    private static final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @GetMapping("/getAll")
    public List<Robots> getAllDesigned(){
        LOGGER.info("returning all designed Robots");
        return repository.getTested();

    }

    @GetMapping("/getCount")
    public int getAllDesignedCount(){
        LOGGER.info("returning all tested count");
        return repository.getTestedCount();
    }

    @PostMapping("/create")
    public Robots createNewRobot(@RequestBody RoboModel robot){
        Robots bot = new Robots();
        bot.setMass(robot.getMass());
        bot.setName(robot.getName());
        bot.setYearBuilt(LocalDate.parse(robot.getYearBuilt(),pattern));
        bot.setListOfFunctions(robot.getListOfFunctions());
        bot.setState(bot.getState());
        bot = repository.save(bot);
        LOGGER.info("Returning newly created tested bot");
        return bot;
    }

    @PutMapping("/edit/{id}")
    public Robots editRobot(@RequestBody RoboModel bot , @PathVariable("id") int id){
        // if id exists then update else insert
        return repository.findById(id)
                .map(robots -> {
                    robots.setListOfFunctions(bot.getListOfFunctions());
                    robots.setState(bot.getState());
                    robots.setName(bot.getName());
                    robots.setListOfFunctions(bot.getListOfFunctions());
                    robots.setMass(bot.getMass());
                    robots.setYearBuilt(LocalDate.parse(bot.getYearBuilt(),pattern));
                    return repository.save(robots);
                })
                .orElseGet(()->{
                    Robots robots = new Robots();
                    robots.setListOfFunctions(bot.getListOfFunctions());
                    robots.setState(bot.getState());
                    robots.setName(bot.getName());
                    robots.setListOfFunctions(bot.getListOfFunctions());
                    robots.setMass(bot.getMass());
                    robots.setYearBuilt(LocalDate.parse(bot.getYearBuilt(),pattern));
                    return repository.save(robots);
                });

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> markAsDelete(@PathVariable("id") int id){
        repository.markDeletedDesigned(id);
        return new ResponseEntity<>(id , HttpStatus.OK);
    }
}
