package service.impl;

import dao.DepartmentDao;
import dao.GenericDao;
import databasa.Databasa;
import model.Department;
import model.Hospital;
import service.DepartmentService;
import service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService,GenericService<Department> {
    private final DepartmentDao departmentDao;
    private   GenericDao genericDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;


    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getDepartments().isEmpty()){
                  return   departmentDao.getAllDepartmentByHospital(id);
                }else {
                    System.out.println("Добавьте Department!");
                }
            }
        }
      else   System.out.println("Сначала добавьте Hospital");
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        if (!Databasa.databasaHospital.isEmpty()){
            for (Hospital hospital : Databasa.databasaHospital) {
              if (!hospital.getDepartments().isEmpty()){
                 return departmentDao.findDepartmentByName(name);
              }else {
                  System.out.println("Department пусто!");
              }
            }
        }
       else System.out.println("Сначала добавьте Hospital;");
        return null;
    }

    @Override
    public String add(Long hospitalId, List<Department> t) {
        if (!Databasa.databasaHospital.isEmpty()){
departmentDao.add(hospitalId,t);
return "Успешно добавлен!";
    }return "Пусто!";}

    @Override
    public void removeById(Long id) {
        boolean found  = false;
        if (!Databasa.databasaHospital.isEmpty()) {
            for (Hospital hospital : Databasa.databasaHospital) {
                if (!hospital.getDepartments().isEmpty()) {
                    departmentDao.removeById(id);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Department нету");

        }else {
        System.out.println("Сначала добавтьте Hospital!");}}

    @Override
    public String updateById(Long id, Department department) {
        boolean found = false;

        if (!Databasa.databasaHospital.isEmpty()) {
            for (Hospital hospital : Databasa.databasaHospital) {
                for (Department department1 : hospital.getDepartments()) {
                    if (department1.getId().equals(id)) {
                        departmentDao.updateById(id, department);
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                return "Успешно обновлен!";
            } else {
                return "Department не найден!";
            }
        } else {
            return "Сначала добавьте Hospital!";
        }}}

