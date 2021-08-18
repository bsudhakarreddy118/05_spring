package com.learn.restapidemo.service;

import com.learn.restapidemo.exceptions.ContactExistsException;
import com.learn.restapidemo.exceptions.ContactNotFoundException;
import com.learn.restapidemo.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();
    List<Contact> getContactsByCategory(String category);
    Contact addContact(Contact contact) throws ContactExistsException;
    void deleteContact(String contactId) throws ContactNotFoundException;
    Contact getContactByEmail(String email) throws ContactNotFoundException;
}
