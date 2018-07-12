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

ALTER TABLE public.commentaire ADD CONSTRAINT topo_commentaire_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;