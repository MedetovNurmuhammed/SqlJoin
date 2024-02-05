package service;

import dao.StidentDao;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements StudwntService{
    private final StidentDao stidentDao;

    public StudentServiceImpl(StidentDao stidentDao) {
        this.stidentDao = stidentDao;
    }


    public List<Student>findAll(){
        return  stidentDao.findAll();
    }
    public void update(long id,Student student){
        Student st = null;
        for (Student student1 : findAll()) {
         if (student1.getId()==id){
             st = student1;
         }
        }
        if (st!=null){
        st.setName(student.getName());
    }}
}
