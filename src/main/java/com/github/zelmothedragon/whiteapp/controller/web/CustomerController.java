package com.github.zelmothedragon.whiteapp.controller.web;

import com.github.zelmothedragon.whiteapp.model.entity.Customer;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 * Contrôleur principal pour une entité métier.
 *
 * @author MOSELLE Maxime
 */
@Named
@ViewScoped
public class CustomerController implements Serializable {

    /**
     * Numéro de série.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Entité en cours de manipulation. Cette entité doit avoir le même cycle de
     * vie que cette classe, dans ce dans, il faut modifier l'entité pour une
     * portée du type <code>@Dependent</code>.
     */
    @Inject
    private Customer entity;

    /**
     * Constructeur par défaut. Requis pour le fonctionnement des technologies
     * de Java EE.
     */
    public CustomerController() {
        // Ne pas appeler explicitement
    }

    /**
     * Sauvegarder une entité.Si l'entité n'existe pas elle sera persistée sinon
     * elle sera mise à jour.
     */
    @Transactional
    public void save() {
        this.entity.save();

        // Réinitialiser l'instance courante
        this.entity = Customer.of();
    }

    /**
     * Sélectionner une entité à modifier.
     *
     * @param entity Entité selectionnée pour la mise à jour
     */
    public void edit(final Customer entity) {
        this.entity = entity;
    }

    /**
     * Supprimer une entité.
     *
     * @param entity Une instance à supprimer
     */
    @Transactional
    public void remove(final Customer entity) {
        entity.remove();
    }

    /**
     * Récupérer la liste des d'entités de même type.
     *
     * @return La liste des entité
     */
    public List<Customer> find() {
        return Customer.find();
    }

    // ------------------------
    // Accesseurs & Muttateurs
    // ------------------------
    public Customer getEntity() {
        return entity;
    }

    public void setEntity(Customer entity) {
        this.entity = entity;
    }

}
