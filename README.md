# WhiteApp

Exemple de portage de la plateforme **Jakarta EE** sur **Tomcat**.

Ce projet est sous licence **CeCILL** (**CE**A **C**NRS **I**NRIA **L**ogiciel **L**ibre),
une licence de logicielle libre compatible avec la **GNU GPL**.

> En savoir plus sur la licence [CeCILL](http://cecill.info/index.fr.html)

Tomcat est un serveur d'application minimaliste.
Il ne supporte nativement que peut de technologies *Jakarta EE*.
Le but de ce projet est de construire une base *Maven* pour portée le plus de brique *Jakarta EE*.
Tout en résolvant les problèmes de dépendances liés aux doublons de classes.
Bien sûr toutes les briques ne sont pas nécessaires dans la plus part des cas. 

## Technologie

Portage des briques *Jakarta EE*:
* [ ] Batch
* [ ] Dependency Injection
* [ ] JACC
* [ ] JAXR
* [ ] JSTL 1.2
* [ ] Management
* [x] BeanValidation 2.0 (Hibernate)
* [ ] Deployment
* [x] JASPIC 1.1 (Tomcat)
* [ ] JMS
* [x] JTA 1.3 (Narayana)
* [x] Servlet 4.0 (Tomcat)
* [x] CDI 2.0 (Weld)
* [ ] EJB 3.2
* [ ] JAX-RPC
* [x] JSF 2.3 (Mojarra)
* [x] JPA 2.2 (Hibernate)
* [ ] Web Services
* [x] Common Annotations (Weld)
* [x] EL 3.0 (Glassfish)
* [x] JAX-RS 2.1 (RestEasy)
* [x] JSON-P 1.0 (RestEasy)
* [ ] JavaMail
* [ ] Web Services Metadata
* [ ] Concurrency EE
* [x] Interceptors (Weld)
* [x] JAX-WS (RestEasy)
* [x] JSP 2.3 (Tomcat)
* [ ] ManagedBeans
* [x] WebSocket (Tomcat)
* [ ] Connector
* [ ] JSP Debugging
* [x] JAXB (RestEasy)
* [x] JSON-B 1.0 (Yasson)
* [x] Security 1.0 (Soteria)

> À amender avec les mises à jour.

![Java EE 8](https://cdn.app.compendium.com/uploads/user/e7c690e8-6ff9-102a-ac6d-e4aebca50425/9f78fc09-faec-4068-82bd-09e7cc8bbf34/File/8f333305d54fb607858e1c48730313b2/screen_shot_2017_08_23_at_5_55_26_pm.png)

## Module

Ce projet ce compose d'un seul module de type **WAR** *(Web ARchive)*.
   
## Architecture

L’architecture logicielle mise en place est **MVC** *(Model View Controller)*.

* *Model*
    * Représente les données métiers et les fonctions de persistance.
* *Controller*
    * Représente la logique de traitement et la gestion des exceptions.
* *View*
    * Représente la partie graphique permettant l’interaction humaine avec l'application.

## Environnement

Ce projet est réalisé en **Java 11** *(OpenJDK)*, **JakartaEE 8** et **Tomcat 9.0.31**.
Il utilise l'outil **Maven** en version 3.6.2.

### Exécution

Récupération du projet:
~~~
    git clone https://github.com/ZelmoTheDragon/whiteapp-nano.git
    mvn install
~~~
