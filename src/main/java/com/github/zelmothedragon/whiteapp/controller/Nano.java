package com.github.zelmothedragon.whiteapp.controller;

import com.arjuna.ats.jta.common.jtaPropertyManager;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.jboss.logging.Logger;

@WebListener
public class Nano implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(Nano.class);

    @Inject
    private transient EntityManager em;

    public Nano() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        var bundle = ResourceBundle.getBundle("Messages");
        var info = String.format(
                bundle.getString("app.start"),
                bundle.getString("app.title"),
                bundle.getString("app.version"),
                LocalDateTime.now(),
                System.getProperty("java.version"),
                System.getProperty("java.home"),
                System.getProperty("java.vendor"),
                System.getProperty("java.vendor.url"),
                System.getProperty("os.name"),
                System.getProperty("os.arch"),
                System.getProperty("os.version"),
                System.getProperty("user.name"),
                System.getProperty("user.home"),
                System.getProperty("user.dir")
        );

        LOG.info(info);

        // Forcer la génération de la base de données.
        var ping = em
                .createNativeQuery("SELECT 1 = 1;")
                .getSingleResult();
        LOG.debug("Generated database with JPA, ping: " + ping);

        // Configuration du nom JNDI pour JTA (narayana)
        jtaPropertyManager.getJTAEnvironmentBean().setUserTransactionJNDIContext("java:comp/env/UserTransactionManager");
        jtaPropertyManager.getJTAEnvironmentBean().setTransactionManagerJNDIContext("java:comp/env/TransactionManager");
        jtaPropertyManager.getJTAEnvironmentBean().setTransactionSynchronizationRegistryJNDIContext("java:comp/env/TransactionSynchronizationRegistry");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        var bundle = ResourceBundle.getBundle("Messages");
        var info = String.format(
                bundle.getString("app.stop"),
                bundle.getString("app.title"),
                bundle.getString("app.version"),
                LocalDateTime.now()
        );

        LOG.info(info);
    }

}
