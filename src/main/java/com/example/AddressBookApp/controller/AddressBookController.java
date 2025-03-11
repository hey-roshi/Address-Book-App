package com.example.AddressBookApp.controller;

import com.example.AddressBookApp.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    private List<Contact> contactList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        contactList.add(contact);
        return ResponseEntity.ok("Contact Added Successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        if (id >= contactList.size()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactList.get(id.intValue()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        if (id >= contactList.size()) {
            return ResponseEntity.notFound().build();
        }
        contactList.set(id.intValue(), contact);
        return ResponseEntity.ok("Contact Updated Successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        if (id >= contactList.size()) {
            return ResponseEntity.notFound().build();
        }
        contactList.remove(id.intValue());
        return ResponseEntity.ok("Contact Deleted Successfully!");
    }
}
