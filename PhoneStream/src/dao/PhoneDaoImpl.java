package dao;

import databasa.Databasa;
import model.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneDaoImpl implements PhoneDao{
    public PhoneDaoImpl(Databasa databasa) {

    }

    @Override
    public String addPhone(Phone phone) {
        List<Phone>phoneList = Databasa.databasaPhone;
        phone.setId(idPhone.geneteId());
        List<Phone> updatedPhoneList = Stream.concat(phoneList.stream(), Stream.of(phone))
                .collect(Collectors.toList());
                    Databasa.databasaPhone = updatedPhoneList;
        System.out.println(updatedPhoneList);
        return "Телефон успешно добавлен";
    }


    @Override
    public Phone getPhoneById(int phoneId) {
        List<Phone>phoneList  = Databasa.databasaPhone;
     Optional <Phone> res = phoneList.stream().filter(phoneq->phoneq.getId()==phoneId).findFirst();
     if (res.isPresent()){
        return res.orElse(null);}
     else{
         System.out.println("Не найден!");return null;
    }}

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        List<Phone> phoneList = Databasa.databasaPhone;

        phoneList = phoneList.stream()
                .map(phone -> {
                    if (phone.getId() == phoneId) {
                        phone.setName(newName);
                    }
                    return phone;
                })
                .collect(Collectors.toList());

        Phone updatedPhone = phoneList.stream()
                .filter(phone -> phone.getId() == phoneId)
                .findFirst()
                .orElse(null);

        if (updatedPhone == null) {
            System.out.println("Телефон не найден!");
        }

        return updatedPhone;
    }


    @Override
    public List<Phone> getAllPhones() {

        return Databasa.databasaPhone.stream().toList();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        List<Phone> phoneList = Databasa.databasaPhone;
        List<Phone> phoneOptional = phoneList.stream().filter(phone -> phone.getBrand().equals(brand)).collect(Collectors.toList());
        if (!phoneOptional.isEmpty()) {
            return  phoneOptional;
        }else {
            System.out.println("Не найден!");
            return phoneOptional;
        }
    }
    @Override
    public void deletePhoneById(int phoneId) {
        List<Phone> phoneList = Databasa.databasaPhone;
        Optional<Phone> phoneToRemove = phoneList.stream()
                .filter(phone -> phone.getId() == phoneId)
                .findFirst();
if (!phoneToRemove.isEmpty()){
        phoneToRemove.ifPresent(phoneList::remove);
        Databasa.databasaPhone = phoneList;

        System.out.println(Databasa.databasaPhone);
    }
else {
    System.out.println("Не найден!");
}
}}
