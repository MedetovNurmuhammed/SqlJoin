package service.iml;

import dao.impl.LaptopDaoImpl;
import model.Laptop;
import service.LaptopService;

import java.util.List;

public class LaptopserviceImpl implements LaptopService {
private final LaptopDaoImpl laptopDao;
    public LaptopserviceImpl(LaptopDaoImpl laptopDao) {
        this.laptopDao=laptopDao;
    }

    @Override
    public String add(Laptop newlaptop) {
        if (newlaptop.getModel().isBlank())throw  new NullPointerException("Модел исбланк");
           boolean a = laptopDao.add(newlaptop);
        return a ? "Сохранен":"НОт сохр" ;
    }

    @Override
    public List<Laptop> getall() {
        return laptopDao.fibdall();
    }
}

