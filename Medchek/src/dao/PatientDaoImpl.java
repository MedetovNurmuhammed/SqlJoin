package dao;

import databasa.Databasa;
import model.Hospital;
import model.Patient;

import java.util.*;

public class PatientDaoImpl implements PatientDao,GenericDao<Patient>{
    public PatientDaoImpl(Databasa databasa) {
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
            List<Hospital> hospitalList = Databasa.databasaHospital;

            for (Hospital hospital : hospitalList) {
                if (hospital.getId().equals(id)) {
                    List<Patient> existingPatients = hospital.getPatients();
                    if (existingPatients == null) {
                        existingPatients = new ArrayList<>();
                        hospital.setPatients(existingPatients);
                    }

                    existingPatients.addAll(patients);
                    return "Успешно добавлено✅!";
                }
            }

            return "Не найден!✅";
        }
    @Override
    public Patient getPatientById(Long id) {
        List<Hospital>hospitalList = Databasa.databasaHospital;
        for (int i = 0; i < hospitalList.size(); i++) {
        for (int j = 0; j < hospitalList.size(); j++) {
            if (hospitalList.get(i).getPatients().get(j).getId().equals(id)){
                return(Patient) hospitalList.get(i).getPatients().get(j);
            }
        }

    }System.out.println("Не найдено!");
        return null;}

    @Override
    public Map<Integer, List<Patient>> getPatientByAge(int age) {
            List<Hospital> hospitalList = Databasa.databasaHospital;
            Map<Integer, List<Patient>> map = new HashMap<>();

            for (Hospital hospital : hospitalList) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getAge() == age) {
                        map.computeIfAbsent(age, k -> new ArrayList<>()).add(patient);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("Не найден!");
            }

            return map;
        }






    @Override
    public List<Patient> sortPatientsByAge(List<Patient> patientList,String ascOrDesc) {

Comparator<Patient>comparator;
if (ascOrDesc.equalsIgnoreCase("ask")){
    comparator = Comparator.comparing(Patient::getAge);
}else if (ascOrDesc.equalsIgnoreCase("desk")){
    comparator = Comparator.comparing(Patient::getAge).reversed();
}else {
    System.out.println("Вы что то ввели не так!");
        return null;
    }Collections.sort(patientList,comparator);
    return patientList;}



    @Override
    public String add(Long hospitalId, List<Patient> t) {
        return null;
    }

    @Override
    public void removeById(Long id) {
        boolean isTrue = false;

        for (Hospital hospital : Databasa.databasaHospital) {
            Iterator<Patient> iterator = hospital.getPatients().iterator();

            while (iterator.hasNext()) {
                Patient patient = iterator.next();

                if (patient.getId().equals(id)) {
                    iterator.remove();
                    System.out.println("Успешно удален!");
                    isTrue = true;
                    break;
                }
            }
        }

        if (!isTrue) {
            System.out.println("Не найден!");
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
         boolean istrue = false;
        for (Hospital hospital : Databasa.databasaHospital) {
            Iterator<Patient>iterator = hospital.getPatients().iterator();
            while (iterator.hasNext()){
                Patient patient1 = iterator.next();
                if (patient1.getId().equals(id)){
                    patient1.setFirstName(patient.getFirstName());
                    return "Успешно изменен!";


                }}}
                return "Не найден!";

    }
}
