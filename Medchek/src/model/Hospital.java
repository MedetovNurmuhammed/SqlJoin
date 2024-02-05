package model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
     private Long id;
     private  String hospitalName;
     private String address;
      private List<Department> departments = new ArrayList<>();
       private List<Doctor> doctors= new ArrayList<>();
       private List<Patient> patients = new ArrayList<>();

    public Hospital() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital:" +"\n"+
                "id=" + id +"\n"+
                "hospitalName='" + hospitalName +"\n"+
                "address='" + address + "\n"+
                "departments=" + departments +"\n"+
                "doctors=" + doctors +"\n"+
                "patients=" + patients +"\n"
                ;
    }
}
