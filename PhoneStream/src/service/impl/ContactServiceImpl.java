package service.impl;

import dao.ContactDAo;
import databasa.Databasa;
import model.Contact;
import service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private final ContactDAo contactDAo;

    public ContactServiceImpl(ContactDAo contactDAo) {
        this.contactDAo = contactDAo;
    }

    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        if (!Databasa.databasaPhone.isEmpty()){
        return contactDAo.addContactToPhone(phoneId,contact);
    }else {return "Пусто!";}}

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        return null;
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        return null;
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        return null;
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {

    }
}
