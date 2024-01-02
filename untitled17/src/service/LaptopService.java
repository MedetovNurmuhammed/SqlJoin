package service;

import model.Laptop;

import java.util.List;

public interface LaptopService {
    String add(Laptop newlaptop);
    public List<Laptop>getall();
}
