package dao;

import databasa.Databasa;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.List;

public class DoctorDaoImpl implements GenericDao<Doctor>, DoctorDao {
    public DoctorDaoImpl(Databasa databasa) {
    }

    @Override
    public Doctor findDoctorById(Long id) {
        for (int i = 0; i < Databasa.databasaHospital.size(); i++) {
            for (int j = 0; j < Databasa.databasaHospital.size(); j++) {
                if (id.equals(Databasa.databasaHospital.get(i).getDoctors().get(j).getId())){
                    return Databasa.databasaHospital.get(i).getDoctors().get(j);
                }
        }}
        System.out.println("Не найден!");
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : Databasa.databasaHospital) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(departmentId)) {
                    for (Long doctorId : doctorsId) {
                        for (Doctor doctor : hospital.getDoctors()) {
                            if (doctor.getId().equals(doctorId)) {
                                if (!department.getDoctors().contains(doctor)) {
                                    department.getDoctors().add(doctor);
                                }
                            }
                        }
                    }
                    return "Успешно добавлен!";
                }
            }
        }
        return "Не найден!";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (int i = 0; i < Databasa.databasaHospital.size(); i++) {
                if (Databasa.databasaHospital.get(i).getId().equals(id)){
                    return Databasa.databasaHospital.get(i).getDoctors();
            }
        }

        System.out.println("Не найден!");
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital hospital : Databasa.databasaHospital) {
            for (Department department : hospital.getDepartments()) {
            if (department.getId().equals(id)){
                return department.getDoctors();
                }
            }
            }
        System.out.println("Не найден!");
        return null;
    }


    @Override
    public String add(Long hospitalId, List<Doctor> t) {
        for (Hospital hospital : Databasa.databasaHospital) {
            if (hospitalId.equals(hospital.getId())){
                hospital.setDoctors(t);
                return "Усапешно добавлен!";
            }
        }

    return "Не найден!";}

    @Override
    public void removeById(Long id) {
        boolean found = false;
        for (Hospital hospital : Databasa.databasaHospital) {
            for (int i = 0; i < hospital.getDoctors().size(); i++) {
                if (hospital.getDoctors().get(i).getId().equals(id)){
                    hospital.getDoctors().remove(i);
                    System.out.println("Успешно удален!");
                    found = true;
                }}}if (!found)
                    System.out.println("Не найден!");
                }



    @Override
    public String updateById(Long id, Doctor doctor) {
        boolean tr  =false;
        for (Hospital hospital : Databasa.databasaHospital) {
            for (Doctor hospitalDoctor : hospital.getDoctors()) {
                if (hospitalDoctor.getId().equals(id)){
                    hospitalDoctor.setFirstName(doctor.getFirstName());
                    tr = true;
                    return "Успешно изменен!";}}}

                    return "Не найден!";
                }}

