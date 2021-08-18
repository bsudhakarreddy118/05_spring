package com.learn.restapidemo.respository;


import com.learn.restapidemo.exceptions.ContactExistsException;
import com.learn.restapidemo.exceptions.ContactNotFoundException;
import com.learn.restapidemo.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ContactRepository {

    private Map<String, Contact> contactsRepo = new HashMap<>();  //in mem DB

    public ContactRepository() {
        contactsRepo.put("101", new Contact("101", "John", "email@test.com", "9999111", "friends"));
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactsRepo.values());
    }

    public List<Contact> getAllContactsByCategory(String category) {
        return contactsRepo.values().stream()
                .filter(contact -> contact.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    public Optional<Contact> addContact(Contact newContact)  {
        boolean contactExists = contactsRepo.values().stream()
                .anyMatch(contact -> contact.getEmail().equalsIgnoreCase(newContact.getEmail()));

        if (contactExists) {
            return Optional.empty();
        }

        String contactId = UUID.randomUUID().toString();
        newContact.setContactId(contactId);
        contactsRepo.put(newContact.getContactId(), newContact);
        return Optional.of(contactsRepo.get(contactId));
    }


    public void deleteContact(String contactId) throws ContactNotFoundException {
        Contact contact = contactsRepo.get(contactId);
        if (contact == null) {
            throw new ContactNotFoundException("Contact with given ID does not exist");
        }
        contactsRepo.remove(contactId);
    }

    public Contact getContactByEmail(String email) throws ContactNotFoundException {
        Optional<Contact> optionalContact = contactsRepo.values().stream()
                .filter(contact -> contact.getEmail().equalsIgnoreCase(email)).findFirst();
        return optionalContact.orElseThrow(() -> new ContactNotFoundException("Contact with given email does not exist"));
    }
}
