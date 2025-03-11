package com.example.AddressBookApp.service;

import com.example.AddressBookApp.dto.ContactDTO;
import com.example.AddressBookApp.model.Contact;

import java.util.List;

public interface IAddressBookService {

    Contact addContact(ContactDTO contactDTO);

    List<Contact> getAllContacts();

    Contact getContactById(Long id);

    Contact updateContact(Long id, ContactDTO contactDTO);

    String deleteContact(Long id);
}
