package service.impl;

import dao.PatientDao;
import databasa.Databasa;
import model.Hospital;
import model.Patient;
import service.GenericService;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {
    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        if (!Databasa.databasaHospital.isEmpty()) {
            patientDao.addPatientsToHospital(id,patients);
            return "Успешно добавлен!";
        }
        return "Hospital пусто!"   ;
    }
    @Override
    public Patient getPatientById(Long id) {
        if (!Databasa.databasaHospital.isEmpty()) {
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getPatients().isEmpty()) {
                    Patient patient = patientDao.getPatientById(id);
                    if (patient != null) {
                        return patient;
                    } else {
                        System.out.println("Пациент с id " + id + " не найден!");
                        break;
                    }
                }
            }

            System.out.println("Пациентов нету в больницах!");
        } else {
            System.out.println("Сначала добавьте Hospital!");
        }
        return null;}

    @Override
    public Map<Integer, List<Patient>> getPatientByAge(int age) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getPatients().isEmpty()){
                    return patientDao.getPatientByAge(age);
                }else {
                    System.out.println("Пациентов нету в больницах!");
                    break;
                }
            }
        }else {
            System.out.println("Сначало добавьте Hospital!");

    }return null;}

    @Override
    public List<Patient> sortPatientsByAge(List<Patient>patientList,String ascOrDesc) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getPatients().isEmpty()){
                    return patientDao.sortPatientsByAge(patientList,ascOrDesc);
                }else {
                    System.out.println("Пациентов нету в больницах!");
                    break;
                }
            }
        }else {
            System.out.println("Сначало добавьте Hospital!");

        }return null;}





    @Override
    public String add(Long hospitalId, List<Patient> t) {
        return null;
    }

    @Override
    public void removeById(Long id) {
        boolean istrue  = false;
        if (!Databasa.databasaHospital.isEmpty()){
            for (int i = 0; i < Databasa.databasaHospital.size(); i++) {
                if (!Databasa.databasaHospital.get(i).getPatients().isEmpty()){
                    patientDao.removeById(id);
                    istrue = false;
                    break;
                }}if (!istrue){
                    System.out.println("Добавьте Patient!");
                }

        }else {
            System.out.println("Добавтье Hospital!");
        }

    }

    @Override
    public String updateById(Long id, Patient patient) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getPatients().isEmpty()){
                return     patientDao.updateById(id,patient);
                }else {return "Добавьте Patient!";}
            }
        }
        return "Добавьте Hospital!";
    }
}
