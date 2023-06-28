package com.personal.logger;

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
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("Homepage is reached, and all the data is retrieved from the Database");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
    }

    //Inserting data into the database
    @After(value = "execution(* com.personal.service.ContactService.saveContact(..)) *)")
    public void logRegisterFormReached() {
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("A new contact contact was added: ");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
    }

    //Removing contact from the database
    @After(value = "execution(* com.personal.service.ContactService.removeContact(..)) *)")
    public void logRemoveContact() {
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("A contact was removed from the database");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
    }

    //Updating contact in the database
    @After(value = "execution(* com.personal.service.ContactService.updateContact(..)) *)")
    public void logUpdate() {
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("A contact in the database was updated");
        LOGGER.debug("********************************************************************");
        LOGGER.debug("********************************************************************");
    }
}
