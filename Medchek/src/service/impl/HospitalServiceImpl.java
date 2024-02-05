package service.impl;

import dao.HospitalDao;
import databasa.Databasa;
import model.Hospital;
import model.Patient;
import service.GenericService;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService, GenericService<Hospital> {
    private final HospitalDao hospitalDao;

    public HospitalServiceImpl(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        if (!hospital.getHospitalName().isEmpty()&&!hospital.getAddress().isEmpty()){
        hospitalDao.addHospital(hospital);
        return "Успешно добавлен✅!";
    }else {
            return "Поля не должны быть пустыми!";
        }}

    @Override
    public Hospital findHospitalById(Long id) {
        if (!Databasa.databasaHospital.isEmpty()){
       return hospitalDao.findHospitalById(id);
    }
        System.err.println("Пусто!");
        return null;}

    @Override
    public List<Hospital> getAllHospital() {
        if (!Databasa.databasaHospital.isEmpty()){
            return hospitalDao.getAllHospital();
        }
        System.out.println("Пусто!");
        return null;

    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        if (!Databasa.databasaHospital.isEmpty()){
         return    hospitalDao.getAllPatientFromHospital(id);
            }
        System.out.println("Добавьте Hospital!");
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        if (!Databasa.databasaHospital.isEmpty()){
        return hospitalDao.deleteHospitalById(id);
    }
        System.out.println("Пусто!");
        return null;}

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
       if (!Databasa.databasaHospital.isEmpty()){
        return hospitalDao.getAllHospitalByAddress(address);
    }
        System.out.println("Пусто!");
       return null;
}

    @Override
    public String add(Long hospitalId, List<Hospital> t) {
        return null;
    }

    @Override
    public void removeById(Long id) {
if (!Databasa.databasaHospital.isEmpty()){
    hospitalDao.removeById(id);
}else {
    System.out.println("Пусто!");
}
    }

    @Override
    public String updateById(Long id, Hospital hospital) {
        if (!Databasa.databasaHospital.isEmpty()){
          return   hospitalDao.updateById(id,hospital);
        }
        System.out.println("Добавьте Hospital!");
        return null;
    }
}
