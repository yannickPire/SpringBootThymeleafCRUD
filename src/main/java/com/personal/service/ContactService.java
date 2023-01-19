package com.personal.service;

import com.personal.models.Contact;
import com.personal.repos.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactService {

    private ContactRepository repository;

    public List<Contact> findEveryContact() {
        return repository.findAll();
    }

    public void saveContact(Contact contact) {
        repository.save(contact);
    }

    public Contact findSingleContact(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void removeContact(Long id) {
        Optional<Contact> contact = repository.findById(id);
        contact.ifPresent(value -> repository.delete(value));
    }

    public Contact updateContact(Contact contact) {
        return repository.save(contact);
    }
}
