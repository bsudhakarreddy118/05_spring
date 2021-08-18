package com.learn.contactservice.service;


import com.learn.contactservice.exceptions.ContactExistsException;
import com.learn.contactservice.exceptions.ContactNotFoundException;
import com.learn.contactservice.model.Contact;
import com.learn.contactservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl  implements ContactService {

    private ContactRepository repository;

    @Autowired
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public List<Contact> getContactsByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public Contact addContact(Contact contact) throws ContactExistsException {
        Optional<Contact> optionalContact = repository.findByEmail(contact.getEmail());
        if(optionalContact.isEmpty()){
            return repository.save(contact);
        }else{
            throw new ContactExistsException("Contact Already exists");
        }
   }

    @Override
    public void deleteContact(String contactId) throws ContactNotFoundException {
        if(repository.existsById(contactId)){
            repository.deleteById(contactId);
        }else{
            throw new ContactNotFoundException("Contact Does not Exist");
        }
    }

    @Override
    public Contact getContactByEmail(String email) throws ContactNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(()-> new ContactNotFoundException("Contact Not found"));
    }

    @Override
    public List<Contact> getContactsForUser(String userEmail) {
        return repository.findByUserEmail(userEmail);
    }
}
