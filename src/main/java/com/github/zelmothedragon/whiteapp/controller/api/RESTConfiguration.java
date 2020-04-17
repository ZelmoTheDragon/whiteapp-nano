package com.github.zelmothedragon.whiteapp.controller.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configuration de la technologie <i>JAX-RS</i>.
 *
 * @author MOSELLE Maxime
 */
@ApplicationPath("/api")
public class RESTConfiguration extends Application {

    /**
     * Constructeur d'injection.Requis pour le fonctionnement des technologies
     * de Jakarta EE.
     */
    public RESTConfiguration() {
        // Ne pas appeler explicitement
    }

}
