CREATE SEQUENCE public.site_id_site_seq;

CREATE TABLE public.site (
  id_site INTEGER NOT NULL DEFAULT nextval('public.site_id_site_seq'),
  id_topo INTEGER NOT NULL,
  nom_site VARCHAR(100) NOT NULL,
  description VARCHAR(500) NOT NULL,
  altitudePiedVoie REAL NOT NULL,
  CONSTRAINT site_pk PRIMARY KEY (id_site, id_topo)
);


ALTER SEQUENCE public.site_id_site_seq OWNED BY public.site.id_site;

ALTER TABLE public.site ADD CONSTRAINT topo_site_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;