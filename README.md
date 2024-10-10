# ORM-Java

Ce TP consiste à créer un ORM basique inspiré d'Hibernate pour persister les données relatives à un club de golf. Les informations du club sont représentées par la classe `Club`, comprenant les attributs suivants :

- `Long id`: Clé primaire
- `int version`: Nombre de fois qu'un objet a été mis à jour (utilisé pour le modèle de verrouillage optimiste).
- `String fabricant`: Nom du fabricant.
- `Double poids`: Poids du club.

L'élément central de notre framework est la classe `EntityManagerImpl`, qui implémente l'interface `javax.persistence.EntityManager`. Les méthodes à implémenter sont les suivantes :

- `void persist(Object entity)`: Pour enregistrer un nouvel objet dans la base de donnée.
- `<T> T merge(T entity)`: Pour modifier un objet dans la base de donnée.
- `<T> T find(Class<T> entityClass, Object primaryKey)`: Utilisée pour trouver un objet en fonction de sa clé primaire.

A été implémenté, également les methodes suivantes: 

- `void remove(Object entity)`: Pour supprimer un objet dans la base de donnée.

## Contexte
Ce travail est un TP demandé par notre enseignant dans le cadre de la formation INFRES - DL (développement logiciel) à l'école des Mines d'alès.

## Utilisation de `EntityManagerImpl`

1. **Création de la table Club en BD :**
   Lors de l'instanciation de `EntityManagerImpl`, la table `Club` est créée en BD. Les informations nécessaires à la création de la table `Club` sont déterminées de manière dynamique en utilisant l'introspection sur la classe `Club` (nom de la classe, nom et type des attributs). La convention considère que l'attribut de nom 'id' est la clé primaire de la classe.

    La table sera conforme à la structure suivante : 
    ```sql
    CREATE SEQUENCE club_club_id_seq START WITH 0 INCREMENT BY 1;
    CREATE TABLE CLUB (
        club_id INTEGER DEFAULT NEXTVAL('CLUB_CLUB_ID_SEQ') PRIMARY KEY, 
        club_version INTEGER, 
        club_fabricant VARCHAR(64), 
        club_poids DOUBLE PRECISION);
    );
    ```

> Note: L'utilisation de EntityManager est conforme à la norme JPA (JSR-000338 JavaTM Persistence). Le pattern DAO est également utilisé comme base pour ce projet, et des références peuvent être trouvées à l'adresse suivante : Mapper sa base de données avec le pattern DAO.

## Utilisation de H2 pour initialiser la base de données

1. **Configuration dans le projet :**

    La base de donnée est une base de donnée H2.
    Pour utiliser H2 en mode mémoire, la dépendance à été ajouté dans le fichier build.gradle :

    ```java
    implementation("com.h2database:h2:2.2.220")
    ```

    Puis à été configurer l'objet ConnectionDatabase pour utiliser la base de données H2 et définir les propriétés de connexion appropriées.

    ```java
    private static String url = "jdbc:h2:tcp://localhost/~/<NOM_DE_LA_BASE_DE_DONNEE>";
    private static String user = "<NOM_UTILISATEUR>";
    private static String passwd = "<MOT_DE_PASSE>";
    ```

    Vous pourrez modifier ces valeurs à votre convenance tant qu'une base de donnée conforme à ces informations existe. 

1. **Création de la base de donnée :**

    Pour créer la base de donnée, vous devez tous d'abord ouvrir une invite de commande et vous rendre dans le dossier /database/h2
    Ensuite, rentrez la commande suivante, vous permettra d'accéder à l'interface graphique pour créer votre base de donnée :

    ```sh
    java -jar bin/h2-2.2.224.jar
    ```

    Une page web s'ouvre. Il suffit de la configurer : 

    | Nom | Valeur |
    | ------ | ------ |
    | Configuration enregistrée | Generic H2 (Embedded) |
    | Nom de configuration | Generic H2 (Embedded) |
    | Pilote JDBC | org.h2.Driver |
    | URL JDBC | jdbc:h2:~/<NOM_DE_LA_BASE_DE_DONNEE> |
    | Nom d'utilisateur | <NOM_UTILISATEUR> |
    | Mot de passe | <MOT_DE_PASSE> |

> Note: Par défault, il a été choisi les valeurs : 
NOM_DE_LA_BASE_DE_DONNEE = "TP6_reflexion"
UTILISATEUR = "user"
MOT_DE_PASSE = "1234"



