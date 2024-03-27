CREATE TABLE IF NOT EXISTS public.scientific_field
(
    id bigint NOT NULL DEFAULT nextval('scientific_field_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT scientific_field_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.scientific_field
    OWNER to nstadmin;