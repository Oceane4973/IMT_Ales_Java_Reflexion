--
    CREATE DATABASE "TP6_Reflexion" WITH TEMPLATE = template0 ENCODING = 'UTF8';
    ALTER DATABASE "TP6_Reflexion" OWNER TO postgres;
    CREATE TABLE club (
        club_id integer NOT NULL,
        club_version integer NOT NULL,
        club_fabricant character varying(64) NOT NULL,
        club_poids integer NOT NULL
    );
    ALTER TABLE public.club OWNER TO postgres;
    CREATE SEQUENCE club_club_id_seq
        INCREMENT BY 1
        NO MAXVALUE
        NO MINVALUE
        CACHE 1;
    ALTER TABLE public.club_club_id_seq OWNER TO postgres;
    ALTER SEQUENCE club_club_id_seq OWNED BY club.club_id;
    SELECT pg_catalog.setval('club_club_id_seq', 3, true);

    ALTER TABLE club ALTER COLUMN club_id SET DEFAULT nextval('club_club_id_seq'::regclass);

    INSERT INTO club (club_id, club_version, club_fabricant, club_poids) VALUES (1, 2, 'Cyrille', 1);

    ALTER TABLE ONLY club
        ADD CONSTRAINT club_pkey PRIMARY KEY (club_id);
