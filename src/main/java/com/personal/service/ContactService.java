package com.personal.service;

import com.personal.models.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findContacts();

    void saveContact(Contact contact);

    Contact findContact(Long id);

    void deleteContact(Long id);

    Contact updateContact(Contact contact);
}
