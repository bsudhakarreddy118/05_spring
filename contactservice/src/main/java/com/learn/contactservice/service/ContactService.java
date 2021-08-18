package com.learn.contactservice.service;

import com.learn.contactservice.exceptions.ContactExistsException;
import com.learn.contactservice.exceptions.ContactNotFoundException;
import com.learn.contactservice.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();
    List<Contact> getContactsByCategory(String category);
    Contact addContact(Contact contact) throws ContactExistsException;
    void deleteContact(String contactId) throws ContactNotFoundException;
    Contact getContactByEmail(String email) throws ContactNotFoundException;
    List<Contact> getContactsForUser(String userEmail);
}
