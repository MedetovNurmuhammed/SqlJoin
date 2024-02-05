package service.impl;

import dao.PhoneDao;
import databasa.Databasa;
import model.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    private final PhoneDao phoneDao;

    public PhoneServiceImpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public String addPhone(Phone phone) {
      return   phoneDao.addPhone(phone);

    }

    @Override
    public Phone getPhoneById(int phoneId) {
        if (!Databasa.databasaPhone.isEmpty()){
          return   phoneDao.getPhoneById(phoneId);
        }
        System.out.println("Пусто!");
        return null;
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        if (!Databasa.databasaPhone.isEmpty()){
            System.out.println("Успешно изменен!✅");
        return phoneDao.updatePhoneNameById(phoneId,newName);
    }else System.out.println("Пусто!"); return null;}

    @Override
    public List<Phone> getAllPhones() {
        if (!Databasa.databasaPhone.isEmpty()){
        return phoneDao.getAllPhones();
    }else {
            System.out.println("Пусто!");
        return null;}
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        if (!Databasa.databasaPhone.isEmpty()){
        return phoneDao.getAllPhonesByBrand(brand);
    }else System.out.println("Пусто!"); return null;}

    @Override
    public void deletePhoneById(int phoneId) {
        if (!Databasa.databasaPhone.isEmpty()){
        phoneDao.deletePhoneById(phoneId);
            System.out.println("Успешно удален!");

    }else {
            System.out.println("Пусто!");
        }
}}
