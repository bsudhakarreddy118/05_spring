package com.learn.restapidemo.service;

import com.learn.restapidemo.exceptions.ContactExistsException;
import com.learn.restapidemo.exceptions.ContactNotFoundException;
import com.learn.restapidemo.model.Contact;
import com.learn.restapidemo.respository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl  implements ContactService{

    private ContactRepository repository;

    @Autowired
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return repository.getAllContacts();
    }

    @Override
    public List<Contact> getContactsByCategory(String category) {
        return repository.getAllContactsByCategory(category);
    }

    @Override
    public Contact addContact(Contact contact) throws ContactExistsException {
        Optional<Contact> optionalContact = repository.addContact(contact);
        return optionalContact.orElseThrow(() -> new ContactExistsException("Contact Already exists"));
   }

    @Override
    public void deleteContact(String contactId) throws ContactNotFoundException {
        repository.deleteContact(contactId);
    }

    @Override
    public Contact getContactByEmail(String email) throws ContactNotFoundException {
        return repository.getContactByEmail(email);
    }
}
