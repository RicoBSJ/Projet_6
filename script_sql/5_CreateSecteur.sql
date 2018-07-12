CREATE SEQUENCE public.secteur_id_secteur_seq;

CREATE TABLE public.secteur (
  id_secteur INTEGER NOT NULL DEFAULT nextval('public.secteur_id_secteur_seq'),
  id_site INTEGER NOT NULL,
  id_topo INTEGER NOT NULL,
  nom_secteur VARCHAR(100) NOT NULL,
  difficulte VARCHAR(10) NOT NULL,
  orientation VARCHAR(100) NOT NULL,
  description VARCHAR(500) NOT NULL,
  CONSTRAINT secteur_pk PRIMARY KEY (id_secteur, id_topo, id_site)
);


ALTER SEQUENCE public.secteur_id_secteur_seq OWNED BY public.secteur.id_secteur;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (id_site, id_topo)
REFERENCES public.site (id_site, id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;