package com.learn.restapidemo.controller;

import com.learn.restapidemo.exceptions.ContactExistsException;
import com.learn.restapidemo.exceptions.ContactNotFoundException;
import com.learn.restapidemo.model.Contact;
import com.learn.restapidemo.respository.ContactRepository;
import com.learn.restapidemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    private ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @Autowired


    //    @RequestMapping(path = "/api/info", method = RequestMethod.GET)
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
    public Contact getContactById(@PathVariable String email) throws ContactNotFoundException{
        return service.getContactByEmail(email);
    }

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
