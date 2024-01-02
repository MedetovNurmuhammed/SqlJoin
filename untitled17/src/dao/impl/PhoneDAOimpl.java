package dao.impl;

import dao.DaoCRUD;
import databasa.Databasa;
import model.Phone;

import java.util.List;

public class PhoneDAOimpl implements DaoCRUD<Phone,Long> {
    private final Databasa databasa;

    public PhoneDAOimpl(Databasa databasa) {
        this.databasa = databasa;
    }

    @Override
    public boolean add(Phone type) {
        return databasa.add(type);
    }

    @Override
    public boolean delete(Phone type) {
        return databasa.remove(type);
    }

    @Override
    public Phone findbyid(Long id) {
       List<Phone>phonelist =  fibdall();
        for (Phone phone : phonelist) {
            if (phone.getId()==id) return phone;
            
        }throw new NotfoundExeption("Phone with id:"+id+"not found");

    }

    @Override
    public List<Phone> fibdall() {
        return databasa.phoneList();
    }

    @Override
    public String update(Long id,Phone phone) {
        Phone foundPhone;
        try {
             foundPhone = findbyid(id);
             foundPhone.setModel(phone.getModel());
        } catch (NotfoundExeption e) {
            return  e.getMessage();
        }return "Succes update";
    }

    @Override
    public List<Phone> sort() {
        return null;
    }
}
