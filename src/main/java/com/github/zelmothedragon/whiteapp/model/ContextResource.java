package com.github.zelmothedragon.whiteapp.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gestionnaire de ressource injectable.
 *
 * @author MOSELLE Maxime
 */
@ApplicationScoped
public class ContextResource {

    /**
     * Fabrique de destionnaire d'entité. Dans ce conteneur de <i>Servlet</i>,
     * il n'est pas possible d'injecter directement la classe
     * <code>EntityManager</code> avec l'annotation
     * <code>@PersistenceContext</code>.
     */
    private EntityManagerFactory entityManagerFactory;

    /**
     * Constructeur d'injection.Requis pour le fonctionnement des technologies
     * de Jakarta EE.
     */
    public ContextResource() {
        // Ne pas appeler explicitement
    }

    @PostConstruct
    protected void init() {
        // Voir le fichier 'persistence.xml' pour trouver le nom de l'unité de persistance.
        this.entityManagerFactory = Persistence.createEntityManagerFactory("whiteapp-pu");
    }

    /**
     * Produire une nouvelle instance du gestionnaire d'entité.
     *
     * @return Une nouvelle instance du gestionnaire d'entité
     */
    @Produces
    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /**
     * Libérer les ressources du gestionnaire d'entité.
     *
     * @param em Une instance du gestionnaire d'entité
     */
    public void clearEntityManager(@Disposes final EntityManager em) {
        em.clear();
        em.close();
    }

}
