package dao;

import databasa.Databasa;
import model.Hospital;
import model.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements GenericDao<Hospital>,HospitalDao{
    public HospitalDaoImpl(Databasa databasa) {
    }

    @Override
    public String addHospital(Hospital hospital) {
        List<Hospital>hospitalList = Databasa.databasaHospital;
        hospital.setId(Idcounter.geneteId());
        hospitalList.add(hospital);
        System.out.println(Databasa.databasaHospital);
        return "Успешно добавлен!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        List<Hospital>hospitalList = Databasa.databasaHospital;
        for (int i = 0; i < hospitalList.size(); i++) {
            if (id==hospitalList.get(i).getId()){
        return hospitalList.get(i);}}

                System.out.println("Hospital с таким id не существует!!");
    return null;}

    @Override
    public List<Hospital> getAllHospital() {

        return Databasa.databasaHospital;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital hospital : Databasa.databasaHospital) {
            if(hospital.getId().equals(id)){
                return hospital.getPatients();

            }
        }
        System.out.println("Не найден!");
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital>hospitalList = Databasa.databasaHospital;
        for (int i = 0; i < hospitalList.size(); i++) {
            if (hospitalList.get(i).getId()==id){
              hospitalList.remove(hospitalList.get(i));
              return "Успещно удален!";
            }
        }
       return  "Hospital с таким id не существует!";

    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        List<Hospital> hospitalList = Databasa.databasaHospital;
        Map<String, Hospital> hospitalMap = new HashMap<>();
        for (Hospital hospital : hospitalList) {
            // Проверяем, что адрес больницы не является null
            if (hospital.getAddress() != null) {
                // Если адрес больницы содержит введенную строку, добавляем его в Map
                if (hospital.getAddress().contains(address)) {
                    hospitalMap.put(hospital.getHospitalName(), hospital);
                }
            }
        }

        return hospitalMap;
    }

    @Override
    public String add(Long hospitalId, List<Hospital> t) {
        return null;
    }

    @Override
    public void removeById(Long id) {
        boolean istrue = false;
        for (int i = 0; i < Databasa.databasaHospital.size(); i++) {
            if (id.equals(Databasa.databasaHospital.get(i).getId())){
                Databasa.databasaHospital.remove(i);
                System.out.println("Успешно удален!");
                istrue = true;
            }
        }if (!istrue){
            System.out.println("НЕ найден!");
        }

    }

    @Override
    public String updateById(Long id, Hospital hospital) {
        for (Hospital hospital1 : Databasa.databasaHospital) {
            if (hospital1.getId().equals(id)){
                hospital1.setHospitalName(hospital.getHospitalName());
                return "Успешно изменен!";
            }
        }
        System.out.println("Не найден!");
        return null;
    }
}



