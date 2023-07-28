package com.personal.service;

import com.personal.models.Contact;
import com.personal.repos.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Override
    public List<Contact> findContacts() {
        return repository.findAll();
    }

    @Override
    public void saveContact(Contact contact) {
        repository.save(contact);
    }

    @Override
    public Contact findContact(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteContact(Long id) {
        Optional<Contact> contact = repository.findById(id);
        contact.ifPresent(repository::delete);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return repository.save(contact);
    }
}
