package dao;

import databasa.Databasa;
import model.Student;

import java.util.List;

public class StudentDaoImpl implements StidentDao{
private  final Databasa databasa;

    public StudentDaoImpl(Databasa databasa) {
        this.databasa = databasa;
    }
    public List<Student> findAll(){
        return  databasa.students;
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
