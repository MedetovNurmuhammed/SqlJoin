package service.impl;

import dao.DoctorDao;
import databasa.Databasa;
import model.Doctor;
import model.Hospital;
import service.DoctorService;
import service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    private  final DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getDoctors().isEmpty()){
                 return    doctorDao.findDoctorById(id);
            }else {
                    System.out.println("Сначало добавьте Доктора!");
                }
            }
        }
    else     System.out.println("Добавьте Hospital!");
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getDepartments().isEmpty()) {
                    if (!hospital.getDoctors().isEmpty()) {
                        return doctorDao.assignDoctorToDepartment(departmentId, doctorsId);
                    } else {
                        return "Добавьте доктора!";
                    }
                } else {return "Добавьте Департамент!";}
            }
        }
        return "Добавьте Hospital!";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
            return     hospital.getDoctors();
            }
        }
        System.out.println("Добавьте Hospital!");
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        if (!Databasa.databasaHospital.isEmpty()) {
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getDepartments().isEmpty()) {
                    return doctorDao.getAllDoctorsByDepartmentId(id);
                } else {
                    System.out.println("Добавьте Department! ");
                }
            }
        }
      else   System.out.println("Добавьте Hospital!");

        return null;
    }

    @Override
    public String add(Long hospitalId, List<Doctor> t) {
        if (!Databasa.databasaHospital.isEmpty()){
           return doctorDao.add(hospitalId,t);
            }

       return "Добавьте Hospital!";
    }

    @Override
    public void removeById(Long id) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getDoctors().isEmpty()){
                    doctorDao.removeById(id);
                }else {
                    System.out.println("Добавьте Доктора");
                }

            }
        }else {
            System.out.println("Добавьте Hospital!");
        }

    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getDoctors().isEmpty()){
                  return   doctorDao.updateById(id,doctor);
                }else {return "Добавьте доктора!";}
            }
        }
       return "Добавьте Hospital!";
    }
}
