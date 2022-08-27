package com.example.naver_week22.Service;

import com.example.naver_week22.Model.Computer;
import com.example.naver_week22.Model.ModelImpl.PC;
import com.example.naver_week22.Model.ModelImpl.Server;
import org.springframework.stereotype.Component;

@Component
public class ComputerFactory {
    public Computer getComputer(String type) {
        if (type.equals("pc"))
            return new PC();
        else if (type.equals("server"))
            return new Server();
        else throw new RuntimeException("Sai dữ liệu");
    }
}
