package com.example.naver_week22.Controller;

import com.example.naver_week22.Model.Computer;
import com.example.naver_week22.Service.ComputerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factory-method")
public class FactoryMethodController {
    @Autowired
    private ComputerFactory computerFactory;

    @GetMapping("/{type}")
    public String getMethod(@PathVariable("type") String type ) {
        Computer computer = computerFactory.getComputer(type);
        System.out.println("Type: " + type);
        System.out.println("Computer: " + computer.getType());
        return computer.getType();
    }
}
