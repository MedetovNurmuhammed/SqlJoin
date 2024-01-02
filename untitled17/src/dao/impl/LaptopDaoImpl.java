package dao.impl;

import dao.DaoCRUD;
import databasa.Databasa;
import model.Laptop;

import java.util.List;

public class LaptopDaoImpl implements DaoCRUD<Laptop, Long> {
    private final Databasa databasa;

    public LaptopDaoImpl(Databasa databasa) {
        this.databasa = databasa;
    }

    @Override
    public boolean add(Laptop newLaptop) {
        return databasa.add(newLaptop);
    }

    @Override
    public boolean delete(Laptop laptop) {
        return databasa.remove(laptop);
    }

    @Override
    public Laptop findbyid(Long l) {
        List<Laptop> laptops = databasa.laptopList();
        for (Laptop laptop : laptops)  if (laptop.getId() == (l)) return laptop;

            throw new RuntimeException(String.format("Laptop with id:%d not found!", l));


    }

    @Override
    public List<Laptop> fibdall() {
        return databasa.laptopList();
    }

    @Override
    public String update(Long l,Laptop laptop) {
        Laptop foundlaptop;
        try {
             foundlaptop = findbyid(l);
        } catch (RuntimeException e) {
            return e.getMessage();

        }foundlaptop.setModel(laptop.getModel());
        return "Изменен!";

    }

    @Override
    public List<Laptop> sort() {
        return null;
    }
}
