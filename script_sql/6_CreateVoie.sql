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
  CONSTRAINT voie_pk PRIMARY KEY (id_voie, id_topo, id_secteur, id_site)
);


ALTER SEQUENCE public.voie_id_voie_seq OWNED BY public.voie.id_voie;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (id_secteur, id_site, id_topo)
REFERENCES public.secteur (id_secteur, id_site, id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
