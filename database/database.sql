
-- Création de la table club
CREATE TABLE club (
    club_id SERIAL PRIMARY KEY,
    club_version INTEGER,
    club_fabricant VARCHAR(64) NOT NULL,
    club_poids INTEGER
);

-- Insertion de données dans la table club
--INSERT INTO club (club_id, club_version, club_fabricant, club_poids) VALUES (1, 2, 'Cyrille', 1);

-- Suppression de la base de données
-- DROP TABLE IF EXISTS "CLUB";
-- DROP SEQUENCE club_club_id_seq;


