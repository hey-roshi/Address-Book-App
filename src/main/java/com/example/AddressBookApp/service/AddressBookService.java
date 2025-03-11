package com.example.AddressBookApp.service;
import com.example.AddressBookApp.dto.ContactDTO;
import com.example.AddressBookApp.model.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<Contact> contactList = new ArrayList<>();
    private final ModelMapper modelMapper;

    public AddressBookService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contactList.add(contact);
        return contact;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactList;
    }

    @Override
    public Contact getContactById(Long id) {
        if (id >= contactList.size()) {
            return null;
        }
        return contactList.get(id.intValue());
    }

    @Override
    public Contact updateContact(Long id, ContactDTO contactDTO) {
        if (id >= contactList.size()) {
            return null;
        }
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contactList.set(id.intValue(), contact);
        return contact;
    }

    @Override
    public String deleteContact(Long id) {
        if (id >= contactList.size()) {
            return "Contact Not Found";
        }
        contactList.remove(id.intValue());
        return "Contact Deleted Successfully!";
    }
}
