package com.personal.service;

import com.personal.models.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findEveryContact();

    void saveContact(Contact contact);

    Contact findSingleContact(Long id);

    void removeContact(Long id);

    Contact updateContact(Contact contact);
}
