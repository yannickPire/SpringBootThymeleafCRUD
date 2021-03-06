package com.personal.service;

import com.personal.models.Contact;
import com.personal.repos.ContactRepository;
import org.hibernate.jpa.event.spi.jpa.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class ContactService {
    @Autowired
    private ContactRepository repository;
    @PersistenceContext
    private EntityManager em;

    public List<Contact> findEveryContact() {
        return repository.findAll();
    }

    public void saveContact(Contact contact) {
        repository.save(contact);
    }

    public Contact findSingleContact(Long id) {
        return repository.findOne(id);
    }

    public void removeContact(Long id) {
        repository.delete(id);
    }

    public void updateContact(Contact contact) {
        EntityManagerFactory entityManagerFactory = em.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        if (null != entityManager) {
            EntityTransaction updateTransaction = entityManager
                    .getTransaction();
            updateTransaction.begin();
            Query query = entityManager
                    .createQuery("UPDATE Contact contact SET contact.firstName = :firstName, " +
                            "contact.lastName = :lastName, " +
                            "contact.emailAddress = :emailAddress, " +
                            "contact.phoneNumber = :phone "
                            + "WHERE contact.id= :id");
            query.setParameter("id", contact.getId());
            query.setParameter("firstName", contact.getFirstName());
            query.setParameter("lastName", contact.getLastName());
            query.setParameter("emailAddress", contact.getEmailAddress());
            query.setParameter("phone", contact.getPhoneNumber());
            int updateCount = query.executeUpdate();
            if (updateCount > 0) {
                System.out.println("Contact is updated");
            }
            updateTransaction.commit();
        }
    }
}
