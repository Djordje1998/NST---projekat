CREATE TABLE IF NOT EXISTS public.academic_title
(
    id bigint NOT NULL DEFAULT nextval('academic_title_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT academic_title_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.academic_title
    OWNER to nstadmin;