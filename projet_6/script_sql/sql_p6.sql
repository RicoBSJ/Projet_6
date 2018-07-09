
CREATE SEQUENCE public.utilisateur_id_utilisateur_seq;

CREATE TABLE public.utilisateur (
                id_utilisateur INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_utilisateur_seq'),
                nom VARCHAR(100) NOT NULL,
                prenom VARCHAR(50) NOT NULL,
                mail VARCHAR(150) NOT NULL,
                telephone VARCHAR(15) NOT NULL,
                admin BOOLEAN NOT NULL,
                mot_de_passe VARCHAR(50) NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur)
);


ALTER SEQUENCE public.utilisateur_id_utilisateur_seq OWNED BY public.utilisateur.id_utilisateur;

CREATE SEQUENCE public.topo_id_topo_seq;

CREATE TABLE public.topo (
                id_topo INTEGER NOT NULL DEFAULT nextval('public.topo_id_topo_seq'),
                id_utilisateur_createur INTEGER NOT NULL,
                nom_topo VARCHAR(100) NOT NULL,
                id_empreunteur INTEGER,
                region VARCHAR(50) NOT NULL,
                lieu VARCHAR(100) NOT NULL,
                rocher VARCHAR(50) NOT NULL,
                profil VARCHAR(100) NOT NULL,
                ancrage VARCHAR(100) NOT NULL,
                relai VARCHAR(100) NOT NULL,
                etat BOOLEAN NOT NULL,
                description VARCHAR(500) NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id_topo)
);


ALTER SEQUENCE public.topo_id_topo_seq OWNED BY public.topo.id_topo;

CREATE SEQUENCE public.site_id_site_seq;

CREATE TABLE public.site (
                id_site INTEGER NOT NULL DEFAULT nextval('public.site_id_site_seq'),
                id_topo INTEGER NOT NULL,
                nom_site VARCHAR(100) NOT NULL,
                description VARCHAR(500) NOT NULL,
                altitudePiedVoie REAL NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (id_site)
);


ALTER SEQUENCE public.site_id_site_seq OWNED BY public.site.id_site;

CREATE SEQUENCE public.secteur_id_secteur_seq;

CREATE TABLE public.secteur (
                id_secteur INTEGER NOT NULL DEFAULT nextval('public.secteur_id_secteur_seq'),
                id_site INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                nom_secteur VARCHAR(100) NOT NULL,
                difficulte VARCHAR(10) NOT NULL,
                orientation VARCHAR(100) NOT NULL,
                description VARCHAR(500) NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id_secteur)
);


ALTER SEQUENCE public.secteur_id_secteur_seq OWNED BY public.secteur.id_secteur;

CREATE SEQUENCE public.voie_id_voie_seq;

CREATE TABLE public.voie (
                id_voie INTEGER NOT NULL DEFAULT nextval('public.voie_id_voie_seq'),
                id_site INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                id_secteur INTEGER NOT NULL,
                nom_voie VARCHAR(100) NOT NULL,
                cotation VARCHAR(100) NOT NULL,
                hauteur REAL NOT NULL,
                description VARCHAR(500) NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id_voie)
);


ALTER SEQUENCE public.voie_id_voie_seq OWNED BY public.voie.id_voie;

CREATE SEQUENCE public.commentaire_id_commentaire_seq;

CREATE TABLE public.commentaire (
                id_commentaire INTEGER NOT NULL DEFAULT nextval('public.commentaire_id_commentaire_seq'),
                id_utilisateur_com INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                texte_com VARCHAR(1000) NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (id_commentaire, id_utilisateur_com, id_topo)
);


ALTER SEQUENCE public.commentaire_id_commentaire_seq OWNED BY public.commentaire.id_commentaire;

ALTER TABLE public.commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (id_utilisateur_com)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT utilisateur_topo_fk
FOREIGN KEY (id_utilisateur_possesseur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT topo_commentaire_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT topo_site_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (id_site, id_topo)
REFERENCES public.site (id_site, id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (id_secteur, id_site, id_topo)
REFERENCES public.secteur (id_secteur, id_site, id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
