package dao;

import databasa.Databasa;
import model.Contact;
import model.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDaoImpl implements ContactDAo{
    public ContactDaoImpl(Databasa databasa) {
    }

    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
            List<Phone> phoneList = Databasa.databasaPhone;

            Optional<Phone> optionalPhone = phoneList.stream()
                    .filter(phone -> phone.getId() == phoneId)
                    .findFirst();

            optionalPhone.ifPresent(phone -> {
                List<Contact> excontact = phone.getContactList();

                if (excontact == null) {
                    excontact = new ArrayList<>();
                }

                excontact.add(contact);

                // Обновляем существующий объект Phone в списке
                phone.setContactList(excontact);
                System.out.println("Контакт успешно добавлен к телефону с id " + phoneId);
            });

            return null ;
        }

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
