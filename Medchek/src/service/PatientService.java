package service;

import model.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    String addPatientsToHospital(Long id,List<Patient> patients);
           Patient getPatientById(Long id);
              Map<Integer, List<Patient>> getPatientByAge(int age);
              List<Patient> sortPatientsByAge(List<Patient>patientList,String ascOrDesc);
}
