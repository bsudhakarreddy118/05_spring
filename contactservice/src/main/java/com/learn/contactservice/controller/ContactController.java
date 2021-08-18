package com.learn.contactservice.controller;

import com.learn.contactservice.exceptions.ContactExistsException;
import com.learn.contactservice.exceptions.ContactNotFoundException;
import com.learn.contactservice.model.Contact;

import com.learn.contactservice.repository.TestRepository;
import com.learn.contactservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactController {

    private ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

//    @Autowired
//    private TestRepository repository;

    @GetMapping("/info")
    public String apiInfoNew() {
        return "Contact API Running";
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        return service.getAllContacts();
    }

    @GetMapping(path = "/contacts", params = "category")
    public List<Contact> getAllContactsByCategory(@RequestParam String category){
        return service.getContactsByCategory(category);
    }

    @GetMapping("/contacts/{email}")
    public Contact getContactByEmail(@PathVariable String email) throws ContactNotFoundException {
        return service.getContactByEmail(email);
    }

//    @GetMapping("/contacts/id/{id}")
//    public Contact getContactById(@PathVariable String id) throws ContactNotFoundException {
//        return repository.getContactById(id);
//    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> addContact(@RequestBody Contact newContact) throws ContactExistsException {
        Contact contact = service.addContact(newContact);
        return  new ResponseEntity<>(contact, HttpStatus.CREATED);
     }

     @DeleteMapping("/contacts/{contactId}")
     public ResponseEntity<?> deleteContact(@PathVariable String contactId) throws ContactNotFoundException {
        service.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }




}
