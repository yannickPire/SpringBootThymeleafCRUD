package com.personal.com.personal.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Yannick.pire on 02/05/2017.
 */
@Configuration
@ComponentScan(value = "com.personal")
@Aspect
@EnableAspectJAutoProxy
public class CRUDLogging {

    private static final Logger LOGGER = LoggerFactory.getLogger(CRUDLogging.class);

    //Retrieving data from the database
    @After(value = "execution(* com.personal.service.ContactService.findEveryContact(..)) *)")
    public void logHomePage() {

        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");
        LOGGER.info("Homepage is reached, and all the data is retrieved from the Database");
        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");


    }

    //Inserting data into the database
    @After(value = "execution(* com.personal.service.ContactService.saveContact(..)) *)")
    public void logRegisterFormReached() {
        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");
        LOGGER.info("A new contact contact was added: ");
        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");
    }

    //Removing contact from the database
    @After(value = "execution(* com.personal.service.ContactService.removeContact(..)) *)")
    public void logRemoveContact() {
        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");
        LOGGER.info("A contact was removed from the database");
        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");
    }

    //Updating contact in the database
    @After(value = "execution(* com.personal.service.ContactService.updateContact(..)) *)")
    public void logUpdate() {
        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");
        LOGGER.info("A contact in the database was updated");
        LOGGER.info("********************************************************************");
        LOGGER.info("********************************************************************");
    }
}
