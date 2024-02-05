package dao;

import databasa.Databasa;
import model.Department;
import model.Doctor;
import dao.GenericDao;
import model.Hospital;

import java.util.Iterator;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao,GenericDao<Department>{
    public DepartmentDaoImpl(Databasa databasa) {
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : Databasa.databasaHospital) {
            if (hospital.getId().equals(id)){
                return hospital.getDepartments();
            }
        }
        System.out.println("Не найден!");
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : Databasa.databasaHospital) {
            for (Department department : hospital.getDepartments()) {
            if (department.getDepartmentName().equalsIgnoreCase(name)){
                return department;
            }

            }
        }
        System.out.println("Не найден!");
  return null;  }


    @Override
    public String add(Long hospitalId, List<Department> t) {
        for (Hospital hospital : Databasa.databasaHospital) {
            if (hospital.getId().equals(hospitalId)){
                hospital.setDepartments(t);
            return "Успешно добавлен!";
           }
        }
        return "Не найден!";
    }

    @Override
    public void removeById(Long id) {
        boolean found = false;
        for (Hospital hospital : Databasa.databasaHospital) {
            Iterator<Department> iterator = hospital.getDepartments().iterator();
            while (iterator.hasNext()) {
                Department department = iterator.next();
                if (department.getId().equals(id)) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            System.out.println("Успешно удален!");
        } else {
            System.out.println("Не найден!");
        }}


    @Override
    public String updateById(Long id, Department department) {
        boolean found = false;

        for (Hospital hospital : Databasa.databasaHospital) {
            Iterator<Department> iterator = hospital.getDepartments().iterator();

            while (iterator.hasNext()) {
                Department department1 = iterator.next();

                if (department1.getId().equals(id)) {
                    department1.setDepartmentName(department.getDepartmentName());
                    found = true;
                    break;  // Выход из цикла, так как отдел уже найден и обновлен
                }
            }
        }

        if (found) {
            return "Успешно обновлен!";
        } else {
            return "Не найден!";
        }}}
