CREATE SEQUENCE public.topo_id_topo_seq;

CREATE TABLE public.topo (
  id_topo INTEGER NOT NULL DEFAULT nextval('public.topo_id_topo_seq'),
  id_utilisateur_createur INTEGER NOT NULL,
  nom_topo VARCHAR(100) NOT NULL,
  id_emprunteur INTEGER,
  region VARCHAR(50) NOT NULL,
  lieu VARCHAR(100) NOT NULL,
  roche VARCHAR(50) NOT NULL,
  profil VARCHAR(100) NOT NULL,
  ancrage VARCHAR(100) NOT NULL,
  relai VARCHAR(100) NOT NULL,
  disponible BOOLEAN NOT NULL,
  description VARCHAR(500) NOT NULL,
  CONSTRAINT topo_pk PRIMARY KEY (id_topo)
);


ALTER SEQUENCE public.topo_id_topo_seq OWNED BY public.topo.id_topo;

ALTER TABLE public.topo ADD CONSTRAINT utilisateur_topo_fk
FOREIGN KEY (id_utilisateur_createur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
  NOT DEFERRABLE;